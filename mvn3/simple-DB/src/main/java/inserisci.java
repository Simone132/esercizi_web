import java.sql.Connection;// crea la connessione con il database
import java.sql.DriverManager;// ci mette in connessione con il db
import java.sql.SQLException;// come gestisce le eccezioni sqlite
import java.sql.Statement;// serve per creare le querys (domande create con il database)


public class inserisci {
    public static void main(String[] args) {

        Connection conn = null;
        try {
            //carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");
            // Creo una connessione al database
            String url ="jdbc:sqlite:database.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            //inserisco i dati di esempio'
            String sql1 ="INSERT INTO prodotti (ID_prodotto, categoria_prodotto, prezzo_prodotto, quantità_prodotto, dataScadenza_prodotto) VALUES (1,'Frutta', 100,10, '2023-06-10');";

            Statement stmt1 =conn.createStatement();
            stmt1.execute(sql1);


            System.out.println("I dati di esempio sono stati inseriti. ");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
        }
    }

}
