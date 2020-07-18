import java.io.PrintWriter;

public class FormatacaoPadrao implements Formatacao {
    public FormatacaoPadrao() {}

    public void imprime(PrintWriter out, String texto) {
        out.print(texto);
    }
}