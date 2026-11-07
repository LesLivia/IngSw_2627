package concorrente.pattern_concorrenti.producer_consumer;

import java.util.concurrent.TimeUnit;

public class ThreadConsumatoreStampe extends Thread {
    private final CodaStampeLimitata coda;
    private final int numeroDocumenti;

    public ThreadConsumatoreStampe(String nome, CodaStampeLimitata coda, int numeroDocumenti) {
        super(nome);
        this.coda = coda;
        this.numeroDocumenti = numeroDocumenti;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numeroDocumenti; i++) {
                String documento = coda.preleva();
                System.out.println(getName() + ": stampo " + documento);
                TimeUnit.MILLISECONDS.sleep(300);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
