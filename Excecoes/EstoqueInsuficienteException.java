package Simulado.Excecoes;
public class EstoqueInsuficienteException extends Exception {
    public EstoqueInsuficienteException(String nome, int disponivel) {
        super("Estoque insuficiente para " + nome + ". Disponível: " + disponivel);
    }
}