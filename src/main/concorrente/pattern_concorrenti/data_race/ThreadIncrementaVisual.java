package concorrente.pattern_concorrenti.data_race;

public class ThreadIncrementaVisual extends Thread {
    private Serie conto;

    public ThreadIncrementaVisual(Serie conto) {
        this.conto = conto;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            this.conto.incrementa(1);
        }
    }

}
