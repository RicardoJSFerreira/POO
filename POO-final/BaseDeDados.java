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
import java.io.Serializable;
import java.awt.EventQueue;

/**
 * O .. é um programa que permite resgistar faturas por parte de empresas, a que os clientes vão ter acesso a estas e poder verificar se são dedutiveis entre outras funções.
 * Esta é a classe principal que gere o programa.
 * @author Diogo Rocha, Ricardo Veloso , Ricardo Ferreira
 * @since 2018-03-01
 */
public class BaseDeDados

{

private static HashMap<Integer,CIndividuais> contribuintesI= new HashMap<Integer,CIndividuais>();
private static HashMap<Integer,CEmpresas> contribuintesE = new HashMap<Integer,CEmpresas>();
    
/**
 * Adiciona um contrinuinte individual
 * 
 * @param NIF                   Número de indentificação fiscal do contribuinte individual
 * @param Email                 Email do contribuinte individual
 * @param Nome                  Nome do contribuinte individual
 * @param Morada                Morada do contribuinte individual
 * @param Password              Password do contribuinte individual
 * @param new_dependentes       Número de dependentes do contribuinte individual
 * @param new_NIFdependentes    NIF correspondente a cada um dos dependentes
 */
public void addContribuinteIndividual(int NIF, String Email, String nome, String morada, String password,
int new_dependentes,ArrayList<Integer> new_NIFdependentes){
    CIndividuais newCI = new CIndividuais();
    
    newCI = new CIndividuais(NIF,Email,nome,morada,password,new_dependentes,new_NIFdependentes);
    
    contribuintesI.put(NIF,newCI);
}

/**
 * Adiciona um contribuinte Empresa
 * 
 * @param NIF                   Número de indentificação fiscal do contribuinte Empresa
 * @param Email                 Email do contribuinte Empresa
 * @param Nome                  Nome do contribuinte Empresa
 * @param Morada                Morada do contribuinte Empresa
 * @param Password              Password do contribuinte Empresa
 * @param concelho              Concelho onde se encontra a Empresa 
 * 
 */
public void addContribuinteEmpresa(int NIF, String Email, String nome, String morada, String password,
String concelho){
     CEmpresas newCE = new CEmpresas(NIF,Email,nome,morada,password,concelho);
     
     contribuintesE.put(NIF,newCE);
    }
    
/**
 * Devolve um contribuinte individual
 * @param NIF           Número de indentificação fiscal do contribuinte Individual
 */
public CIndividuais getCIndividual(int NIF){
    CIndividuais c = contribuintesI.get(NIF);
    return c;
}

/**
 * Devolve um contribuinte empresarial
 * @param NIF           Número de indentificação fiscal do contribuinte Empresarial
 */
public CEmpresas getCEmpresa(int NIF){
    CEmpresas c = contribuintesE.get(NIF);
    return c;
}

/**
 * Adiciona uma fatura ao sistema
 * @param f             Factura que pretendemos adicionar
 * @param x             NIF correspondente ao contribuinte empresarial
 * @param y             NIF correspondente ao contribuinte individual
 */
public void setFaturas(Factura f, int x, int y){
       CEmpresas ce = contribuintesE.get(x);
       ce.faturas.add(f);
       CIndividuais ci = contribuintesI.get(y);
       ce.setFaturas(f,ci);
}

/**
 * Tenta fazer login numa conta de utilizador quer seja Individual ou Empresa.
 * @param NIF                   Número de indentificação fiscal do contribuinte Individual/Empresa
 * @param Password              Password do contribuinte Individual/Empresa
 * @return                      1 se o contribuinte Individual fizer login com sucesso, 2 se o contribuinte Empresa fizer login com sucesso,
 *                              0 se o login for inválido.
 */
public int verifica_login(int NIF, String password){
    
    if(contribuintesI.get(NIF) != null && contribuintesI.get(NIF).getPassword().equals(password)) {
        return 1;
    }
    
    if(contribuintesE.get(NIF) != null && contribuintesE.get(NIF).getPassword().equals(password)) {
        return 2;
    }
    return 0;
}

/**
 * Lista de faturas e a sua dedução
 * @param c             O contribuinte individual que queremos informação 
 */
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
    
    
    for(int j=0; j<c.getNIFdepen().size(); j++){
        NIFDepen = c.getNIFdepen().get(j);
        ci = getCIndividual(NIFDepen);
        deduzido+=ci.getdeduzido();
    }
    
    String escreve = "Faturas : " + result.toString() + "Deduzido : " + deduzido;
    return escreve;
}

/**
 * Lista de faturas ordenada pelo seu valor
 * @param c             O contribuinte empresarial que queremos informação
 * @return              uma string de Faturas
 */
public String listaFacturasPorValor(CEmpresas c){
    ArrayList<Factura> f = new ArrayList<Factura>();
    
    for(Factura f1 : c.getFaturas()){
        f.add(f1);
    }
    
    Collections.sort(f, new Comparator<Factura>() {
      public int compare(Factura f1, Factura f2){
            return Double.compare(f2.getDespesa(),f1.getDespesa());
        }
    });
    
    LinkedHashMap<String,Double> result = new LinkedHashMap<String,Double>();
    
    for(int i=0; i<f.size(); i++){
        result.put(f.get(i).getDesignacao(),f.get(i).getDespesa());
    }
    
    String escreve = result.toString();
    return escreve;
}

