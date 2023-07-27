import java.sql.Connection;// crea la connessione con il database
import java.sql.DriverManager;// ci mette in connessione con il db
import java.sql.SQLException;// come gestisce le eccezioni sqlite
import java.sql.Statement;// serve per creare le querys (domande create con il database)


public class modifica {
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
            String sql1 ="UPDATE letto_paziente SET letto_paziente =1 WHERE letto_paziente = 10;";

            Statement stmt =conn.createStatement();
            stmt.execute(sql1);


            System.out.println("Il prezzo della mela è stato modificato. ");


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