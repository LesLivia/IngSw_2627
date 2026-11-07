package concorrente.pattern_concorrenti.data_race;

public class Serie {
    private int visualizzazioni;

    public Serie(int visualizzazioni) {
        this.visualizzazioni = visualizzazioni;
    }

    public int getVisualizzazioni() {
        return visualizzazioni;
    }

    public synchronized void incrementa(int quantita) {
        this.visualizzazioni += quantita;
    }

    public synchronized void decrementa(int quantita) {
        this.visualizzazioni -= quantita;
    }
}
