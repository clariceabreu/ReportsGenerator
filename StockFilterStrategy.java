import java.util.ArrayList;
import java.util.List;
public class StockFilterStrategy implements IFilterStrategy {
    private Produto [] produtos;
    private int quantidade;
    
    public StockFilterStrategy(Produto [] produtos, int quantidade) {
      this.produtos = produtos;
      this.quantidade = quantidade;
    }

    public Produto [] filtra() {
      List<Produto> produtosFiltrados = new ArrayList<>();

      for (int i  = 0; i < produtos.length; i++) {
        if (produtos[i].getQtdEstoque() <= quantidade) {
          produtosFiltrados.add(produtos[i]);
        }
      }

      Produto[] produtosFiltradosArray = new Produto[produtosFiltrados.size()];
      return produtosFiltrados.toArray(produtosFiltradosArray);
    }
}
