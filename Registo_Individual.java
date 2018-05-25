import java.util.Scanner;
public class Registo_Individual
{

    public Registo_Individual()
    {
        int new_NIF;
        String new_Email;
        String new_nome;
        String new_morada;
        String new_password;
        int new_dependentes;
        int [] new_NIFdependentes;
        double new_coefFiscal;
        int[] new_ativEcon;
        
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
       //Nif dependentes
       //atividade economica
       //É preciso a empresa saber coeficiente fiscal?
       b.addContribuinteIndividual(new_NIF,new_Email,new_nome, new_morada,new_password,
new_dependentes,new_NIFdependentes,new_coefFiscal, new_ativEcon);
       System.out.println("Conta individual criada com sucesso");

}

}
