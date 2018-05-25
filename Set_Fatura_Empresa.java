import java.util.Scanner;
import java.time.LocalDate;
import java.util.Date;

 public class Set_Fatura_Empresa
{
    public Set_Fatura_Empresa(int newNif){
    String designacao;
    Date data;
    int NIFCliente;
    TipoFactura fat;
    String descricao;
    double valorDespesa;
    
       BaseDeDados b = new BaseDeDados();
       Scanner ler = new Scanner(System.in);
       System.out.println("Indique a designaçao da fatura");
       designacao = ler.nextLine();
       System.out.println("Indique a data de emissão no formato dia/mes/ano");//meter na mesma maneira como le
       data = ler.nextDate(); // Ver como transformar para formato data
       System.out.println("Indique o contribuinte do cliente");
       NIFCliente = ler.nextInt();
       //falta tipo fatura
       System.out.println("Indique a descricao da fatura");
       descricao = ler.nextLine();
       System.out.println("Indique o valor da despesa");
       valorDespesa = ler.nextDouble();
       
       Factura fac = new Factura(newNif,designacao,data,NIFCliente,fat,descricao,valorDespesa);
       b.setFaturas(fac);
       String sucesso = "A sua fatura com contribuinte" + String.valueOf(NIFCliente) + "foi adicionada com sucesso";
       
    }
}
