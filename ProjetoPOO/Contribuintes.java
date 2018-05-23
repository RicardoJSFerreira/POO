import java.util.ArrayList;
/**
 * Classe abstrata Contribuintes - escreva a descrição da classe aqui
 * 
 * @author (seu nome aqui)
 * @version (versão ou data)
 */
public abstract class Contribuintes
{
    
    
    protected int NIF;
    protected String email;
    protected String nome;
    protected String morada;
    protected int password;
    
    protected ArrayList<Factura> faturas;
    /**
     * COnstrutor para objetos da classe Contribuintes
     */
    
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
    public boolean equals (Contribuintes con){
        return (this.NIF==con.getNIF() && this.email==con.getEmail() && this.nome==con.getNome () 
        && this.morada ==con.getMorada() && this.password==con.getPassword());
        
    }
    
    public String toString(){
        return ("Número de contribuinte :"+this.NIF + "Email:" + this.email+ "Nome:"+this.nome+ 
        "Morada fiscal :"+ this.morada + "Password :" + this.password);
        
    }
    
    public ArrayList<Factura> getFaturas(){
        ArrayList<Factura>res= new ArrayList<>(faturas.size());
        for(Factura x : faturas){
            res.add(x.clone());
        }
        return res;
    }
}
