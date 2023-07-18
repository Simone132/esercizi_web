import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        String csvFile = "prodotto.csv";
        String line = "";
        String cvsSplitBy = ",";
        int contatoreFrutta = 0; // inserisco una variabile come indice dei prodotti trovati

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine(); // Salta l'intestazione del file CSV

            while ((line = br.readLine()) != null) {

                // Usa la virgola come separatore
                String[] prodotto = line.split(cvsSplitBy);

                // Controlla se la categoria è "Frutta"
                if (prodotto[2].equalsIgnoreCase("Frutta")) {
                    contatoreFrutta++;
                }
            }

            System.out.println("Il numero totale di frutta nel file CSV è: " + contatoreFrutta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
