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
        int contribuinte;
        String passWord;
        
        
        if(c==1){
            System.out.println("Insira o seu número de contribuinte");
            contribuinte= ler.nextInt();
            System.out.println("Insira a Password");
            passWord = ler.nextLine();
            if(verifica_login(contribuinte,passWord)==True){ //contribuintes
                //adicionar faturas
                //consultar faturas
                //consultar deduzido
                //consultar faturas "outros" e definir o seu tipo
            }
            else{
                System.out.println("Login incorreto");
            }
        }
        if(c==2){
        System.out.println("Acabou");
    }
        else{
        System.out.println("Inseriu um numero errado");
        }
    }
}
