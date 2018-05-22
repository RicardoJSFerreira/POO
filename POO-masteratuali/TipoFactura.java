
/**
 * Enumeration class TipoFactura - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum TipoFactura
{    
    DESPESASGERAIS  (0.35,250.0),
    SAUDE   (0.15,1000.0),
    EDUCACAO(0.3,800.0),
    HABITACAO(0.15,296.0),
    LARES(0.25,403.75),
    REPARACAOAUTOMOVEIS(0.0,0.0),
    REPARACAOMOTOCICLOS(0.0,0.0),
    RESTAURACAOEALOJAMENTO(0.0,0.0),
    CABELEIREIROS(0.0,0.0),
    ATIVIDADESVETERINARIAS(0.0,0.0),
    PASSESMENSAIS(0.0,0.0);
    
    private final double deducao;
    private final double valormaximo;
    
    TipoFactura(double deducao, double valormaximo) {
        this.deducao = deducao;
        this.valormaximo = valormaximo;
    }
    
    public double getDeducao(){
        return this.deducao;
    }
    public double getValormaximo(){
        return this.valormaximo;
    }
}
