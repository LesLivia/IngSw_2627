package basi_oop.poliflix.serie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Serie {
    String nome;
    private List<Episodio> episodi;

    public Serie(String nome) {
        this.nome = nome;
        this.episodi = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Episodio> getEpisodi() {
        return episodi;
    }

    public void setEpisodi(List<Episodio> episodi) {
        this.episodi = episodi;
    }

    public static Serie serieEsistenteInLista(List<Serie> listaSerie, String nomeSerie) {
        for (Serie s : listaSerie)
            if (s.getNome().equals(nomeSerie))
                return s;
        return null;
    }

    public static List<Serie> importaCatalogoSerieDaCsv(String pathFile) throws IOException {
        List<String> righe = Files.readAllLines(Path.of(pathFile));

        List<Serie> nuoveSerie = new ArrayList<>();

        for (String riga : righe) {
            // pulizia stringhe da eventuali spazi iniziali e finali
            String rigaPulita = riga.trim();
            String[] campi = rigaPulita.split(";");
            String nomeSerie = campi[0].trim();

            // episodio da aggiungere a serie già trovata o nuova serie
            // se ne è la prima occorrenza nel file
            Episodio nuovoEpisodio = new Episodio(campi[1].trim(), Integer.parseInt(campi[2].trim()));

            // restituisce null se la serie non è già presente nella lista
            Serie serieEsistente = serieEsistenteInLista(nuoveSerie, nomeSerie);

            if (serieEsistente != null)
                // se la serie è già presente nella lista, aggiungo l'episodio
                serieEsistente.getEpisodi().add(nuovoEpisodio);
            else {
                // se la serie è nuova, creo una nuova istanza di Serie e aggiungo l'episodio
                Serie nuovaSerie = new Serie(nomeSerie);
                nuovaSerie.getEpisodi().add(nuovoEpisodio);
                nuoveSerie.add(nuovaSerie);
            }
        }

        return nuoveSerie;
    }

}
