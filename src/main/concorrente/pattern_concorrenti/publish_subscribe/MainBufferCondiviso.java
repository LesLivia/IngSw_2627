package concorrente.pattern_concorrenti.publish_subscribe;

import java.util.ArrayList;
import java.util.List;

public class MainBufferCondiviso {
    static void main(String[] args) {
        int n_lettori = 10;
        BufferCondiviso buffer = new BufferCondiviso(n_lettori);
        ThreadScrittore scrittore = new ThreadScrittore(buffer);

        List<ThreadLettore> lettori = new ArrayList<>();
        for (int i = 0; i < n_lettori; i++) {
            lettori.add(new ThreadLettore(buffer, i, "Lettore " + i));
        }

        scrittore.start();

        for (ThreadLettore lettore : lettori)
            lettore.start();

    }
}
