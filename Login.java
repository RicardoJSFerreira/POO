import java.util.Scanner;
/**
 * Escreva a descrição da classe Login aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Login
{
    private int NIF_novo;
    private String password_novo;
    private  String[] yo;
    public Login()
    {
       int i=0;
       Scanner ler = new Scanner(System.in);
       System.out.println("Indique o seu NIF");
       NIF_novo = ler.nextInt();
       System.out.println("Indique a sua PassWord");
       password_novo = ler.next();
       
      if(verifica_login(NIF_novo,password_novo) == 1){
         LoginInterfaceUsers l = new LoginInterfaceUsers(NIF_novo,password_novo);
         
       }
      if(verifica_login(NIF_novo,password_novo) == 2){
         LoginInterfaceEmpresas k = new LoginInterfaceEmpresas(NIF_novo,password_novo);
         
       }
      
      else{
           Comunicador c = new Comunicador();
           c.main(yo);
           
        }
    }
    
    
}
