package concorrente.pattern_concorrenti.deadlock;

public class ThreadTrasferimentoSicuro extends Thread {
    private final ContoBancarioSicuro sorgente;
    private final ContoBancarioSicuro destinatario;

    public ThreadTrasferimentoSicuro(String nome, ContoBancarioSicuro sorgente,
                                     ContoBancarioSicuro destinatario) {
        super(nome);
        this.sorgente = sorgente;
        this.destinatario = destinatario;
    }

    @Override
    public void run() {
        sorgente.trasferisciVerso(destinatario, 10);
    }
}
