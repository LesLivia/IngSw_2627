package warm_up;

import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {
        int x = 10;

        System.out.println(x);
        System.out.println(x * 2);

        String test = new String("Hello");
        String test2 = new String("Hello");

        System.out.println(test);
        System.out.println(test + " World!");

        if (test.equals(test2))
            System.out.println("Le stringhe sono uguali");
        else
            System.out.println("Le stringhe NON sono uguali");

        if (test == test2)
            System.out.println("Le stringhe sono uguali");
        else
            System.out.println("Le stringhe NON sono uguali");

        Scanner scanner = new Scanner(System.in);
        String input_utente;

        boolean continua = true;
        while (continua) {
            x = x * 2;
            System.out.println(x);

            // Legge da console
            input_utente = scanner.nextLine();
            System.out.println("Hai inserito: " + input_utente);
            continua = !input_utente.equals("esci");
        }

    }
}
