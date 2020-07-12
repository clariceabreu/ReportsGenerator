import java.io.IOException;
public class StockSortStrategy implements ISortStrategy {

    public StockSortStrategy (Produto [] produtos) {
    }
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