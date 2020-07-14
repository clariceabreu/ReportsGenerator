import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

public class GeradorDeRelatorios {
	private Produto [] produtos;
	private Map<Integer, FormatacaoDecorator> formatacaoProdutos;

	public GeradorDeRelatorios(Produto [] produtos, Map<Integer, FormatacaoDecorator> formatacaoProdutos){
		this.produtos = produtos;
		this.formatacaoProdutos = formatacaoProdutos;
	}
	
	public void geraRelatorio(String arquivoSaida) throws IOException {
		PrintWriter out = new PrintWriter(arquivoSaida);

		out.println("<!DOCTYPE html><html>");
		out.println("<head><title>Relatorio de produtos</title></head>");
		out.println("<body>");
		out.println("Relatorio de Produtos:");
		out.println("<ul>");

		int count = 0;

		for(Produto p : produtos){

			out.print("<li>");

			FormatacaoDecorator formatacaoDecorator = formatacaoProdutos.get(p.getId());
			formatacaoDecorator.imprime(out, p.formataParaImpressao());

			out.println("</li>");
			count++;
		}

		out.println("</ul>");
		out.println(count + " produtos listados, de um total de " + produtos.length + ".");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

	public static Produto [] carregaProdutos(){

		return new Produto [] { 

			new ProdutoPadrao( 1, "O Hobbit", "Livros", 2, 34.90),
			new ProdutoPadrao( 2, "Notebook Core i7", "Informatica", 5, 1999.90),
			new ProdutoPadrao( 3, "Resident Evil 4", "Games", 7, 79.90),
			new ProdutoPadrao( 4, "iPhone", "Telefonia", 8, 4999.90),
			new ProdutoPadrao( 5, "Calculo I", "Livros", 20, 55.00),
			new ProdutoPadrao( 6, "Power Glove", "Games", 3, 499.90),
			new ProdutoPadrao( 7, "Microsoft HoloLens", "Informatica", 1, 19900.00),
			new ProdutoPadrao( 8, "OpenGL Programming Guide", "Livros", 4, 89.90),
			new ProdutoPadrao( 9, "Vectrex", "Games", 1, 799.90),
			new ProdutoPadrao(10, "Carregador iPhone", "Telefonia", 15, 499.90),
			new ProdutoPadrao(11, "Introduction to Algorithms", "Livros", 7, 315.00),
			new ProdutoPadrao(12, "Daytona USA (Arcade)", "Games", 1, 12000.00),
			new ProdutoPadrao(13, "Neuromancer", "Livros", 5, 45.00),
			new ProdutoPadrao(14, "Nokia 3100", "Telefonia", 4, 249.99),
			new ProdutoPadrao(15, "Oculus Rift", "Games", 1, 3600.00),
			new ProdutoPadrao(16, "Trackball Logitech", "Informatica", 1, 250.00),
			new ProdutoPadrao(17, "After Burner II (Arcade)", "Games", 2, 8900.0),
			new ProdutoPadrao(18, "Assembly for Dummies", "Livros", 30, 129.90),
			new ProdutoPadrao(19, "iPhone (usado)", "Telefonia", 3, 3999.90),
			new ProdutoPadrao(20, "Game Programming Patterns", "Livros", 1, 299.90),
			new ProdutoPadrao(21, "Playstation 2", "Games", 10, 499.90),
			new ProdutoPadrao(22, "Carregador Nokia", "Telefonia", 14, 89.00),
			new ProdutoPadrao(23, "Placa Aceleradora Voodoo 2", "Informatica", 4, 189.00),
			new ProdutoPadrao(24, "Stunts", "Games", 3, 19.90),
			new ProdutoPadrao(25, "Carregador Generico", "Telefonia", 9, 30.00),
			new ProdutoPadrao(26, "Monitor VGA 14 polegadas", "Informatica", 2, 199.90),
			new ProdutoPadrao(27, "Nokia N-Gage", "Telefonia", 9, 699.00),
			new ProdutoPadrao(28, "Disquetes Maxell 5.25 polegadas (caixa com 10 unidades)", "Informatica", 23, 49.00),
			new ProdutoPadrao(29, "Alone in The Dark", "Games", 11, 59.00),
			new ProdutoPadrao(30, "The Art of Computer Programming Vol. 1", "Livros", 3, 240.00),
			new ProdutoPadrao(31, "The Art of Computer Programming Vol. 2", "Livros", 2, 200.00),
			new ProdutoPadrao(32, "The Art of Computer Programming Vol. 3", "Livros", 4, 270.00)
		};
	} 

	public static Map<Integer, FormatacaoDecorator> formataProdutos(Produto [] produtos) {
		Map<Integer, FormatacaoDecorator> formatacaoProdutos = new  HashMap<>();

		for (int i = 0; i < produtos.length; i++) {
			FormatacaoDecorator formatacao = new FormatacaoPadrao();

			if (produtos[i].getQtdEstoque() >= 10) {
				formatacao = new CorDecorator(formatacao, Color.BLUE);
			} else if (produtos[i].getQtdEstoque() <= 5) {
				formatacao = new NegritoDecorator(formatacao);
				formatacao = new CorDecorator(formatacao, Color.RED);
			} else {
				formatacao = new ItalicoDecorator(formatacao);
				formatacao = new CorDecorator(formatacao, new Color(238, 173, 45));
			}

			formatacaoProdutos.put(produtos[i].getId(), formatacao);
		}

		return  formatacaoProdutos;
	}

	public static void main(String [] args) {
	
		Produto [] produtos = carregaProdutos();
		/*
			Filtros disponíveis:
			FiltroTodosStrategy(): exibe todos os produtos
			FiltroCategoriaStrategy(String categoria): exibe apenas os produtos da categoria enviada como parâmetro
			FiltroEstoqueStrategy(int quantidade): exibe apenas os produtos com estoque menor ou igual a quantidade enviada como parâmetro
		*/
		FiltroStrategy filtroStrategy = new FiltroEstoqueStrategy(10);
		FiltroContext filtro = new FiltroContext(filtroStrategy);
		produtos = filtro.filtra(produtos);
		/*
			Algoritimos de ordenação disponíveis:
			QuickSortStrategy(CriterioStrategy criterio): odena através do algoritimo QuickSort a partir do criterio enviado como parâmetro
			InsertionSortStratefy(CriterioStrategy criterio): odena através do algoritimo InsertionSort a partir do criterio enviado como parâmetro

			Criterios de ordenação disponíveis:
			CriterioEstoqueStrategy(): compara os produtos de acordo com a quantidade de estoque em sentido crescente
			CriterioPrecoStrategy(): compara os produtos de acordo com o preço em sentido crescente
		*/
		OrdenacaoStrategy ordenacaoStrategy = new QuickSortStrategy(new CriterioEstoqueStrategy());
		OrdenacaoContext ordenacao = new OrdenacaoContext(ordenacaoStrategy);
		produtos = ordenacao.ordena(produtos);

		Map<Integer, FormatacaoDecorator> formatacaoProdutos = formataProdutos(produtos);

		GeradorDeRelatorios gdr = new GeradorDeRelatorios(produtos, formatacaoProdutos);
		
		try{
			gdr.geraRelatorio("saida.html");
		}
		catch(IOException e){
			
			e.printStackTrace();
		}
	}
}