package concrete;
import astratte.Rettile;

public class Pitone extends Rettile{
    public Pitone(String nomeProprioAnimale){// costruttore
        super(nomeProprioAnimale);  // super = della superclasse
    }

    public String getSpecieAnimale(){
        return this.getClass().getSimpleName(); // la classe pitone è concreta perchè implementa tutti i metodi restanti della superclasse animale 
    }
    
}
