public class Esame {
    
    private int identificativoEsame;
    private int identificativo_paziente;

    public Esame (int identificativoEsame, int identificativo_paziente){
        this.identificativoEsame= identificativoEsame;
        this.identificativo_paziente= identificativo_paziente;
    }
    public int getIdentificativoEsame(){
        return identificativoEsame;
    }
    public int getIdentificativo_paziente(){
        return identificativo_paziente;
    }
}

