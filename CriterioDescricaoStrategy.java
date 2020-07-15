import java.io.IOException;
public class CriterioDescricaoStrategy implements CriterioStrategy {

    private boolean crescente;

    public CriterioDescricaoStrategy(boolean crescente) {
        this.crescente = crescente;
    }

    public int compara (Produto i, Produto j) {
        if (i.getDescricao().compareToIgnoreCase(j.getDescricao()) > 0) {
            return crescente ? 1 : -1;
        } else if (i.getDescricao().compareToIgnoreCase(j.getDescricao()) < 0) {
            return crescente ? -1 : 1;
        } else {
            return 0;
        }
    }
}