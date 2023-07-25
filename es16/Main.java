public class Main {
    public static void main(String[] args) {
        Fattoria fattoria = new Fattoria();

        Animale mucca = new Mucca("Bianca");
        Animale gallina = new Gallina("rosita");

        fattoria.aggiungiAnimale(mucca);
        fattoria.aggiungiAnimale(gallina);

        fattoria.faRumore();
    }
}