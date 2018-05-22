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
        System.out.println("Pretende fazer Login(1) ou Registo(2)? ");
        //ler
        Scanner ler = new Scanner(System.in);
        int c = ler.nextInt();
        
        if(c==1){
            System.out.println("Ta tudo? ");
        }
        
        System.out.println("Acabou");
    }
}
