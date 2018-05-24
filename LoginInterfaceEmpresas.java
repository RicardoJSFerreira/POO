import java.util.Scanner;
public class LoginInterfaceEmpresas
{
    public LoginInterfaceEmpresas(int newNif, String passWord)
    {
       Scanner ler = new Scanner(System.in);
       System.out.println("Indique o que pretende fazer:");
       System.out.println("(1) Associar faturas a um contribuinte");
       System.out.println("(2) Aceder á listagem das faturas emitidas por data");
       System.out.println("(3) Aceder á listagem das faturas emitidas por valor");
       System.out.println("(4) Aceder á listagem das faturas emitidas para um contribuinte num intervalo de tempo");
       System.out.println("(5) Aceder á listagem das faturas emitidas para um contribuinte ordenadas por valor");
       System.out.println("(6) Saber o total faturado num intervalo de tempo");

    }

}
