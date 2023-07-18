import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String csvFile = "prodotto.csv";
        String line = "";
        String cvsSplitBy = ",";
        Scanner scanner = new Scanner(System.in); // ricevi input da utenti

        System.out.println("Inserisci una data nel formato YYYY-MM-DD:");
        String dataInserita = scanner.nextLine(); // assegna alla variabile dataInserits l'input degli utenti

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