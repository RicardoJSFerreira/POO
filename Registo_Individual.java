import java.util.Scanner;
import java.util.ArrayList;
public class Registo_Individual
{

    public Registo_Individual()
    {
        int new_NIF;
        String new_Email;
        String new_nome;
        String new_morada;
        String new_password;
        String nifdependentes;
        String ativEconomicas;
        int new_dependentes;
        ArrayList<Integer> new_NIFdependentes=new ArrayList<>();
        int[] new_ativEcon=null;
        
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
       System.out.println("Indique uma PassWord");
       new_password = ler.next();
       System.out.println("Indique o nº de dependentes do seu agregado familiar");
       new_dependentes = ler.nextInt();
       //System.out.println("Indique os NIF dos seus dependentes");
       //nifdependentes = ler.next();
       //String[] strs = nifdependentes.trim().split(" ");
       //for(int i = 0; i < strs.length; i++) {
       //     new_NIFdependentes[i] = Integer.parseInt(strs[i]);
        //}
       b.addContribuinteIndividual(new_NIF,new_Email,new_nome, new_morada,new_password,
       new_dependentes,new_NIFdependentes, new_ativEcon);
       System.out.println("Conta individual criada com sucesso");

}

}
