package concorrente.pattern_concorrenti.deadlock;

public class MainDeadlockTrasferimenti {
    public static void main(String[] args) throws InterruptedException {
        ContoBancario contoAlice = new ContoBancario("Alice", 100);
        ContoBancario contoBob = new ContoBancario("Bob", 100);

        ThreadTrasferimento aliceVersoBob = new ThreadTrasferimento(
                "Alice -> Bob", contoAlice, contoBob);
        ThreadTrasferimento bobVersoAlice = new ThreadTrasferimento(
                "Bob -> Alice", contoBob, contoAlice);

        // I thread rimangono bloccati di proposito; daemon permette al programma di terminare.
        aliceVersoBob.setDaemon(true);
        bobVersoAlice.setDaemon(true);
        aliceVersoBob.start();
        bobVersoAlice.start();

        aliceVersoBob.join(500);
        bobVersoAlice.join(500);

        if (aliceVersoBob.isAlive() && bobVersoAlice.isAlive()) {
            System.out.println("Deadlock: ogni trasferimento possiede un conto e attende l'altro.");
        } else {
            System.out.println("Nessun deadlock in questa esecuzione: riprova per osservare un'interleaving diverso.");
        }

        System.out.println("\nVersione sicura con ordine globale dei lock:");
        ContoBancarioSicuro contoAliceSicuro = new ContoBancarioSicuro(1, "Alice", 100);
        ContoBancarioSicuro contoBobSicuro = new ContoBancarioSicuro(2, "Bob", 100);

        ThreadTrasferimentoSicuro aliceVersoBobSicuro = new ThreadTrasferimentoSicuro(
                "Alice -> Bob (safe)", contoAliceSicuro, contoBobSicuro);
        ThreadTrasferimentoSicuro bobVersoAliceSicuro = new ThreadTrasferimentoSicuro(
                "Bob -> Alice (safe)", contoBobSicuro, contoAliceSicuro);

        aliceVersoBobSicuro.start();
        bobVersoAliceSicuro.start();
        aliceVersoBobSicuro.join();
        bobVersoAliceSicuro.join();

        System.out.println("Saldi finali safe: Alice=" + contoAliceSicuro.getSaldo()
                + ", Bob=" + contoBobSicuro.getSaldo());
    }
}
