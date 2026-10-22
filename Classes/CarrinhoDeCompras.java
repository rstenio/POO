package Simulado.Classes;
import Simulado.Excecoes.*;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Produto> itens = new ArrayList<>();

    public void adicionar(Produto p) throws EstoqueInsuficienteException {
        adicionar(p, 1);
    }

    public void adicionar(Produto p, int quantidade) throws EstoqueInsuficienteException {
        if (quantidade > p.getEstoque()) {
            throw new EstoqueInsuficienteException(p.getNome(), p.getEstoque());
        }
        for (int i = 0; i < quantidade; i++) {
            this.itens.add(p);
        }
        p.baixarEstoque(quantidade);
    }

    public double calcularTotal() {
        double soma = 0;
        for (Produto p : this.itens) {
            soma += p.calcularPrecoFinal();
        }
        return soma;
    }

    public double calcularFreteTotal(String cep) {
        double frete = 0;
        for (Produto p : this.itens) {
            if (p instanceof Entregavel) {
                frete += ((Entregavel) p).calcularFrete(cep);
            }
        }
        return frete;
    }
    
    public List<Produto> getItens() { return itens; }
}