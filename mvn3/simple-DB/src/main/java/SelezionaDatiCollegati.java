
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelezionaDatiCollegati {

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

            // Stampo i risultati
            while (rs.next()) {
                String nomeProdotto = rs.getString("nome_prodotto");
                int quantita = rs.getInt("quantita");
                double prezzo = rs.getDouble("prezzo");
                String nomeCategoria = rs.getString("nome_categoria");

                System.out.println("Nome Prodotto: " + nomeProdotto + ", Quantita: " + quantita +
                        ", Prezzo: " + prezzo + ", Categoria: " + nomeCategoria);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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