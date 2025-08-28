package model;

public abstract class Financiamento {

    protected Cliente cliente;
    protected double valorDoBem;
    protected int numeroDeParcelas;
    protected double entrada;
    protected String status;

    public Financiamento(Cliente cliente, double valorDoBem, int numeroDeParcelas, double entrada) {
        this.cliente = cliente;
        this.valorDoBem = valorDoBem;
        this.numeroDeParcelas = numeroDeParcelas;
        this.entrada = entrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorDoBem() {
        return valorDoBem;
    }

    public void setValorDoBem(double valorDoBem) {
        this.valorDoBem = valorDoBem;
    }

    public int getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(int numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public abstract double calcularValorParcela();

    @Override
    public String toString() {
        return String.format("Financiamento para %s, Valor Total: R$ %.2f, Número de Parcelas: %d",
                cliente.getNome(), valorDoBem, numeroDeParcelas);
    }


}

