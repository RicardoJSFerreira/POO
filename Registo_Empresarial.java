import java.util.Scanner;
public class Registo_Empresarial
{

    public Registo_Empresarial()
    {
        int new_NIF;
        String new_Email;
        String new_nome;
        String new_morada;
        String new_password;
        double new_deducoes;
        String[] new_ativEcon;
        
       BaseDeDados b = new BaseDeDados();
       Scanner ler = new Scanner(System.in);
       System.out.println("Indique o seu NIF");
       new_NIF = ler.nextInt();
       System.out.println("Indique o seu email");
       new_Email = ler.nextLine();       
       System.out.println("Indique o seu nome");
       new_nome = ler.nextLine();     
       System.out.println("Indique a sua morada");
       new_morada = ler.nextLine();     
       System.out.println("Indique uma PassWord");
       new_password = ler.nextLine();    
       System.out.println("Indique a deducao em vigor");
       new_deducoes = ler.nextDouble();        

       //atividade economica

       b.addContribuinteEmpresa(new_NIF,new_Email,new_nome, new_morada,new_password,
new_ativEcon,new_deducoes);

       System.out.println("Conta empresarial criada com sucesso");

}

}
