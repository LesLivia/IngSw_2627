package concorrente.pattern_concorrenti.producer_consumer;

public class MainProducerConsumerStampe {
    static void main(String[] args) throws InterruptedException {
        CodaStampeLimitata coda = new CodaStampeLimitata(2);

        ThreadProduttoreStampe produttoreAlice = new ThreadProduttoreStampe(
                "Produttore Alice", coda, "Alice-1.pdf", "Alice-2.pdf", "Alice-3.pdf");
        ThreadProduttoreStampe produttoreBob = new ThreadProduttoreStampe(
                "Produttore Bob", coda, "Bob-1.pdf", "Bob-2.pdf", "Bob-3.pdf");
        ThreadConsumatoreStampe stampanteUno = new ThreadConsumatoreStampe("Stampante 1", coda, 3);
        ThreadConsumatoreStampe stampanteDue = new ThreadConsumatoreStampe("Stampante 2", coda, 3);

        stampanteUno.start();
        stampanteDue.start();
        produttoreAlice.start();
        produttoreBob.start();

        produttoreAlice.join();
        produttoreBob.join();
        stampanteUno.join();
        stampanteDue.join();

        System.out.println("Tutti i documenti sono stati stampati.");
    }
}
