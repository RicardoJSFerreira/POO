import java.util.Scanner;
import java.time.LocalDate;
import java.util.Date;
public class LoginInterfaceEmpresas
{
    public LoginInterfaceEmpresas(int newNif, String passWord)
    {
       int i,confirmacao;
       int contribindiv;
       int dia, mes, ano;
       Date data_end, data_begin;
       BaseDeDados b = new BaseDeDados();
       Scanner ler = new Scanner(System.in);
       System.out.println("Indique o que pretende fazer:");
       System.out.println("(1) Adicionar fatura");
       System.out.println("(2) Aceder á listagem das faturas emitidas por valor");
       System.out.println("(3) Aceder á listagem das faturas emitidas por data");
       System.out.println("(4) Aceder á listagem das faturas emitidas para um contribuinte ordenadas por valor  ");
       System.out.println("(5) Aceder á listagem das faturas emitidas para um contribuinte num intervalo de tempo  ");
       System.out.println("(6) Saber o total faturado num intervalo de tempo");
       
       
      
       i = ler.nextInt();
       CEmpresas contrib = b.getCEmpresa(newNif);// falta um getCempresa igual á users
       if(i==1){
           Set_Fatura_Empresa l = new Set_Fatura_Empresa(newNif);
           System.out.println("Quer confirmar a fatura? Sim(1) ou Não(2)");
           confirmacao = ler.nextInt();
           if(confirmacao==1){
              b.saveState();
            }
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
       System.out.println("Indique um contribuinte individual:");
       contribindiv=ler.nextInt();
       String lista_fat_valor = b.listaFacturasValorDespesa(contrib,contribindiv);
       System.out.println(lista_fat_valor);
        }
       if(i==5){
       System.out.println("Indique a data de inicio: dia");//meter na mesma maneira como le
       dia = ler.nextInt();
       System.out.println("Indique a data de inicio: mes");
       mes = ler.nextInt();
       System.out.println("Indique a data de inicio: ano");
       ano = ler.nextInt();
       data_begin = new Date(ano,mes,dia); // Ver como transformar para formato data
       
       System.out.println("Indique a data do fim: dia");//meter na mesma maneira como le
       dia = ler.nextInt();
       System.out.println("Indique a data do fim: mes");
       mes = ler.nextInt();
       System.out.println("Indique a data do fim: ano");
       ano = ler.nextInt();
       data_end = new Date(ano,mes,dia);
       
       System.out.println("Indique um contribuinte individual:");
       contribindiv=ler.nextInt();
       
       String lista_fat_data = b.listaFacturasCIndividuais(data_end,data_begin,
       contribindiv,contrib);
       System.out.println(lista_fat_data);
        }
       if(i==6){
       System.out.println("Indique a data de inicio: dia");//meter na mesma maneira como le
       dia = ler.nextInt();
       System.out.println("Indique a data de inicio: mes");
       mes = ler.nextInt();
       System.out.println("Indique a data de inicio: ano");
       ano = ler.nextInt();
       data_begin = new Date(ano,mes,dia); // Ver como transformar para formato data
       
       System.out.println("Indique a data do fim: dia");//meter na mesma maneira como le
       dia = ler.nextInt();
       System.out.println("Indique a data do fim: mes");
       mes = ler.nextInt();
       System.out.println("Indique a data do fim: ano");
       ano = ler.nextInt();
       data_end = new Date(ano,mes,dia);
       
       String total_faturado =b.getTotalFacturado(newNif,data_end,data_begin); //nao dava para compilar
       System.out.println(total_faturado);
       }
    }

}
