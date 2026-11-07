package concorrente.pattern_concorrenti.deadlock;

public class ThreadTrasferimento extends Thread {
    private final ContoBancario sorgente;
    private final ContoBancario destinatario;

    public ThreadTrasferimento(String nome, ContoBancario sorgente, ContoBancario destinatario) {
        super(nome);
        this.sorgente = sorgente;
        this.destinatario = destinatario;
    }

    @Override
    public void run() {
        try {
            sorgente.trasferisciVerso(destinatario, 10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
