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

public class BaseDeDados
{

private static HashMap<Integer,CIndividuais> contribuintesI;
private static HashMap<Integer,CEmpresas> contribuintesE;
    

public void addContribuinteIndividual(int NIF, String Email, String nome, String morada, int password,
int new_dependentes,int[] new_NIFdependentes, double new_coefFiscal, int[] new_ativEcon){
    CIndividuais newCI = new CIndividuais(NIF,Email,nome,morada,password,new_dependentes
    ,new_NIFdependentes,new_coefFiscal,new_ativEcon);
    
    contribuintesI.put(NIF,newCI);
}

public void addContribuinteEmpresa(int NIF, String Email, String nome, String morada, int password,
String[] new_ativEcon, double new_deducoes){
     CEmpresas newCE = new CEmpresas(NIF,Email,nome,morada,password,new_ativEcon
     ,new_deducoes);
     
     contribuintesE.put(NIF,newCE);
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

}