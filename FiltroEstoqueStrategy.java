import java.util.ArrayList;
import java.util.List;

public class FiltroEstoqueStrategy implements FiltroStrategy {
  private int quantidade;
  
  public FiltroEstoqueStrategy(int quantidade) {
    this.quantidade = quantidade;
  }

  public Produto [] filtra(Produto []  produtos) {
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
