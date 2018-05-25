import java.time.LocalDate;
import java.util.Date;
/**
 * Classe que cria uma Fatura.
 */
public class Factura
{
    private int NIFEmitente;
    private String designacao;
    private Date data;
    private int NIFCliente;
    private TipoFactura fat;
    private String descricao;
    private double valorDespesa;
    
    public Factura()
    {
        this.NIFEmitente = 0;
        this.designacao = null;
        this.data = null;
        this.NIFCliente = 0;
        this.descricao = null;
        this.valorDespesa = 0;
    }

    public Factura(int NIFEmitente, String designacao, Date data, int NIFCliente,
    TipoFactura fat, String descricao, double valorDespesa){
        this.NIFEmitente = NIFEmitente;
        this.designacao = designacao;
        this.data = data;
        this.NIFCliente = NIFCliente;
        this.fat = fat;
        this.descricao = descricao;
        this.valorDespesa = valorDespesa;
    }
    
    public Factura(Factura umaFactura){
        this.NIFEmitente = umaFactura.getNIFEmitente();
        this.designacao = umaFactura.getDesignacao();
        this.data = umaFactura.getData();
        this.NIFCliente = umaFactura.getNIFCliente();
        this.descricao = umaFactura.getDescricao();
        this.valorDespesa = umaFactura.getDespesa();
    }
    
    public int getNIFEmitente(){
        return this.NIFEmitente;
    }
    
    public String getDesignacao(){
        return this.designacao;
    }
    
    public Date getData(){
        return this.data;
    }
    
    public int getNIFCliente(){
        return this.NIFCliente;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public double getDespesa(){
        return this.valorDespesa;
    }
    
    public void setNIFE(int NIFEmitente){
        this.NIFEmitente = NIFEmitente;
    }
    
    public void setDesignacao(String designacao){
        this.designacao = designacao;
    }
    
    public void setData(Date data){
        this.data = data;
    }
    
    public void setNIFC(int NIFCliente){
        this.NIFCliente = NIFCliente;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public void setTipoFactura(TipoFactura f){
        this.fat = f;
    }
    
    public void setDespesa(double despesa){
        this.valorDespesa = despesa;
    }
    
    public boolean equals (Factura f){
        return(this.NIFEmitente==f.getNIFEmitente() && this.designacao==f.getDesignacao() && this.data==f.getData() && 
        this.NIFCliente==f.getNIFCliente() && this.descricao==f.getDescricao() && this.valorDespesa==f.getDespesa());
    
    }
    
    public String toString(){
        return("Número de contribuinte Emitente:" +this.NIFEmitente + "Designação:" +this.designacao + "Data de emissão da fatura:"+
        this.data+ "Número de contribuinte cliente:" + this.NIFCliente + "Descrição :" + this.descricao + "Valor da despesa:"
        +this.valorDespesa);
        
    }
    
    public Factura clone(){
        return new Factura(this);
    }
    
    public double retornaDedutivel(Factura f){
        return (f.getDespesa()*fat.getDeducao());
    }
    
}
