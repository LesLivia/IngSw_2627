package basi_oop.poliflix.serie;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ManagerSerie {
    private List<Serie> serie;

    public ManagerSerie(String pathCatalogoSerie) throws IOException {
        this.serie = Serie.importaCatalogoSerieDaCsv(pathCatalogoSerie);
    }

    public List<Serie> getSerie() {
        return serie;
    }

    public void setSerie(List<Serie> serie) {
        this.serie = serie;
    }

    public void stampaCatalogoSerie() {
        int i = 1;
        for (Serie s : serie) {
            System.out.println(i + " Titolo: " + s.getNome() +
                    " - " + s.getEpisodi().size() + " episodi");
            i++;
        }
    }

    public void guardaSerie(String nomeSerie) throws InterruptedException {
        Serie serieScelta = null;

        for (Serie s : serie) {
            if (s.getNome().equalsIgnoreCase(nomeSerie))
                serieScelta = s;
        }

        if (serieScelta == null) {
            System.out.println("Serie non trovata.");
            return;
        }

        for (Episodio e : serieScelta.getEpisodi()) {
            System.out.println("Riproduzione: " + e.getTitolo() + " in corso...");
            TimeUnit.SECONDS.sleep(e.getDurata());
        }
    }
}
