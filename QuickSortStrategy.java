import java.io.IOException;
public class QuickSortStrategy implements IAlgorithmStrategy {

	private Produto [] produtos;
	private ISortStrategy criterio;

	public QuickSortStrategy (Produto [] produtos, ISortStrategy criterio) {
		this.produtos = produtos;
		this.criterio = criterio;
	}

	public Produto [] ordena() {
		ordena(0, produtos.length - 1);
		return produtos;
	}
	
	private void ordena(int ini, int fim) {
		if(ini < fim) {
			int q = particiona (ini, fim);
			ordena(ini, q);
			ordena(q + 1, fim);
		}
	}
	
	private int particiona (int ini, int fim) {
		Produto x = produtos[ini];
		int i = (ini - 1);
		int j = (fim + 1);

		while(true) {
			do { 
					j--;
			} while (criterio.compara(produtos[j], x) > 0);
			do {
					i++;
			} while (criterio.compara(produtos[i], x) < 0);
			
			if (i < j) {
					Produto temp = produtos[i];
					produtos[i] = produtos[j]; 				
					produtos[j] = temp;
			}
			else return j;
		}
	}
}