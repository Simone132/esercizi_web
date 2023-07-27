import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CReaDbCollegato {

    public static void main(String[] args) {

        Connection conn = null;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:database_collegato.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            // Creo la tabella 'categoria'
            String sql1 = "CREATE TABLE IF NOT EXISTS referto (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " nome text NOT NULL\n"
                    + ");";

            // Creo la tabella 'prodotti' con una chiave esterna che si riferisce alla tabella 'categorie'
            String sql2 = "CREATE TABLE IF NOT EXISTS paziente (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " id_persona integer NOT NULL,\n"
                    + " nome_paziente text NOT NULL,\n"
                    + " cognome_paziente text NOT NULL,\n"
                    + " numero_stanza integer NOT NULL,\n"
                    + " dimissione text NOT NULL,\n"
                    + " letto_paziente integer NOT NULL,\n"
                    + " FOREIGN KEY(id_referto) REFERENCES referto(id)\n"
                    + ");";

            Statement stmt1 = conn.createStatement();
            stmt1.execute(sql1);

            Statement stmt2 = conn.createStatement();
            stmt2.execute(sql2);

            System.out.println("Tabelle 'referto' e 'paziente' create.");

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