
public class CIndividuais extends Contribuintes
{
    private int dependentes;
    private int[] NIFdependentes;
    private double coefFiscal;
    private int[] ativEconomicas;

    /**
     * COnstrutor para objetos da classe CIndividuais
     */
    public CIndividuais()
    {
        this.dependentes=0;
        this.NIFdependentes=null;
        this.coefFiscal=0;
        this.ativEconomicas=null;
    }
    
    public CIndividuais(int new_dependentes,int[] new_NIFdependentes, double new_coefFiscal, int[] new_ativEcon){
        this.dependentes=new_dependentes;
        this.NIFdependentes=new_NIFdependentes;
        this.coefFiscal=new_coefFiscal;
        this.ativEconomicas=new_ativEcon;
    }

    public CIndividuais(CIndividuais novoContribuinte){
        this.dependentes=novoContribuinte.getDepen();
        this.NIFdependentes=novoContribuinte.getNIFdepen();
        this.coefFiscal=novoContribuinte.getCoef();
        this.ativEconomicas=novoContribuinte.getAtiv();
    }
    
    public int getDepen(){
        return this.dependentes;
    }
    
    public int[] getNIFdepen(){
        return this.NIFdependentes;
    }
    
    public double getCoef(){
        return this.coefFiscal;
    }
    
    public int[] getAtiv(){
        return this.ativEconomicas;
    }
    
    public void setDepen (int dependentes){
        this.dependentes=dependentes;
    }
    
    public void setNIFdepen (int[] NIFdependentes){
        this.NIFdependentes=NIFdependentes;
    }
    
    public void setCoefFiscal (double coefFiscal){
        this.coefFiscal=coefFiscal;
    }
    
    public void setAtivEconomicas (int[] ativEconomicas){
        this.ativEconomicas=ativEconomicas;
    }
}
