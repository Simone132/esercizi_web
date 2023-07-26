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
            String sql = "SELECT prodotti.nome AS nome_prodotto, prodotti.quantita, prodotti.prezzo, categorie.nome AS nome_categoria " +
                         "FROM prodotti " +
                         "JOIN categorie ON prodotti.id_categoria = categorie.id;";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Preparo il file CSV
            FileWriter fileWriter = new FileWriter("prodotti_categorie.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Nome Prodotto, Quantita, Prezzo, Categoria");  // Intestazione del CSV

            // Stampo i risultati nel file CSV
            while (rs.next()) {
                String nomeProdotto = rs.getString("nome_prodotto");
                int quantita = rs.getInt("quantita");
                double prezzo = rs.getDouble("prezzo");
                String nomeCategoria = rs.getString("nome_categoria");

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