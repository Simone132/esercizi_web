import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        String csvFile = "prodotto.csv";
        String header = "nome_prodotto, quantita, categoria_prodotto, prezzo_prodotto\n";
        String[] data = {
                "1,Mela,100,Frutta,0.6",
                "2,Banana,80,Frutta,0.3"
        };

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(csvFile);


            fileWriter.append(header);


            for (String line : data) {
                fileWriter.append(line);
                fileWriter.append("\n");
            }

            System.out.println("File CSV creato con successo.");
        } catch (Exception e) {
            System.out.println("Errore in CsvFileWriter.");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Errore durante il flush/close del fileWriter.");
                e.printStackTrace();
            }
        }
    }
}


