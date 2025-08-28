package model;

public class FinanciamentoDeVeiculos extends Financiamento{

    public FinanciamentoDeVeiculos(Cliente cliente, double valorDoBem, int numeroDeParcelas, double entrada) {
        super(cliente, valorDoBem, numeroDeParcelas, entrada);
    }

    public double calcularValorDoFinanciamento() {
        return getValorDoBem() - getEntrada();
    }

    public double calcularEntradaMinima() {
        return getValorDoBem() * 0.10;
    }

    @Override
    public double calcularValorParcela() {
        double taxaJuros = 0.0115;
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

    public String toStringListagem() {
        return String.format("Status: %s | Nome: %s | Idade: %d | Renda Mensal: R$ %.2f | Valor Financiamento: R$ %.2f | Número de parcelas: %d | Entrada: R$ %.2f | Valor da parcela: R$ %.2f\n",
                this.status, cliente.getNome(), cliente.getIdade(), cliente.getRendaMensal(), calcularValorDoFinanciamento(), getNumeroDeParcelas(), getEntrada(), calcularValorParcela());
    }


}
