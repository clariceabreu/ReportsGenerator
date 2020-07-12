import java.util.ArrayList;
import java.util.List;
public class CategoryFilterStrategy implements IFilterStrategy {
  private Produto [] produtos;
  private String categoria;

  public CategoryFilterStrategy(Produto[] produtos, String categoria) {
    this.produtos = produtos;
    this.categoria = categoria;
  }


  public Produto [] filtra() {
    List<Produto> produtosFiltrados = new ArrayList<>();

      for (int i  = 0; i < produtos.length; i++) {
        if (produtos[i].getCategoria().equalsIgnoreCase(categoria)) {
          produtosFiltrados.add(produtos[i]);
        }
      }

      Produto[] produtosFiltradosArray = new Produto[produtosFiltrados.size()];
      return produtosFiltrados.toArray(produtosFiltradosArray);
  }
}

