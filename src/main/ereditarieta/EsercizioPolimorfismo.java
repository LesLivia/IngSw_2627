package ereditarieta;

class Documento {
    public void stampa() {
        System.out.println("D");
    }

    public void invia(Documento d) {
        System.out.println("DD");
    }
}

class PDF extends Documento {
    @Override
    public void stampa() {
        System.out.println("P");
    }

    @Override
    public void invia(Documento d) {
        System.out.println("PD");
    }

    public void invia(PDF p) {
        System.out.println("PP");
    }
}

class PDFProtetto extends PDF {
    @Override
    public void stampa() {
        System.out.println("X");
    }

    @Override
    public void invia(Documento d) {
        System.out.println("XD");
    }

    public void invia(PDF p) {
        System.out.println("XP");
    }
}

class Testo extends Documento {
    @Override
    public void stampa() {
        System.out.println("T");
    }

    public void cancellaParola(String parola) {
        System.out.println("Cancello..." + parola);
    }
}

public class EsercizioPolimorfismo {
    static void main(String[] args) {
        Documento d1 = new Documento();
        Documento d2 = new PDF();
        PDF d3 = new PDFProtetto();
        Documento d4 = new PDFProtetto();
        Documento d5 = new Testo();
        PDF d6 = new PDF();
        PDFProtetto d7 = new PDFProtetto();

        System.out.println("Overriding: ");

        d1.stampa();                       // ?
        d2.stampa();                       // ?
        d3.stampa();                       // ?
        d4.stampa();                       // ?
        d5.stampa();                       // ?

        System.out.println("---\nOverloading: ");

        d6.invia(d2);
        d6.invia(d3);
        d6.invia(d4);
        d6.invia(d7);

        System.out.println("---\nOverriding + Overloading: ");

        d2.invia(d3);                      // ?
        d3.invia(d3);                      // ?
        d3.invia(d4);                      // ?
        d4.invia(d3);                      // ?
        d5.invia(d3);                      // ?

        System.out.println("---\nCasting: ");

        ((PDF) d4).invia(d3);              // ?
        ((PDF) d2).invia(d3);              // ?
    }
}