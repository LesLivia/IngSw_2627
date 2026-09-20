package basi_oop.poliflix.utenti;

import java.util.List;
import java.util.Scanner;

public class ManagerUtenti {
    private List<Utente> utenti;
    private Utente utenteLoggato;

    public ManagerUtenti(List<Utente> utenti) {
        this.utenti = utenti;
        this.utenteLoggato = new Utente(null, null);
    }

    public List<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }

    public Utente getUtenteLoggato() {
        return utenteLoggato;
    }

    public void setUtenteLoggato(Utente utenteLoggato) {
        this.utenteLoggato = utenteLoggato;
    }

    private boolean esisteUtente(String username) {
        for (Utente utente : utenti)
            if (utente.getUsername().equals(username)) {
                System.out.println("Username già esistente!");
                return true;
            }
        return false;
    }

    public void registraUtente() {
        Scanner scanner = new Scanner(System.in);

        Utente new_utente = new Utente(null, null);
        String new_username;
        do {
            System.out.println("Inserisci username:");
            new_username = scanner.nextLine();
            new_utente.setUsername(new_username);
            System.out.println("Inserisci password:");
            new_utente.setPassword(scanner.nextLine());
        } while (esisteUtente(new_username));

        this.utenti.add(new_utente);

        System.out.println("Utente " +
                this.getUtenti().getLast().getUsername() +
                " registrato con successo!");
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        Utente tentativo_login = new Utente(null, null);

        System.out.println("Inserisci username:");
        tentativo_login.setUsername(scanner.nextLine());
        System.out.println("Inserisci password:");
        tentativo_login.setPassword(scanner.nextLine());

        for (Utente utente : utenti)
            if (utente.equals(tentativo_login)) {
                this.utenteLoggato = utente;
                System.out.println("Login effettuato con successo!");
                return;
            }
        System.out.println("Username o password errati!");
    }

    public boolean loginEffettuato() {
        return this.utenteLoggato.nonNullo();
    }

    public void benvenutoUtente() {
        System.out.println("\n\nBentornato " + this.utenteLoggato.getUsername() + "!");
    }


}
