package Simulado.Classes;
import Simulado.Interfaces.Pagamento;
public class PagamentoCartao implements Pagamento {
    private int parcelas;
    private double limite;

    public PagamentoCartao(int parcelas, double limite) {
        this.parcelas = parcelas;
        this.limite = limite;
    }

    @Override
    public double calcularValorFinal(double valor) {
        double valorFinal = (this.parcelas > 3) ? valor * 1.08 : valor;
        
        if (valorFinal > this.limite) {
            throw new PagamentoRecusadoException("Pagamento recusado: O valor excede o limite do cartão.");
        }
        return valorFinal;
    }

    @Override
    public String getDescricao() {
        return "Cartão em " + this.parcelas + "x";
    }
}