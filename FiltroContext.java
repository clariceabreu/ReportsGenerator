public class FiltroContext {
  private FiltroStrategy strategy;

  public FiltroContext(FiltroStrategy strategy) {
    this.strategy = strategy;
  }

  public Produto [] filtra(Produto [] produtos) {
    return this.strategy.filtra(produtos);
  }
}