/**
 * Lista dos 10 contribuintes individuais que mais gastam.
 * 
 * @return              string com os 10 contribuintes individuais que mais gastam
 */
public String get10QueMaisGastam(){
    ArrayList<CIndividuais> ci = new ArrayList<CIndividuais>();
    for(CIndividuais c : contribuintesI.values()){
            ci.add(c);
    }
    
    Collections.sort(ci, new Comparator<CIndividuais>() {
        public int compare(CIndividuais c1, CIndividuais c2){
            return Double.compare(c2.getDespesaTotal(),c1.getDespesaTotal());
        }
    });
    
    LinkedHashMap<String,Double> result = new LinkedHashMap<String,Double>();
    
    for(int i=0; i<ci.size() && i<10; i++){
        result.put(ci.get(i).getNome(),ci.get(i).getDespesaTotal());
    }
    
    String escreve = result.toString();
    return escreve;
}

/**
 * Lista das empresas com mais faturas;
 * @param X             A quantidade de empresas que queremos comparar
 * @return              String das X empresas com mais faturas e a sua dedução
 */
public String empresasComMaisFaturas(int X){
    ArrayList<CEmpresas> ce = new ArrayList<CEmpresas>();
    
    for(CEmpresas c : contribuintesE.values()){
        ce.add(c);
    }
    
    Collections.sort(ce, new Comparator<CEmpresas>() {
        public int compare(CEmpresas c1, CEmpresas c2){
            return Double.compare(c2.getNFaturas(),c1.getNFaturas());
        }
    });
    
    LinkedHashMap<Integer,Double> result = new LinkedHashMap<Integer,Double>();
    
    for(int i=0; i<ce.size() && i<X; i++){
        result.put(ce.get(i).getNIF(),ce.get(i).getDeduc());
    }
    
    String escreve = result.toString();
    return escreve;
}

/**
 * Lista do total facturado por uma empresa num intervalo de tempo
 * @param newNif            NIF da empresa que queremos retirar informação
 * @param end               Data do fim
 * @param begin             Data do inicio
 * @return                  String com o total faturado pela empresa
 */
public String getTotalFacturado(int newNif,Date end, Date begin){
    double totalFacturado = 0.0;
    CEmpresas c = contribuintesE.get(newNif);
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

/**
 * Lista das facturas de uma empresa relativamente a um contribuinte individual
 * @param end                   Data do fim
 * @param begin                 Data do inicio
 * @param NIF                   Nif do contribuinte individual
 * @param c                     Empresa que queremos retirar informação
 * @return                      Lista ordenada por datas
 */
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

/**
 * Lista de Faturas ordenada por datas da mais antiga para a mais recente.
 * @param c                 Empresa que queremos retirar informação
 * @return                  Lista das faturas ordenadas por data
 */
public String listaFacturasPorData(CEmpresas c){
    ArrayList<Factura> f = new ArrayList<Factura>();
    
    for(Factura f1 : c.getFaturas()){
        f.add(f1);
    }
    
    Collections.sort(f, new Comparator<Factura>() {
      public int compare(Factura f1, Factura f2){
            return f2.getData().compareTo(f1.getData());
        } 
    });
    LinkedHashMap<String,Date> result = new LinkedHashMap<String,Date>();
    for(int i=0; i<f.size(); i++){
        result.put(f.get(i).getDesignacao(),f.get(i).getData());
    }
    
    String escreve = result.toString();
    return escreve;
}

/**
 * Lista de Faturas de um contribuinte individual de uma determinada empresa 
 * @param c                 Empresa que queremos retirar informação
 * @param NIF               NIF do contribuinte individual
 * @return                  Lista das facturas ordenadas por valor de despesa
 */
public String listaFacturasValorDespesa(CEmpresas c, int NIF){
    ArrayList<Factura> f = new ArrayList<Factura>();
    
    for(Factura f1 : c.getFaturas()){
        f.add(f1);
    }
    
    ArrayList<Factura> resultado = new ArrayList<Factura>();
    
    for(int i=0; i<f.size(); i++){
        if(f.get(i).getNIFCliente() == NIF){
         resultado.add(f.get(i));
        }
    }
    Collections.sort(f, new Comparator<Factura>() {
      public int compare(Factura f1, Factura f2){
            return Double.compare(f2.getDespesa(),f1.getDespesa());
        }
    });
        
    LinkedHashMap<String,Double> result = new LinkedHashMap<String,Double>();
    for (int j=0; j<resultado.size();j++){
     result.put(resultado.get(j).getDesignacao(),resultado.get(j).getDespesa());
 
    }
    String escreve= result.toString();
    return escreve;
}


/** 
 * Guarda os dados do programa.
 */
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
    
    EventQueue.invokeLater(new Runnable() {
        public void run(){
            try{
                Save_State io;
                io = new Save_State();
                io.ReadHashMap(contribuintesI,1);
                io.ReadHashMap(contribuintesE,2);
                
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    
    if(c==1){
       Login l = new Login();
          
    }
    if(c==2){
       Registo l = new Registo();

    }
    if(c==4){
        Administrador l = new Administrador ();
    }
    else{
       saveState();
       System.exit(0);
    }

}
}