import java.io.Serializable;
/**
 * Enum do tipo de factura.
 */
public enum TipoFactura implements Serializable
{    
    DESPESASGERAIS  (0.35),
    SAUDE   (0.15),
    EDUCACAO(0.3),
    HABITACAO(0.15),
    LARES(0.25),
    REPARACAOAUTOMOVEIS(0.0),
    REPARACAOMOTOCICLOS(0.0),
    RESTAURACAOEALOJAMENTO(0.0),
    CABELEIREIROS(0.0),
    ATIVIDADESVETERINARIAS(0.0),
    PASSESMENSAIS(0.0);
    
    private final double deducao;
    
    TipoFactura(double deducao) {
        this.deducao = deducao;
    }
    
    public double getDeducao(){
        return this.deducao;
    }
}
