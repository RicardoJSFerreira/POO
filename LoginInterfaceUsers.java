import java.util.Scanner;
public class LoginInterfaceUsers
{
    public LoginInterfaceUsers(int newNif, String passWord)
    {
       Scanner ler = new Scanner(System.in);
       System.out.println("Indique o que pretende fazer:");
       System.out.println("(1) Aceder a faturas emitidas");
       System.out.println("(2) Associar novas faturas");
       System.out.println("(3) Associar faturas ainda por classificar");
       System.out.println("(4) Associar novas faturas");
       System.out.println("(5) Verificar a dedução atual");
       System.out.println("(6) Alterar a classificaçao de uma empresa");

    }

}
