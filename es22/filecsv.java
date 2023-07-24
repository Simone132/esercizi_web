import java.io.FileWriter; 
import java.io.IOException; 
import java.util.Random;
import java.util.Scanner;


public class filecsv {
    public static void createCSV(String nome, int punteggio, String partita) 
    {
        String csvFile = "data.csv";
        
        try {
            FileWriter writer = new FileWriter(csvFile, true);
    
            writer.append(nome);
            writer.append(",");
            writer.append(Integer.toString(punteggio));
            writer.append(",");
            writer.append(partita);
            writer.append("\n");
    
            writer.flush();
            writer.close();
            System.out.println("Dati aggiunti con successo a " + csvFile);
        } 
        catch (IOException e)
        {
            System.out.println("Errore durante la scrittura del file CSV: " + e.getMessage());
        }
    }

public static void main(String[] args) 
    {
    String nome = "Mario Rossi";
    int punteggio = 100;
    String partita = "Partita 1";

    createCSV(nome, punteggio, partita);
    }   
}

class Giocatore
    {
        private String nome;
        private int tentativi;
        public Giocatore()
        {
            this.nome="";
            this.tentativi =0;
        }
        public String getNome()
        {
            return nome;
        }
        public int getTentativi()
        {
            return tentativi;
        }
        public void setNome(String nome)
        {
            this.nome= nome;
        }
        public void setTentativi(int tentativi)
        {
            this.tentativi= tentativi;
        }
    }




class Gioco
    {
        private String computerMossa;
        private String utenteMossa;

        
        public Gioco (int numeroCasuale,Giocatore giocatore)
        {
            this.computerMossa = computerMossa;
            this.utenteMossa= utenteMossa;
        }
        public void gioca()
        {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("ciao come ti chiami?");
        String nome =input.nextLine();
        System.out.println( nome + "  il regolamento è: \n carta = carta\n carta > sasso\n carta < forbice\n sasso = sasso\n sasso > forbice\n sasso < carta\n forbice = forbice\n forbice < sasso\n forbice > carta\n ");

            String[] options = {"sasso", "carta", "forbice"};


        System.out.println("Inserisci la tua mossa (sasso, carta, forbice):");
        String utenteMossa = input.nextLine().toLowerCase();

        String computerMossa = options[random.nextInt(options.length)];

        System.out.println("Il pc ha scelto: " + computerMossa);
        boolean vincita = false;
        while (vincita == false)
        {
            System.out.println("Inserisci la tua mossa (sasso, carta, forbice):");
            utenteMossa = input.nextLine().toLowerCase();
            computerMossa = options[random.nextInt(options.length)];
            if (utenteMossa.equals(computerMossa))
            {
                System.out.println("Pareggio!");
            }
            else if ((utenteMossa.equals("sasso") && computerMossa.equals("forbice")) ||
                (utenteMossa.equals("carta") && computerMossa.equals("sasso")) ||
                (utenteMossa.equals("forbice") && computerMossa.equals("carta"))) 
            {
            System.out.println( nome + " Hai vinto!");
            vincita= true;
            }
            else
            {
            System.out.println("hai perso");
            }
        } 
        }
    

        public static void main(String[] args )
        {
                        Scanner input = new Scanner(System.in);
            Random rand = new Random();

            int numeroCasuale = rand.nextInt(100)+1;
            Giocatore giocatore = new Giocatore();
            Gioco gioco = new Gioco(numeroCasuale, giocatore);
            gioco.gioca();
            input.close();
        }
    }
        

        
    



