package es11;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String csvFile = "prodotto.csv";
        String line = "";
        String cvsSplitBy = ","; // specifica il divisore del csv

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // Usa la virgola come separatore
                String[] prodotto = line.split(cvsSplitBy); // il metodo split divide il csv al delimitatore

                System.out.println("Prodotto [ID=" + prodotto[0] 
                        + ", Nome=" + prodotto[1] 
                        + ", Categoria=" + prodotto[2]
                        + ", Prezzo=" + prodotto[3]
                        + ", Quantita=" + prodotto[4]
                        + ", DataVendita=" + prodotto[5] + "]");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}