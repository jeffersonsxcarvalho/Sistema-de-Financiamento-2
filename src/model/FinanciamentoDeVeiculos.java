package model;

public class FinanciamentoDeVeiculos extends Financiamento{

	public FinanciamentoDeVeiculos(Cliente cliente, double valorDoBem, int numeroDeParcelas, double entrada) {
		super(cliente, valorDoBem, numeroDeParcelas, entrada);
	}

	public double calcularValorDoFinanciamento() {
		return valorDoBem - getEntrada();
	}

	@Override
	public double calcularValorParcela() {
	    double taxaJuros = 0.015; 
	    double fator = 1 - Math.pow(1 + taxaJuros, -numeroDeParcelas);
	    return calcularValorDoFinanciamento() * taxaJuros / fator;
	}


	@Override
	public String toString() {
		return String.format("Financiamento aprovado!\nEntrada miníma: R$ %.2f\n"
				+ "Valor Financiado: R$ %.2f\nNúmero de parcelas: %d\n"
				+ "Valor da parcela: R$ %.2f", calcularEntradaMinima(), calcularValorDoFinanciamento(), 
				numeroDeParcelas, calcularValorParcela());
	}
	
	
}
