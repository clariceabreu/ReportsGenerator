import java.io.PrintWriter;

public class PadraoDecorator implements FormatacaoDecorator {
    private FormatacaoDecorator formatacao;

    public PadraoDecorator (FormatacaoDecorator formatacao) {
        this.formatacao = formatacao;
    }

    public void imprime(PrintWriter out, String texto) {
        this.formatacao.imprime(out, texto);
    }
}