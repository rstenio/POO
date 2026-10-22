package Simulado.Classes;
import Simulado.Excecoes.*;
public class Pedido {
    private Cliente cliente;
    private CarrinhoDeCompras carrinho;

    public Pedido(Cliente cliente, CarrinhoDeCompras carrinho) {
        this.cliente = cliente;
        this.carrinho = carrinho;
    }

    public void finalizar(Pagamento pagamento) {
        try {
            double subtotal = this.carrinho.calcularTotal() + this.carrinho.calcularFreteTotal(this.cliente.getEndereco());

            if (this.cliente instanceof ClienteVip) {
                ClienteVip vip = (ClienteVip) this.cliente;
                subtotal -= subtotal * vip.getPercentualDesconto();
            }

            double valorFinal = pagamento.calcularValorFinal(subtotal);
            
            int pontos = (int) (valorFinal / 10);
            this.cliente.adicionarPontos(pontos);
            
            pagamento.exibirComprovante(subtotal);

        } catch (PagamentoRecusadoException e) {
            System.out.println("Pagamento recusado.");
        } finally {
            System.out.println("Pedido encerrado.\n");
        }
    }
}