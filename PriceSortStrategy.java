import java.io.IOException;
public class PriceSortStrategy implements ISortStrategy {
    public PriceSortStrategy () {
    }

    public int compara (Produto i, Produto j) {
        if (i.getPreco() > j.getPreco()) {
            return 1;
        } else if (i.getPreco() < j.getPreco()) {
            return -1;
        } else {
            return 0;
        }
    }
}