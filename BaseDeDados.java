import java.util.Date;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
public class BaseDeDados
{

private static HashMap<Integer,CIndividuais> contribuintesI;
private static HashMap<Integer,CEmpresas> contribuintesE;
    

public void addContribuinteIndividual(int NIF, String Email, String nome, String morada, String password,
int new_dependentes,int[] new_NIFdependentes, double new_coefFiscal, int[] new_ativEcon,
double deducfiscal){
    CIndividuais newCI = new CIndividuais(NIF,Email,nome,morada,password,new_dependentes
    ,new_NIFdependentes,new_coefFiscal,new_ativEcon,deducfiscal);
    
    contribuintesI.put(NIF,newCI);
}

public void addContribuinteEmpresa(int NIF, String Email, String nome, String morada, String password,
String[] new_ativEcon, double new_deducoes){
     CEmpresas newCE = new CEmpresas(NIF,Email,nome,morada,password,new_ativEcon
     ,new_deducoes);
     
     contribuintesE.put(NIF,newCE);
    }
    
public int verifica_login(int NIF, String password){
    
    if(contribuintesI.get(NIF) != null && contribuintesI.get(NIF).getPassword().equals(password)) {
        return 1;
    }
    
    if(contribuintesE.get(NIF) != null && contribuintesE.get(NIF).getPassword().equals(password)) {
        return 2;
    }
    return 0;
}

public String infoContribuinteI(CIndividuais c){
    ArrayList<Factura> f = new ArrayList<Factura>();
    
    for(Factura f1 : c.getFaturas()){
        f.add(f1);
    }
    
    ArrayList<String> result = new ArrayList<String>();
    
    for(int i=0; i<f.size(); i++){
        result.add(f.get(i).getDesignacao());
    }
    
    String escreve = "Faturas : " + result.toString() + "Deduzido : " + c.getDeducFiscal();
    return escreve;
}

public String listaFacturasPorValor(CEmpresas c){
    ArrayList<Factura> f = new ArrayList<Factura>();
    
    for(Factura f1 : c.getFaturas()){
        f.add(f1);
    }
    
    Collections.sort(f, new Comparator<Factura>() {
      public int compare(Factura f1, Factura f2){
            return Double.compare(f1.getDespesa(),f1.getDespesa());
        }
    });
    
    LinkedHashMap<String,Double> result = new LinkedHashMap<String,Double>();
    
    for(int i=0; i<f.size(); i++){
        result.put(f.get(i).getDesignacao(),f.get(i).getDespesa());
    }
    
    String escreve = result.toString();
    return escreve;
}
    public static void main (String[] args){
        System.out.println("Pretende fazer Login(1),Registo(2) ou Sair(3)? ");
        //ler
        Scanner ler = new Scanner(System.in);
        int c = ler.nextInt();
        
        if(c==1){
           Login l = new Login();
          
        }
        if(c==2){
           Registo l = new Registo();

        }
        else{
           System.exit(0);
        }
    }
}