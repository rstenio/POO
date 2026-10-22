package Simualado.Excecoes;
public class PagamentoRecusadoException extends RuntimeException {
    public PagamentoRecusadoException(String mensagem) {
        super(mensagem);
    }
}