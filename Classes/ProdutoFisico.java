package Simulado.Classes;
import Simulado.Interfaces.Entregavel;
public class ProdutoFisico extends Produto implements Entregavel {
    private double pesokg;

    public ProdutoFisico(String codigo, String nome, double precoBase, int estoque, double pesokg) {
        super(codigo, nome, precoBase, estoque);
        this.pesokg = pesokg;
    }

    public double getPesokg() { return pesokg; }

    @Override
    public double calcularPrecoFinal() {
        return getPrecoBase() * 1.10;
    }

    @Override
    public double calcularFrete(String cep) {
        return 15.00 + (2.00 * getPesokg());
    }

    @Override
    public int prazoEntregaDias() {
        // Nota: O método sugerido pelo enunciado não recebe o parâmetro 'cep'
        // Assumi 12 como padrão devido a essa limitação da assinatura na interface.
        return 12; 
    }
}