package basi_oop.file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TestFile {
    static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter("./resources/files/output.txt");
        writer.println("Ciao mondo!");
        writer.println("Altra riga");
        writer.close();

        System.out.println("Lettura con BufferedReader:");
        BufferedReader reader = new BufferedReader(new FileReader("./resources/files/output.txt"));
        String line;
        while ((line = reader.readLine()) != null)
            System.out.println(line);
        reader.close();

        System.out.println("\nLettura con Scanner:");
        Scanner scanner = new Scanner(new File("./resources/files/output.txt"));
        while (scanner.hasNextLine()) {
            String newLine = scanner.nextLine();
            System.out.println(newLine);
        }
        scanner.close();

        System.out.println("\nLettura con Files:");
        List<String> righe = Files.readAllLines(Paths.get("./resources/files/output.txt"));
        for (String riga : righe)
            System.out.println(riga);
    }
}
