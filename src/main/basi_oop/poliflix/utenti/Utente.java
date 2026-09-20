package basi_oop.poliflix.utenti;

public class Utente {
    private String username;
    private String password;

    public Utente(String u, String p) {
        username = u;
        password = p;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(Utente other) {
        boolean stessoUsername = this.getUsername().equals(other.getUsername());
        boolean stessaPassword = this.getPassword().equals(other.getPassword());
        return stessoUsername && stessaPassword;
    }

    public boolean nonNullo() {
        return this.username != null && this.password != null;
    }

}
