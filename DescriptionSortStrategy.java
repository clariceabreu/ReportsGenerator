import java.io.IOException;
public class DescriptionSortStrategy implements ISortStrategy {

    public DescriptionSortStrategy() {
        
    }

    public int compara (Produto i, Produto j) {
        if (i.getDescricao().compareToIgnoreCase(j.getDescricao()) > 0) {
            return 1;
        } else if (i.getDescricao().compareToIgnoreCase(j.getDescricao()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}