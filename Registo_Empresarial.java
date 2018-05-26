import java.util.Scanner;
public class Registo_Empresarial
{

    public Registo_Empresarial()
    {
        int new_NIF;
        String new_Email;
        String new_nome;
        String new_morada;
        String new_password;;
        String concelho;
        String[] new_ativEcon = null;
        
       BaseDeDados b = new BaseDeDados();
       Scanner ler = new Scanner(System.in);
       System.out.println("Indique o seu NIF");
       new_NIF = ler.nextInt();
       System.out.println("Indique o seu email");
       new_Email = ler.next();       
       System.out.println("Indique o seu nome");
       new_nome = ler.next();     
       System.out.println("Indique a sua morada");
       new_morada = ler.next();
       System.out.println("Indique o seu concelho");
       concelho = ler.next();
       System.out.println("Indique uma PassWord");
       new_password = ler.next();         

       b.addContribuinteEmpresa(new_NIF,new_Email,new_nome, new_morada,new_password,concelho,
       new_ativEcon);

       System.out.println("Conta empresarial criada com sucesso");

}

}
