package Simulado.Main;
import Simulado.Excecoes.*;
public class Main {
    public static void main(String[] args) {
        // Cenário: Instanciando as entidades
        ClienteVip clienteVip = new ClienteVip("Justin Mason", "123456789", "justin@mail.com", "60000-000", 0.10);
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        try {
            ProdutoFisico pFisico = new ProdutoFisico("F01", "Smartphone", 1000.0, 5, 0.5);
            ProdutoDigital pDigital = new ProdutoDigital("D01", "Licença Antivírus", 100.0, 99, 50);
            Assinatura assinatura = new Assinatura("A01", "Garantia Estendida", 50.0, 99, 12);

            carrinho.adicionar(pFisico);
            carrinho.adicionar(pDigital);
            carrinho.adicionar(assinatura);
            
        } catch (EstoqueInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        Pedido pedido = new Pedido(clienteVip, carrinho);

        // 1ª Tentativa: Sucesso com PIX
        System.out.println("--- Tentativa 1 (PIX) ---");
        Pagamento pagamentoPix = new PagamentoPix();
        pedido.finalizar(pagamentoPix);
        
        System.out.println("Pontos do Cliente: " + clienteVip.getPontosFidelidade());

        // 2ª Tentativa: Forçando erro com limite baixo no Cartão
        System.out.println("\n--- Tentativa 2 (Cartão Sem Limite) ---");
        Pagamento pagamentoCartao = new PagamentoCartao(6, 100.0); // Limite baixo!
        pedido.finalizar(pagamentoCartao);
    }
}