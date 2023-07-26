import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String[] options = {"sasso", "carta", "forbice"};
        String computerMossa = options[random.nextInt(options.length)];
        String utenteMossa = input.nextLine().toLowerCase();
        Gioco gioco = new Gioco(utenteMossa,computerMossa); // Assuming the Gioco class has a method named "play" that handles the game logic.
        ;
        gioco.partita();
        input.close();
    }

    }
