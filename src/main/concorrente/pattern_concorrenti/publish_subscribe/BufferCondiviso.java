package concorrente.pattern_concorrenti.publish_subscribe;

public class BufferCondiviso {
    private final long[] ultimaVersioneLetta;
    private String messaggio;
    private long versioneMessaggio;
    private int lettoriDaServire;

    public BufferCondiviso(int numeroLettori) {
        if (numeroLettori <= 0)
            throw new IllegalArgumentException("Il buffer richiede almeno un lettore");

        this.ultimaVersioneLetta = new long[numeroLettori];
        this.messaggio = null;
        this.versioneMessaggio = 0;
        this.lettoriDaServire = 0;
    }

    public synchronized void scrivi(String messaggio) throws InterruptedException {
        while (this.lettoriDaServire > 0)
            wait();

        this.messaggio = messaggio;
        this.versioneMessaggio++;
        this.lettoriDaServire = this.ultimaVersioneLetta.length;
        notifyAll();
    }

    public synchronized String leggi(int indiceLettore) throws InterruptedException {
        if (indiceLettore < 0 || indiceLettore >= this.ultimaVersioneLetta.length)
            throw new IllegalArgumentException("Indice lettore non valido: " + indiceLettore);

        while (this.ultimaVersioneLetta[indiceLettore] == this.versioneMessaggio)
            wait();

        this.ultimaVersioneLetta[indiceLettore] = this.versioneMessaggio;
        this.lettoriDaServire--;
        notifyAll();
        return this.messaggio;
    }
}
