package astratte;




public abstract class Animale {
    private String ordineAnimale;
     private String specieAnimale;   //variabili di istanza
    private String nomeProprioAnimale;
    

    public Animale(String nomeProprioAnimale){
        this.nomeProprioAnimale= nomeProprioAnimale;
    }

    public String getNomeProprioAnimale(){
        return nomeProprioAnimale;
    }

    public abstract String  getSpecieAnimale();
    public abstract String getOrdineAnimale();



    public void print(){
        System.out.println(
            "Ordine: "+getOrdineAnimale()+
            "\nNome animale: " +getSpecieAnimale() +
            "\nNome proprio: "+getNomeProprioAnimale()
        );
    }

}
