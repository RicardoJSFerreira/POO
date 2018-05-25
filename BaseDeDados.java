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
int new_dependentes,int[] new_NIFdependentes, double new_coefFiscal, int[] new_ativEcon){
    CIndividuais newCI = new CIndividuais(NIF,Email,nome,morada,password,new_dependentes
    ,new_NIFdependentes,new_coefFiscal,new_ativEcon);
    
    contribuintesI.put(NIF,newCI);
}

public void addContribuinteEmpresa(int NIF, String Email, String nome, String morada, String password,
String[] new_ativEcon, double new_deducoes){
     CEmpresas newCE = new CEmpresas(NIF,Email,nome,morada,password,new_ativEcon
     ,new_deducoes);
     
     contribuintesE.put(NIF,newCE);
    }
    
public CIndividuais getCIndividual(int NIF){
    CIndividuais c = contribuintesI.get(NIF);
    return c;
}

public CEmpresas getCEmpresas(int NIF){
    CEmpresas c = contribuintesE.get(NIF);
    return c;
}
    
public void setFaturas(Factura f){
       CEmpresas ce = contribuintesE.get(f.getNIFEmitente());
       ce.faturas.add(f);
       CIndividuais ci = contribuintesI.get(f.getNIFCliente());
       ce.setFaturas(f,ci);
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
    double deduzido = c.getdeduzido();
    int NIFDepen;
    CIndividuais ci = new CIndividuais();
    ArrayList<Factura> f = new ArrayList<Factura>();
    
    for(Factura f1 : c.getFaturas()){
        f.add(f1);
    }
    
    ArrayList<String> result = new ArrayList<String>();
    
    for(int i=0; i<f.size(); i++){
        result.add(f.get(i).getDesignacao());
    }
    
    
    for(int j=0; j<c.getNIFdepen().length; j++){
        NIFDepen = c.getNIFdepen()[j];
        ci = getCIndividual(NIFDepen);
        deduzido+=ci.getdeduzido();
    }
    
    String escreve = "Faturas : " + result.toString() + "Deduzido : " + deduzido;
    return escreve;
}

public String listaFacturasPorValor(CEmpresas c){
    ArrayList<Factura> f = new ArrayList<Factura>();
    
    for(Factura f1 : c.getFaturas()){
        f.add(f1);
    }
    
    Collections.sort(f, new Comparator<Factura>() {
      public int compare(Factura f1, Factura f2){
            return Double.compare(f1.getDespesa(),f2.getDespesa());
        }
    });
    
    LinkedHashMap<String,Double> result = new LinkedHashMap<String,Double>();
    
    for(int i=0; i<f.size(); i++){
        result.put(f.get(i).getDesignacao(),f.get(i).getDespesa());
    }
    
    String escreve = result.toString();
    return escreve;
}

public String get10QueMaisGastam(){
    ArrayList<CIndividuais> ci = new ArrayList<CIndividuais>();
    for(CIndividuais c : contribuintesI.values()){
            ci.add(c);
    }
    
    Collections.sort(ci, new Comparator<CIndividuais>() {
        public int compare(CIndividuais c1, CIndividuais c2){
            return Double.compare(c1.getDespesaTotal(),c2.getDespesaTotal());
        }
    });
    
    LinkedHashMap<String,Double> result = new LinkedHashMap<String,Double>();
    
    for(int i=0; i<ci.size() && i<10; i++){
        result.put(ci.get(i).getNome(),ci.get(i).getDespesaTotal());
    }
    
    String escreve = result.toString();
    return escreve;
}

public String getTotalFacturado(CEmpresas c,Date end, Date begin){
    double totalFacturado = 0.0;
    ArrayList<Factura> f = new ArrayList<Factura>();
    
    for(Factura f1 : c.getFaturas()){
        f.add(f1);
    }
    
    for(int i=0; i< f.size(); i++){
        Factura fa = f.get(i);
        if(fa.getData().before(end) && fa.getData().after(begin)){
            totalFacturado += fa.getDespesa();
        }
        
    }
    
    String escreve = "Facturado :" + totalFacturado;
    return escreve;
}

public String listaFacturasCIndividuais(Date end, Date begin, int NIF, CEmpresas c){
    ArrayList<Factura> f = new ArrayList<Factura>();
    
    for(Factura f1 : c.getFaturas()){
        f.add(f1);
    }
    
    ArrayList<Factura> resultado = new ArrayList<Factura>();
    
    for(int i=0; i<f.size(); i++){
        if(f.get(i).getNIFCliente() == NIF && f.get(i).getData().before(end) && f.get(i).getData().after(begin)){
            resultado.add(f.get(i));
        }
    }
    
    LinkedHashMap<String,Date> result = new LinkedHashMap<String,Date>();
    
    for(int j=0; j<resultado.size();j++){
        result.put(resultado.get(j).getDesignacao(),resultado.get(j).getData());
    }
    
    String escreve = result.toString();
    return escreve;
}

public String listaFacturasPorData(CEmpresas c){
    ArrayList<Factura> f = new ArrayList<Factura>();
    
    for(Factura f1 : c.getFaturas()){
        f.add(f1);
    }
    
    Collections.sort(f, new Comparator<Factura>() {
      public int compare(Factura f1, Factura f2){
            return f1.getData().compareTo(f2.getData());
        } 
    });
    
    
}

public static void saveState() {
        Save_State io;
        io = new Save_State();
        io.WriteHashMap(contribuintesI,1);
        io.WriteHashMap(contribuintesE,2);
}

public static void main (String[] args) {
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