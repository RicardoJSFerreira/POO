
public class CEmpresas extends Contribuintes
{
    private String[] ativEconomicas;
    private int[] deduções;

    /**
     * COnstrutor para objetos da classe CEmpresas
     */
    public CEmpresas()
    {
        this.ativEconomicas=null;
        this.deduções=null;
    }

    public CEmpresas(int new_NIF, String new_mail, String new_nome, String new_morada, int new_pass,
     String[] new_ativEcon, int[] new_deduções){
        this.ativEconomicas=new_ativEcon;
        this.deduções=new_deduções;
    }
    
    public CEmpresas(CEmpresas novoContribuinte){
        this.ativEconomicas=novoContribuinte.getAtiv();
        this.deduções=novoContribuinte.getDeduc();
    }
    
    public String[] getAtiv(){
        return this.ativEconomicas;
    }
    
    public int[] getDeduc(){
        return this.deduções;
    }
    
    public void setAtivEconomicas (String[] ativEconomicas){
        this.ativEconomicas=ativEconomicas;
    }
    
    public void setDeduções (int[] deduções){
        this.deduções=deduções;
    }
}
