package Simulado.Classes;

public class Assinatura extends Produto {
    private int meses;

    public Assinatura(String codigo, String nome, double precoBase, int estoque, int meses) {
        super(codigo, nome, precoBase, estoque);
        this.meses = meses;
    }

    @Override
    public double calcularPrecoFinal() {
        double total = getPrecoBase() * this.meses;
        if (this.meses >= 6) {
            return total * 0.90;
        }
        return total;
    }
}