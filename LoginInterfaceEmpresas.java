import java.util.Scanner;
import java.time.LocalDate;
import java.util.Date;
public class LoginInterfaceEmpresas
{
    public LoginInterfaceEmpresas(int newNif, String passWord)
    {
       int i;
       BaseDeDados b = new BaseDeDados();
       Scanner ler = new Scanner(System.in);
       System.out.println("Indique o que pretende fazer:");
       System.out.println("(1) Adicionar fatura");
       System.out.println("(2) Aceder á listagem das faturas emitidas por valor");
       System.out.println("(3) Aceder á listagem das faturas emitidas para um contribuinte num intervalo de tempo");
       System.out.println("(4) Aceder á listagem das faturas emitidas para um contribuinte ordenadas por valor  ");
       System.out.println("(5) Saber o total faturado num intervalo de tempo");
       
       
      
       i = ler.nextInt();
       CEmpresas contrib = b.getCEmpresa(newNif);// falta um getCempresa igual á users
       if(i==1){
           Set_Fatura_Empresa l = new Set_Fatura_Empresa(newNif);
        }
       if(i==2){
       String lista_valores = b.listaFacturasPorValor(contrib);
       System.out.println(lista_valores);
       
        }
       if(i==3){
       String lista_fat_tempo = b.listaFacturasPorData(contrib);
       System.out.println(lista_fat_tempo);
        }
       if(i==4){
       String lista_fat_valor = b.listaFacturasPorValor(contrib);
       System.out.println(lista_fat_valor);
        }
       if(i==5){
       String total_faturado =b.getTotalFacturado(contrib); //nao dava para compilar
       System.out.println(total_faturado);
       }
    }

}
