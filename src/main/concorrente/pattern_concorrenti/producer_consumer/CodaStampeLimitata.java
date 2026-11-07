package concorrente.pattern_concorrenti.producer_consumer;

import java.util.ArrayDeque;
import java.util.Queue;

/** Buffer limitato condiviso fra produttori di documenti e stampanti. */
public class CodaStampeLimitata {
    private final Queue<String> documenti = new ArrayDeque<>();
    private final int capacita;

    public CodaStampeLimitata(int capacita) {
        if (capacita <= 0)
            throw new IllegalArgumentException("La capacita deve essere positiva");
        this.capacita = capacita;
    }

    public synchronized void inserisci(String documento) throws InterruptedException {
        while (documenti.size() == capacita) {
            System.out.println(Thread.currentThread().getName() + ": coda piena, attendo...");
            wait();
        }

        documenti.add(documento);
        System.out.println(Thread.currentThread().getName() + ": accodato " + documento
                + " (" + documenti.size() + "/" + capacita + ")");
        notifyAll();
    }

    public synchronized String preleva() throws InterruptedException {
        while (documenti.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + ": coda vuota, attendo...");
            wait();
        }

        String documento = documenti.remove();
        notifyAll();
        return documento;
    }
}
