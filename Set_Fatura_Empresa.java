import java.util.Scanner;
import java.time.LocalDate;
import java.util.Date;

 public class Set_Fatura_Empresa
{
    public Set_Fatura_Empresa(int newNif){
    String designacao;
    Date data;
    int NIFCliente;
    int dia;
    int mes;
    int ano;
    String fat;
    String descricao;
    double valorDespesa;
    
       BaseDeDados b = new BaseDeDados();
       Scanner ler = new Scanner(System.in);
       System.out.println("Indique a designaçao da fatura");
       designacao = ler.next();
       System.out.println("Indique a data de emissão: dia");//meter na mesma maneira como le
       dia = ler.nextInt();
       System.out.println("Indique a data de emissão: mes");
       mes = ler.nextInt();
       System.out.println("Indique a data de emissão: ano");
       ano = ler.nextInt();
       data = new Date(ano,mes,dia); // Ver como transformar para formato data
       System.out.println("Indique o contribuinte do cliente");
       NIFCliente = ler.nextInt();
       System.out.println("Indique o tipo da fatura");
       fat = ler.next();
       System.out.println("Indique a descricao da fatura");
       descricao = ler.next();
       System.out.println("Indique o valor da despesa");
       valorDespesa = ler.nextDouble();
       
       Factura fac = new Factura(newNif,designacao,data,NIFCliente,fat,descricao,valorDespesa);
       b.setFaturas(fac);
       String sucesso = "A sua fatura com contribuinte" + String.valueOf(NIFCliente) + "foi adicionada com sucesso";
       
    }
}
