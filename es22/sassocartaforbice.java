import java.util.Random;
import java.util.Scanner;

public class sassocartaforbice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String[] options = {"sasso", "carta", "forbice"};
        String computerMossa = options[random.nextInt(options.length)];
        String utenteMossa = input.nextLine().toLowerCase();

        Gioco gioco = new Gioco(computerMossa, utenteMossa);
        gioco.partita(); // Assuming the Gioco class has a method named "play" that handles the game logic.

        input.close();
    }
}