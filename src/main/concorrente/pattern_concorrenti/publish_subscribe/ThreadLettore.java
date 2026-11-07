package concorrente.pattern_concorrenti.publish_subscribe;

public class ThreadLettore extends Thread {
    private String name;
    private int indiceLettore;
    private BufferCondiviso buffer;

    public ThreadLettore(BufferCondiviso buffer, int indiceLettore, String name) {
        this.name = name;
        this.indiceLettore = indiceLettore;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++)
                System.out.println(this.name + ": Letto: " + this.buffer.leggi(this.indiceLettore));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
