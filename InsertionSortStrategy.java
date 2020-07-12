import java.io.IOException;
public class InsertionSortStrategy implements IAlgorithmStrategy {
    
    private Produto [] produtos;
    private int criterio;
    

    public InsertionSortStrategy (Produto [] produtos, int criterio) {
        this.produtos = produtos;
        this.criterio = criterio;
    }

    public Produto [] ordena() {
        ordena(0, produtos.length - 1);
        return produtos;
    }

    private void ordena (int ini, int fim) {
        for(int i = ini; i <= fim; i++) {
            Produto x = produtos[i];				
            int j = (i - 1);

            while (j >= ini){
                if(criterio == 0) {
                    if (x.getDescricao().compareToIgnoreCase(produtos[j].getDescricao()) < 0 ) {
                        produtos[j + 1] = produtos[j];
                        j--;
                    }
                    else break;
                } else if (criterio == 1) {
                    if (x.getPreco() < produtos[j].getPreco()) {       
                        produtos[j + 1] = produtos[j];
                        j--;
                    }
                    else break;
                } else if (criterio == 2) {
                    if (x.getQtdEstoque() < produtos[j].getQtdEstoque()) {
                        produtos[j + 1] = produtos[j];
                        j--;
                    }
                    else break;
                }
                else throw new RuntimeException("Criterio invalido!");
            }
            produtos[j + 1] = x;
        }
    }
}
