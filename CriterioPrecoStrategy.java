import java.io.IOException;
public class CriterioPrecoStrategy implements CriterioStrategy {
    public CriterioPrecoStrategy () {
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