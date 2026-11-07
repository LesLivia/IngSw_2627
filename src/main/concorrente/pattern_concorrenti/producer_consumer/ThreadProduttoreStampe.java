package concorrente.pattern_concorrenti.producer_consumer;

import java.util.concurrent.TimeUnit;

public class ThreadProduttoreStampe extends Thread {
    private final CodaStampeLimitata coda;
    private final String[] documenti;

    public ThreadProduttoreStampe(String nome, CodaStampeLimitata coda, String... documenti) {
        super(nome);
        this.coda = coda;
        this.documenti = documenti;
    }

    @Override
    public void run() {
        try {
            for (String documento : documenti) {
                coda.inserisci(documento);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
