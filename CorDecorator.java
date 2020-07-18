import java.io.PrintWriter;
import java.awt.Color;

public class CorDecorator extends FormatacaoDecorator {
  private Color cor;

  public CorDecorator (Formatacao formatacao, Color cor) {
    super(formatacao);
    this.cor =  cor;
  }

  public void imprime(PrintWriter out, String texto) {
    String span = String.format("<span style=\"color:rgb(%d, %d, %d)\">", cor.getRed(), cor.getGreen(), cor.getBlue());
    out.print(span);
    super.imprime(out, texto);
    out.print("</span>");
  }
}