package concorrente.pattern_concorrenti.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * Esempio volutamente non sicuro: due trasferimenti opposti possono generare un deadlock.
 */
public class ContoBancario {
    private final String nome;
    private int saldo;

    public ContoBancario(String nome, int saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    public void trasferisciVerso(ContoBancario destinatario, int importo) throws InterruptedException {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName()
                    + " ha bloccato il conto " + this.nome);

            // Aumenta la probabilità che l'altro thread blocchi il proprio conto nel frattempo.
            TimeUnit.MILLISECONDS.sleep(100);

            System.out.println(Thread.currentThread().getName()
                    + " attende il conto " + destinatario.nome);

            synchronized (destinatario) {
                this.saldo -= importo;
                destinatario.saldo += importo;
            }
        }
    }

    public synchronized int getSaldo() {
        return this.saldo;
    }
}
