import java.io.Serializable;
import java.util.ArrayList;
/**
 * Classe que é subclasse de Contribuintes e que guarda a informação relativa aos Contribuintes individuais.
 * 
 */
public class CIndividuais extends Contribuintes implements Serializable
{
    private static final long serialVersionUID = 1113799434508676095L;
    private int dependentes;
    private ArrayList<Integer> NIFdependentes;
    private double coefFiscal;
    private double despesaTotal;
    private double deduzido;

    /**
     * COnstrutor para objetos da classe CIndividuais
     */
    public CIndividuais()
    {
        this.dependentes=0;
        this.NIFdependentes=null;
        this.coefFiscal=0;
        this.despesaTotal=0;
        this.deduzido=0;
    }
    
    public CIndividuais(int NIF, String Email, String nome, String morada, String password,
    int new_dependentes, ArrayList<Integer> new_NIFdependentes){
        this.NIF=NIF;
        this.email=Email;
        this.nome=nome;
        this.morada=morada;
        this.password=password;
        this.faturas=new ArrayList<Factura>();
        this.dependentes=new_dependentes;
        this.NIFdependentes=new_NIFdependentes;
        this.despesaTotal=0;
        this.deduzido=0;
    }

    public CIndividuais(CIndividuais novoContribuinte){
        this.dependentes=novoContribuinte.getDepen();
        this.NIFdependentes=novoContribuinte.getNIFdepen();
        this.coefFiscal=novoContribuinte.getCoef();
        this.deduzido=novoContribuinte.getdeduzido();
        this.despesaTotal=novoContribuinte.getDespesaTotal();
    }
    
    public int getDepen(){
        return this.dependentes;
    }
    
    public ArrayList<Integer> getNIFdepen(){
        
        ArrayList<Integer>res= new ArrayList<>(NIFdependentes.size());
        for(int x : NIFdependentes){
            res.add(x);
        }
        return res;
    }
    
    public double getCoef(){
        return this.coefFiscal;
    }
    
    public double getDespesaTotal(){
        return this.despesaTotal;
    }
    
    public double getdeduzido(){
        return this.deduzido;   
    }
    
    public void setDepen (int dependentes){
        this.dependentes=dependentes;
    }
    
    public void setNIFdepen (ArrayList<Integer> NIFdependentes){
        this.NIFdependentes=NIFdependentes;
    }
    
    public void setCoefFiscal (double coefFiscal){
        this.coefFiscal=coefFiscal;
    }
    
    public void setdeduzido (double deduzido){
        this.deduzido=deduzido;
    }
    
    public boolean equals (CIndividuais ci){
        return (this.dependentes==ci.getDepen() && this.NIFdependentes==ci.getNIFdepen() && 
        this.coefFiscal==ci.getCoef());
    }
    
    public String toString(){
        return ("Número de dependentes :" + this.dependentes + " Número de contribuinte do dependente:" + this.NIFdependentes + 
        "Coeficiente fiscal :" + this.coefFiscal);
       
    }
    
    public void addDedutivel(Factura f){
        this.despesaTotal += f.getDespesa();
        this.deduzido += f.retornaDedutivel(f);
    }
}
