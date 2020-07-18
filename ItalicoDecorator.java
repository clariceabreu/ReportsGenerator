import java.io.PrintWriter;

public class ItalicoDecorator extends FormatacaoDecorator {
    public ItalicoDecorator (Formatacao formatacao) {
        super(formatacao);
    }

    public void imprime(PrintWriter out, String texto) {
        out.print("<span style=\"font-style:italic\">");
        super.imprime(out, texto);
        out.print("</span>");
    }
}