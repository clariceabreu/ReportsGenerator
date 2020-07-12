public class Filter implements IFilterStrategy {
  private IFilterStrategy strategy;

  public Filter(IFilterStrategy strategy) {
    this.strategy = strategy;
  }

  public Produto [] filtra() {
    return this.strategy.filtra();
  }
}