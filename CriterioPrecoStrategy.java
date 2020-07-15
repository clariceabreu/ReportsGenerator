import java.io.IOException;
public class CriterioPrecoStrategy implements CriterioStrategy {

    private boolean crescente;

    public CriterioPrecoStrategy (boolean crescente) {
        this.crescente = crescente;
    }

    public int compara (Produto i, Produto j) {
        if (i.getPreco() > j.getPreco()) {
            return crescente ? 1 : -1;
        } else if (i.getPreco() < j.getPreco()) {
            return crescente ? -1 : 1;
        } else {
            return 0;
        }
    }
}