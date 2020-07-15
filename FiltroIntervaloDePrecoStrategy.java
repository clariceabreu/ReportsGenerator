import java.util.ArrayList;
import java.util.List;

public class FiltroIntervaloDePrecoStrategy implements FiltroStrategy {
  private double precoInicial;
  private double precoFinal;
  
  public FiltroIntervaloDePrecoStrategy (double precoInicial, double precoFinal) {
    this.precoInicial = precoInicial;
    this.precoFinal = precoFinal;
  }

  public Produto [] filtra(Produto []  produtos) {
    List<Produto> produtosFiltrados = new ArrayList<>();

    for (int i  = 0; i < produtos.length; i++) {
      if (produtos[i].getPreco() >= precoInicial && produtos[i].getPreco() <= precoFinal) {
        produtosFiltrados.add(produtos[i]);
      }
    }

    Produto[] produtosFiltradosArray = new Produto[produtosFiltrados.size()];
    return produtosFiltrados.toArray(produtosFiltradosArray);
  }
}
