import java.io.PrintWriter;

public abstract class FormatacaoDecorator implements Formatacao {
    private Formatacao formatacao;

    public FormatacaoDecorator (Formatacao formatacao) {
        this.formatacao = formatacao;
    }

    public void imprime(PrintWriter out, String texto) {
        this.formatacao.imprime(out, texto);
    }
}