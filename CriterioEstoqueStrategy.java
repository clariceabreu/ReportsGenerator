import java.io.IOException;
public class CriterioEstoqueStrategy implements CriterioStrategy {

    public CriterioEstoqueStrategy () { }

    public int compara (Produto i, Produto j) {
        if (i.getQtdEstoque() > j.getQtdEstoque()) {
            return 1;
        } else if (i.getQtdEstoque() < j.getQtdEstoque()){
            return -1;
        } else {
            return 0;
        }
    }
}