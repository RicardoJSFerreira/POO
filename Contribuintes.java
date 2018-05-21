import java.util.List;
import java.util.ArrayList;
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
    }
    
    public Contribuintes(int new_NIF, String new_mail, String new_nome, String new_morada, int new_pass){
        this.NIF=new_NIF;
        this.email=new_mail;
        this.nome=new_nome;
        this.morada=new_morada;
        this.password=new_pass;
    }
    
    public Contribuintes(Contribuintes novoContribuinte){
        this.NIF=novoContribuinte.getNIF();
        this.email=novoContribuinte.getEmail();
        this.nome=novoContribuinte.getNome();
        this.morada=novoContribuinte.getMorada();
        this.password=novoContribuinte.getPassword();
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
    
    public Contribuintes clone(){
        Contribuintes novo = new Contribuintes(this);
        return novo;
    }
    
}
