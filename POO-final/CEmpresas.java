import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Classe que é subclasse de Contribuintes e que guarda a informação relativa aos Contribuintes Empresas.
 */
public class CEmpresas extends Contribuintes implements Serializable
{
    private static final long serialVersionUID = 1113799434508676095L;
    private double deducoes;
    private Concelho concelho;
    private int n_faturas;
    private double faturado;

    /**
     * COnstrutor para objetos da classe CEmpresas
     */
    public CEmpresas()
    {
        this.deducoes=0.0;
        this.n_faturas = 0;
        this.faturado = 0.0;
    }

    public CEmpresas(int NIF, String Email, String nome, String morada, String password,
    String tipoConcelho){
        this.NIF=NIF;
        this.email=Email;
        this.nome=nome;
        this.morada=morada;
        this.password=password;
        this.concelho=Concelho.valueOf(tipoConcelho);
        this.faturas = new ArrayList<Factura>();
        this.n_faturas = (int) 0;
        this.faturado = (double) 0;
        this.deducoes=(double) 0.0;
    }
    
    public CEmpresas(CEmpresas novoContribuinte){
        this.deducoes=novoContribuinte.getDeduc();
        this.n_faturas=novoContribuinte.getNFaturas();
        this.faturado=novoContribuinte.getFaturado();
    }
    
     public int getNFaturas(){
        return this.n_faturas;
    }
    
    public double getFaturado(){
        return this.faturado;
    }
    
    public double getDeduc(){
        return this.deducoes;
    }
    
    public void setDeduções (double deducoes){
        this.deducoes=deducoes;
    }
    
    public boolean equals (CEmpresas ce){
        return (this.deducoes==ce.getDeduc() && this.n_faturas==ce.getNFaturas() &&
        this.faturado==ce.getFaturado());
    }
    
    public String toString(){
        return("Deduções :" + this.deducoes + "Nº Faturas :" + this.n_faturas +
        "Faturado :" + this.faturado);
    }
    
    /**
     * Função que adiciona faturas num determinado contribuinte individual
     * @param f                 Fatura que pretendemos adicionar
     * @param c                 Contribuinte a quem corresponde a fatura
     */
     public void setFaturas(Factura f,CIndividuais c) { // adicionar dedução
        c.faturas.add(f);
        c.addDedutivel(f);
        this.faturado += f.getDespesa();
        this.deducoes += f.getDespesa()*concelho.getDeducao();
        this.n_faturas++;
    }
    
}

