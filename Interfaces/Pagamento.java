package Simulado.Interfaces;
public interface Pagamento{
	public double calcularValorFinal(double valor);
	public String getDescricao();
	default void exibirComprovante(double valor){
		System.out.println("Pago via"+getDescricao()+" : R$"+calcularValorFinal(valor));
	}
}