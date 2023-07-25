package concrete;
import astratte.Mammifero;

public class Leone extends Mammifero{
    
    public Leone(String nomeProprioAnimale){
        super(nomeProprioAnimale);
    }

    public String getSpecieAnimale(){
        return this.getClass().getSimpleName();
    }

}
