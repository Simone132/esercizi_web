import java.util.Random;
import java.util.Scanner;

public class sassocartaforbice{
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
