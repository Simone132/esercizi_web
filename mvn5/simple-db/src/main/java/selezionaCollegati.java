
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class selezionaCollegati {

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
            String sql = "SELECT prodotti.nome AS nome_paziente, referto.cognome_paziente, referto.numero_stanza, referto.dimissione referto.letto_paziente AS nome_paziente " +
                         "FROM prodotti " +
                         "JOIN rodotti ON referto.id_referto = prodotti.id;";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Stampo i risultati
            while (rs.next()) {
                String nomeProdotto = rs.getString("nome_paziente");
                int quantita = rs.getInt("cognome_paziente");
                String prezzo = rs.getString("dimissione");
                int nomeCategoria = rs.getInt("numero_stanza");

                System.out.println("Nome Paziente: " + nomeProdotto + ", Quantita: " + quantita +
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