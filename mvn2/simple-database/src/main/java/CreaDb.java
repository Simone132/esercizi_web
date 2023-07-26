import java.sql.Connection;// crea la connessione con il database
import java.sql.DriverManager;// ci mette in connessione con il db
import java.sql.SQLException;// come gestisce le eccezioni sqlite
import java.sql.Statement;// serve per creare le querys (domande create con il database)



public class CreaDb {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            //carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");
            // Creo una connessione al database
            String url ="jdbc:sqlite:database.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connessione a SQLite stabilita.");

            //Creo la tabella
            String sql ="CREATE TABLE IF NOT EXISTS prodotti (\n"
            + "ID_prodotto integer  NOT NULL,"
            + " nome_prodotto text NOT NULL, \n"
            + " categoria_prodotto text NOT NULL, \n"
            + " prezzo_prodotto real NOT NULL, \n"
            + " quantità_prodotto integer NOT NULL, \n"
            + " dataScadenza_prodotto text NOT NULL \n"
            + ");";
            Statement stmt =conn.createStatement();
            stmt.execute(sql);

            System.out.println("Tabella 'prodotti' creata.");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
    }
}
