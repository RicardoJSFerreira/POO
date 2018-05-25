import java.util.List;
public class CEmpresas extends Contribuintes
{
    private String[] ativEconomicas;
    private double deducoes;
    private Concelho concelho;
    private int n_faturas;
    private double faturado;
    private List<Integer> IndivAdicionados;

    /**
     * COnstrutor para objetos da classe CEmpresas
     */
    public CEmpresas()
    {
        this.ativEconomicas=null;
        this.deducoes=0.0;
    }

    public CEmpresas(int NIF, String Email, String nome, String morada, String password,
    String[] new_ativEcon, double new_deducoes){
        this.NIF=NIF;
        this.email=Email;
        this.nome=nome;
        this.morada=morada;
        this.password=password;
        this.ativEconomicas=new_ativEcon;
        this.deducoes=new_deducoes;
    }
    
    public CEmpresas(CEmpresas novoContribuinte){
        this.ativEconomicas=novoContribuinte.getAtiv();
        this.deducoes=novoContribuinte.getDeduc();
    }
    
     public int getNFaturas(){
        return this.n_faturas;
    }
    
    public double getFaturado(){
        return this.faturado;
    }
    
    public String[] getAtiv(){
        return this.ativEconomicas;
    }
    
    public double getDeduc(){
        return this.deducoes;
    }
    
    public void setAtivEconomicas (String[] ativEconomicas){
        this.ativEconomicas=ativEconomicas;
    }
    
    public void setDeduções (double deducoes){
        this.deducoes=deducoes;
    }
    
    public boolean equals (CEmpresas ce){
        return (this.ativEconomicas == ce.getAtiv() && this.deducoes==ce.getDeduc());
    }
    
    public String toString(){
        return("Atividades económicas:" + this.ativEconomicas + "Deduções :" + this.deducoes);
    }
    
     public void setFaturas(Factura f,CIndividuais c) { // adicionar dedução
        c.faturas.add(f);
        c.addDedutivel(f);
        this.faturado += f.getDespesa();
        this.deducoes = f.getDespesa()*this.concelho.getDeducao();
        this.n_faturas++;
        this.IndivAdicionados.add(c.getNIF());
    }
    
}

