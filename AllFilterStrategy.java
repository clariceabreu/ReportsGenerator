public class AllFilterStrategy implements IFilterStrategy {
    private Produto [] produtos;
    
    public AllFilterStrategy(Produto [] produtos) {
      this.produtos = produtos;
    }

    public Produto [] filtra() {
      return produtos;
    }
}
