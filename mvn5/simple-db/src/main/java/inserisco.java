import java.sql.Connection;// crea la connessione con il database
import java.sql.DriverManager;// ci mette in connessione con il db
import java.sql.SQLException;// come gestisce le eccezioni sqlite
import java.sql.Statement;// serve per creare le querys (domande create con il database)


public class inserisco {
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
            String sql1 ="INSERT INTO prodotti (ID_persona, nome_paziente, cognome_paziente, numero_stanza, dimissione) VALUES (1,'Carlo', 'Rossi',10, '2023-08-10');";
            String sql2 ="INSERT INTO prodotti (ID_persona, nome_paziente, cognome_paziente, numero_stanza, dimissione) VALUES (2,'Mario', 'Bianchi',15, '2023-08-15');";
            String sql3 ="INSERT INTO prodotti (ID_persona, nome_paziente, cognome_paziente, numero_stanza, dimissione) VALUES (4,'Luca', 'Risso',20, '2023-08-16');";
            String sql4 ="INSERT INTO prodotti (ID_persona, nome_paziente, cognome_paziente, numero_stanza, dimissione) VALUES (4,'Francesco', 'Verdi',17, '2023-10-10');";

            Statement stmt1 =conn.createStatement();
            stmt1.execute(sql1);
            Statement stmt2 =conn.createStatement();
            stmt1.execute(sql2);
            Statement stmt3 =conn.createStatement();
            stmt1.execute(sql3);
            Statement stmt4 =conn.createStatement();
            stmt1.execute(sql4);


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
