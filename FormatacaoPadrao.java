import java.io.PrintWriter;

public class FormatacaoPadrao implements FormatacaoDecorator {
    public void imprime(PrintWriter out, String texto) {
        out.print(texto);
    }
}