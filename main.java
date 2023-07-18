import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String csvFile = "prodotto.csv";
        String line = "";
        String cvsSplitBy = ",";
        Set<String> dateUniche = new HashSet<>(); // crei una tabella che conterrà la date senza ripetizioni
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine(); // Salta l'intestazione del file CSV

            while ((line = br.readLine()) != null) {

                // Usa la virgola come separatore
                String[] prodotto = line.split(cvsSplitBy);

                // Aggiungi la data al set delle date uniche
                dateUniche.add(prodotto[5]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Stampa tutte le date uniche disponibili
        System.out.println("Date disponibili:");
        for (String data : dateUniche) {
            System.out.println(data);
        }

        System.out.println("Inserisci una data tra quelle elencate sopra:");
        String dataInserita = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine(); // Salta l'intestazione del file CSV

            while ((line = br.readLine()) != null) {

                // Usa la virgola come separatore
                String[] prodotto = line.split(cvsSplitBy);

                // Controlla se la data coincide con quella inserita dall'utente
                if (prodotto[5].equals(dataInserita)) {
                    System.out.println("Prodotto [ID=" + prodotto[0] 
                        + ", Nome=" + prodotto[1] 
                        + ", Categoria=" + prodotto[2]
                        + ", Prezzo=" + prodotto[3]
                        + ", Quantita=" + prodotto[4]
                        + ", DataVendita=" + prodotto[5] + "]");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}