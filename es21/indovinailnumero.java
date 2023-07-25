import java.util.Random;
import java.util.Scanner;



//     public class indovinailnumero 
//     {
//     public static void main(String[] args) 
//     {
        
//             Scanner input = new Scanner(System.in);
//             Random rand =new Random();
//             int tentativo =0;
            
//             boolean vincita = false ;
//             int randomInt = rand.nextInt(100) + 1;
//             int tentativi =0;
            
//         while(vincita==false)
//         {
//                 tentativi++;
//             System.out.println("indovina un numero casuale tra 1 e 100");
            
//             tentativo= input.nextInt();
            
            
//             if (tentativo == randomInt) 
//             {
//                 vincita=true;
//             }
            
            

            
        
//         else if (tentativo< randomInt) 
//         System.out.println("troppo basso prova ancora ");

//         else if (tentativo  >   randomInt  )
//         System.out.println("troppo alto  prova ancora");
        
        
//         }
//         System.out.println("bravo hai idovinato dopo "  + tentativi + "  tentativi");
        
//         input.close();
//     }
//     }





    class Gioco{
        private int numeroCasuale;
        private Giocatore giocatore;

        public Gioco (int numeroCasuale,Giocatore giocatore){
            this.numeroCasuale = numeroCasuale;
            this.giocatore= giocatore;
        }

    public  void gioca(){
        Scanner input = new Scanner(System.in);


        System.out.println("indovina il numero da 1 a 100");
        System.out.println("inserisic il tuo nome:");
        String nome = input.nextLine();
        giocatore.setNome(nome);

        boolean idovinato= false;

        while(!idovinato&& giocatore.getTentativi() <5){
            System.out.print("inserisci il tuo tentativo: ");
            int tentativo = input.nextInt();
            giocatore.setTentativi(giocatore.getTentativi()+1);

            if (tentativo== numeroCasuale){
                System.out.println("Complimenti, "+ giocatore.getNome()+"! hai indovinato il numero in ");
            }
        }
    }
}
    class Giocatore{
        private String nome;
        private int tentativi;

        public Giocatore()
        {
            this.nome="";
            this.tentativi =0;
        }
        public String getNome(){
            return nome;
        }
        public int getTentativi(){
            return tentativi;
        }
        public void setNome(String nome){
            this.nome= nome;
        }
        public void setTentativi(int tentativi){
            this.tentativi= tentativi;
        }
    }
    public class indovinailnumero
    {
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