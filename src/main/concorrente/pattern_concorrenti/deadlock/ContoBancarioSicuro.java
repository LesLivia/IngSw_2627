package concorrente.pattern_concorrenti.deadlock;

/**
 * Conto che evita il deadlock: ogni trasferimento acquisisce i lock in ordine di id.
 */
public class ContoBancarioSicuro {
    private final int id;
    private final String nome;
    private int saldo;

    public ContoBancarioSicuro(int id, String nome, int saldo) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
    }

    public void trasferisciVerso(ContoBancarioSicuro destinatario, int importo) {
        ContoBancarioSicuro primo = this.id < destinatario.id ? this : destinatario;
        ContoBancarioSicuro secondo = this.id < destinatario.id ? destinatario : this;

        synchronized (primo) {
            synchronized (secondo) {
                this.saldo -= importo;
                destinatario.saldo += importo;
                System.out.println(Thread.currentThread().getName() + ": trasferiti " + importo
                        + " da " + this.nome + " a " + destinatario.nome);
            }
        }
    }

    public synchronized int getSaldo() {
        return this.saldo;
    }
}
