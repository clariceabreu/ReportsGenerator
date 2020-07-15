import java.io.IOException;
public class CriterioEstoqueStrategy implements CriterioStrategy {

    private boolean crescente;

    public CriterioEstoqueStrategy (boolean crescente) {
        this.crescente = crescente;
    }

    public int compara (Produto i, Produto j) {
        if (i.getQtdEstoque() > j.getQtdEstoque()) {
            return crescente ? 1 : -1;
        } else if (i.getQtdEstoque() < j.getQtdEstoque()){
            return crescente ? -1 : 1;
        } else {
            return 0;
        }
    }
}