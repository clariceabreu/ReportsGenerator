import java.util.ArrayList;
import java.util.List;

public class FiltroPalavraStrategy implements FiltroStrategy {
  private String palavra;

  public FiltroPalavraStrategy(String palavra) {
    this.palavra = palavra;
  }

  public Produto [] filtra(Produto []  produtos) {
    List<Produto> produtosFiltrados = new ArrayList<>();

    for (int i  = 0; i < produtos.length; i++) {
      // .* indica todos os caracteres, exceto a quebra de linha
      // (?i) ignora maiúsculas e maiúsculas
      if (produtos[i].getDescricao().matches(".*(?i)" + palavra + ".*") == true) {
        produtosFiltrados.add(produtos[i]);
      }
    }

    Produto[] produtosFiltradosArray = new Produto[produtosFiltrados.size()];
    return produtosFiltrados.toArray(produtosFiltradosArray);
  }
}

