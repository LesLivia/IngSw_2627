package concorrente.pattern_concorrenti.publish_subscribe;


import java.util.concurrent.TimeUnit;

public class ThreadScrittore extends Thread {
    private BufferCondiviso buffer;

    public ThreadScrittore(BufferCondiviso buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        String[] messaggi = {"ciao", "buongiorno", "buonasera"};

        try {
            for (String m : messaggi) {
                buffer.scrivi(m);
                System.out.println("Scritto: " + m);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
