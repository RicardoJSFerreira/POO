import java.util.Scanner;
public class LoginInterfaceUsers
{
    public LoginInterfaceUsers(int newNif, String passWord)
    {
        BaseDeDados b = new BaseDeDados();
        int i;
       Scanner ler = new Scanner(System.in);
       System.out.println("Indique o que pretende fazer:");
       System.out.println("(1) Aceder a faturas emitidas e o valor da sua deduçao");
       System.out.println("(2) Associar faturas ainda por classificar");
       
       i = ler.nextInt();
       CIndividuais contribu = b.getCIndividual(newNif);
       
       if(i==1){ 
       String fat_emi_dedu = b.infoContribuinteI(contribu);
       System.out.println(fat_emi_dedu);
        }
       if(i==2){
       //String fat_por_class = b.classificar_faturas();//falta acrescentar e meter tipo
       //System.out.println(fat_por_class);
        }
    }

}
