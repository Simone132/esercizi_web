import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileWriter;
import java.io.IOException;

public class VisualizzaDati {
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
            String sql ="SELECT * FROM prodotti;";
            Statement stmt =conn.createStatement();
            ResultSet rs =stmt.executeQuery(sql);
while(rs.next()){
String nomeProdotto =rs.getString("nome_prodotto");
int quantita = rs.getInt("quantita");
String categoriaProdotto = rs.getString("categoria_prodotto");
double prezzoProdotto = rs.getDouble("prezzo_prodotto");
System.out.println("Nome Prodotto: " +nomeProdotto + ",Quantita: " +quantita+",, Categoria Prodotto: " + categoriaProdotto+ "Prezzo Prodotto");

}


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
