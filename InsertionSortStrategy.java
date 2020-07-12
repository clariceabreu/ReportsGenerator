import java.io.IOException;
public class InsertionSortStrategy implements OrdenacaoStrategy {
    
    private Produto [] produtos;
    private CriterioStrategy criterio;

    public InsertionSortStrategy (CriterioStrategy criterio) {
        this.criterio = criterio;
    }

    public Produto [] ordena(Produto [] produtos) {
        this.produtos = produtos;
        ordena(0, produtos.length - 1);
        return this.produtos;
    }

    private void ordena (int ini, int fim) {
        for(int i = ini; i <= fim; i++) {
            Produto x = produtos[i];				
            int j = (i - 1);

            while (j >= ini){
                if (criterio.compara(x, produtos[j]) < 0) {
                        produtos[j + 1] = produtos[j];
                        j--;
                }
                else break;
            }
            produtos[j + 1] = x;
        }
    }
}
