public class Gallina extends Animale {
    public Gallina (String nome) {
        super(nome);
    }

    @Override
    public void faRumore() {
        System.out.println(getNome() + " dice: Coccode!");
    }
}
