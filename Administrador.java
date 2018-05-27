import java.util.Scanner;
public class Administrador
{
    private int perg;
    private int password_admin;
    private int num_empresas;
    private  String[] yo;
    public Administrador()
    {
       BaseDeDados b = new BaseDeDados();
       Scanner ler = new Scanner(System.in);
       System.out.println("Indique as suas credenciais de administrador");
       password_admin = ler.nextInt();
       if (password_admin==123456){
       System.out.println("Indique o que pretende fazer");
       System.out.println("(1) Saber os 10 contribuintes que mais gastam");
       System.out.println("(2) Saber as empresas com mais faturas ");
       perg = ler.nextInt();
       if(perg == 1){
       System.out.println(b.get10QueMaisGastam());
        }
       if(perg == 2){
       System.out.println("Indique o numero de empresas que quer ver");
       num_empresas = ler.nextInt();
       System.out.println(b.empresasComMaisFaturas(num_empresas));
        }
       
    }
        b.main(yo); 
    }
       
}
