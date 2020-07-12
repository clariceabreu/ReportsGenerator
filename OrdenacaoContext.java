public class OrdenacaoContext {
  private OrdenacaoStrategy strategy;

  public OrdenacaoContext(OrdenacaoStrategy strategy) {
    this.strategy = strategy;
  }

  public Produto [] ordena(Produto [] produtos) {
    return this.strategy.ordena(produtos);
  }
}