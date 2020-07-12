import java.io.PrintWriter;

public class NegritoDecorator extends PadraoDecorator {
    public NegritoDecorator (FormatacaoDecorator formatacao) {
        super(formatacao);
    }

    public void imprime(PrintWriter out, String texto) {
        out.print("<span style=\"font-weight:bold\">");
        super.imprime(out, texto);
        out.print("</span>");
    }
}