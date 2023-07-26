import java.util.Random;
import java.util.Scanner;
class Gioco
{

    private String utenteMossa;
    private String computerMossa;

    private Giocatore giocatore;

    public Gioco ( String utenteMossa, String computerMossa){
        this.utenteMossa = utenteMossa;
        this.computerMossa= computerMossa;
    }

    public  void partita(){
        Scanner input = new Scanner(System.in);
        Random random = new Random();



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
            System.out.println(   " Hai vinto!");
            vincita= true;
            }
            else
            {
            System.out.println("hai perso");
            }
        }


    }
}

