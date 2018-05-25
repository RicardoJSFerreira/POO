import java.util.Scanner;
/**
 * Escreva a descrição da classe Login aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Registo
{
    private int NIF_novo;
    private String password_novo;
    private String[] yo;
    public Registo()
    {   
       int tipo_contribuinte;
       BaseDeDados b = new BaseDeDados();
       Scanner ler = new Scanner(System.in);
       System.out.println("Verfique se se trata de (1) Contribuinte particular, (2) Contribuinte de empresarial");
       tipo_contribuinte = ler.nextInt();
       
      if(tipo_contribuinte == 1){
         Registo_Individual l = new Registo_Individual();
         
       }
      if(tipo_contribuinte == 2){
         Registo_Empresarial k = new Registo_Empresarial();
         
       }
      
      else{
           b.main(yo);
           
        }
    }
}
