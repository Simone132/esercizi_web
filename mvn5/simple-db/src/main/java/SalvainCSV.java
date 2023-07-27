import java.sql.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SalvainCSV {

    public static void main(String[] args) {

        Connection conn = null;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:database_collegato.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            // Eseguo la query JOIN
            String sql = "SELECT prodotti.referto AS ID_paziente, nome_paziente, cognome_paziente, numero_stanza AS nome_referto " +
            "FROM prodotti " +
            "JOIN prodotti ON prodotti.id_referto = prodotti.id;";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Preparo il file CSV
            FileWriter fileWriter = new FileWriter("referto.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("id,Nome,Cognome,stanza,dimissione");  // Intestazione del CSV

            // Stampo i risultati nel file CSV
            while (rs.next()) {
                String nomeProdotto = rs.getString("nome_paziente");
                String quantita = rs.getString("Cognome");
                int prezzo = rs.getInt("Stanza");
                String nomeCategoria = rs.getString("dimissione");

                printWriter.println(nomeProdotto + ", " + quantita + ", " + prezzo + ", " + nomeCategoria);
            }

            printWriter.close();
            System.out.println("I dati sono stati salvati nel file 'prodotti_categorie.csv'.");

        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}