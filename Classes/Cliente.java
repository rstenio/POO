package Simulado.Classes;

public class Cliente extends Pessoa {
    private String endereco;
    private int pontosFidelidade;

    public Cliente(String nome, String cpf, String email, String endereco) {
        super(nome, cpf, email);
        this.endereco = endereco;
        this.pontosFidelidade = 0;
    }

    public String getEndereco() { return endereco; }
    public int getPontosFidelidade() { return pontosFidelidade; }

    public void adicionarPontos(int pontos) {
        this.pontosFidelidade += pontos;
    }
}