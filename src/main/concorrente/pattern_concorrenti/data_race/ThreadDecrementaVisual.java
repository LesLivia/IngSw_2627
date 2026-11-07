package concorrente.pattern_concorrenti.data_race;

public class ThreadDecrementaVisual extends Thread {
    private Serie conto;

    public ThreadDecrementaVisual(Serie conto) {
        this.conto = conto;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            this.conto.decrementa(1);
        }
    }

}
