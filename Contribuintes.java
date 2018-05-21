import java.util.List;
import java.util.ArrayList;
import java.util.*;
/**
 * Escreva a descrição da classe Contribuintes aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Contribuintes
{
    private int NIF;
    private String email;
    private String nome;
    private String morada;
    private int password;
    
    private ArrayList<Factura> faturas;
    /**
     * COnstrutor para objetos da classe Contribuintes
     */
    public Contribuintes()
    {
        this.NIF=0;
        this.email=null;
        this.nome=null;
        this.morada=null;
        this.password=0;
        this.faturas=new ArrayList<>();
    }
    
    public Contribuintes(int new_NIF, String new_mail, String new_nome, String new_morada, int new_pass
    , ArrayList<Factura> l){
        this.NIF=new_NIF;
        this.email=new_mail;
        this.nome=new_nome;
        this.morada=new_morada;
        this.password=new_pass;
        setFaturas(l);
    }
    
    public Contribuintes(Contribuintes novoContribuinte){
        this.NIF=novoContribuinte.getNIF();
        this.email=novoContribuinte.getEmail();
        this.nome=novoContribuinte.getNome();
        this.morada=novoContribuinte.getMorada();
        this.password=novoContribuinte.getPassword();
        this.faturas=novoContribuinte.getFaturas();
    }
    
        public int getNIF(){
        return this.NIF;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getMorada(){
        return this.morada;
    }
    
    public int getPassword(){
        return this.password;
    }
    
    public ArrayList<Factura> getFaturas(){
        ArrayList<Factura>res= new ArrayList<>(faturas.size());
        for(Factura x : faturas){
            res.add(x.clone());
        }
        return res;
    }
    
    public void setNIF(int NIF){
        this.NIF=NIF;
    }
    
    public void setEmail (String email){
        this.email=email;
    }
    
    public void setNome (String nome){
        this.nome=nome;
    }
    
    public void setMorada (String morada){
        this.morada=morada;
    }
    
    public void setPassword (int password){
        this.password=password;
    }
    
    public void setFaturas(ArrayList<Factura> new_faturas){
        faturas=new ArrayList<>(new_faturas.size());
        
        for(Iterator<Factura>it=new_faturas.iterator(); it.hasNext();){
            Factura f = it.next();
            faturas.add(f.clone());
        }
    }
    
    public Contribuintes clone(){
        Contribuintes novo = new Contribuintes(this);
        return novo;
    }
    
}
