package concorrente.pattern_concorrenti.data_race;

import java.util.ArrayList;
import java.util.List;

public class MainVisualizzazioniSerie {
    static void main(String[] args) {
        Serie serieTest = new Serie(1);

        int N = 0, maxThreads = 300;

        do {
            N++;

            System.out.println("Provo con " + N + " thread in parallelo...");

            List<ThreadIncrementaVisual> threadsIncrementa = new ArrayList<>();
            List<ThreadDecrementaVisual> threadsDecrementa = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                threadsIncrementa.add(new ThreadIncrementaVisual(serieTest));
                threadsDecrementa.add(new ThreadDecrementaVisual(serieTest));
            }

            for (int i = 0; i < threadsIncrementa.size(); i++) {
                threadsIncrementa.get(i).start();
                threadsDecrementa.get(i).start();
            }

            try {
                for (int i = 0; i < threadsIncrementa.size(); i++) {
                    threadsIncrementa.get(i).join();
                    threadsDecrementa.get(i).join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (serieTest.getVisualizzazioni() == 1 && N < maxThreads);

        if (serieTest.getVisualizzazioni() != 1) {
            System.out.println("!!! Rotto con: " + N + "thread in parallelo");
            System.out.println("!!! Visualizzazioni: " + serieTest.getVisualizzazioni());
        } else
            System.out.println("Classe Serie thread-safe");

    }
}
