import java.util.Scanner;
/**
 * Escreva a descrição da classe Comunicador aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Comunicador
{
    public static void main (String[] args) {
        BaseDeDados b = new BaseDeDados();
        System.out.println("Pretende fazer Login(1),Registo(2) ou Sair(3)? ");
        //ler
        Scanner ler = new Scanner(System.in);
        int c = ler.nextInt();
        
        if(c==1){
           Login l = new Login();
          
        }
        if(c==2){
           Registo l = new Registo();

        }
        else{
           System.exit(0);
        }


    }
}
