import java.util.ArrayList;
import java.util.List;

public class FiltroCategoriaStrategy implements FiltroStrategy {
  private String categoria;

  public FiltroCategoriaStrategy(String categoria) {
    this.categoria = categoria;
  }

  public Produto [] filtra(Produto []  produtos) {
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

