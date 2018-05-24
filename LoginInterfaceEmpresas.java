import java.util.Scanner;
public class LoginInterfaceEmpresas
{
    public LoginInterfaceEmpresas(int newNif, String passWord)
    {
       Scanner ler = new Scanner(System.in);
       System.out.println("Indique o que pretende fazer:");
       System.out.println("(1) Aceder á listagem das faturas emitidas por data ou por valor");
       System.out.println("(2) Aceder á listagem das faturas emitidas para um contribuinte num intervalo de tempo por uma empresa  ");
       System.out.println("(3) Aceder á listagem das faturas emitidas para um contribuinte ordenadas por valor de uma empresa  ");
       System.out.println("(4) Saber o total faturado num intervalo de tempo");

    }

}
