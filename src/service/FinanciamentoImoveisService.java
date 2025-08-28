package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Financiamento;
import model.FinanciamentoDeImoveis;
import model.FinanciamentoDeVeiculos;



public class FinanciamentoImoveisService {

    private List<FinanciamentoDeImoveis> listImoveis;

    public FinanciamentoImoveisService() {
        listImoveis = new ArrayList<FinanciamentoDeImoveis>();
    }

    public FinanciamentoDeImoveis solicitarDadosFinanciamentoImoveis(Cliente cliente, Scanner sc) {

        System.out.println("Digite o valor do imóvel: ");
        double valorDoBem = sc.nextDouble();

        System.out.println("Digite o número de parcelas: ");
        int numeroDeParcelas = sc.nextInt();

        System.out.println("Digite o valor da entrada: ");
        double entrada = sc.nextDouble();

        FinanciamentoDeImoveis financiamentoImoveis = new FinanciamentoDeImoveis(cliente, valorDoBem, numeroDeParcelas, entrada);

        try{
            validarImoveis(cliente, financiamentoImoveis);
            financiamentoImoveis.setStatus("Aprovado");
            listImoveis.add(financiamentoImoveis);
            System.out.println(financiamentoImoveis.toString());
        } catch (IllegalArgumentException e) {
            financiamentoImoveis.setStatus("Reprovado");
            listImoveis.add(financiamentoImoveis);
            System.out.println("Financiamento recusado! " + e.getMessage());
        }
        return financiamentoImoveis;
    }

    private void validarImoveis(Cliente cliente, Financiamento financiamentoImoveis) {

        if(cliente.getIdade() < 21) {
            throw new IllegalArgumentException("Idade inválida. É necessário ter no mínimo 21 anos.");
        }

        double entradaMinima = ((FinanciamentoDeImoveis) financiamentoImoveis).calcularEntradaMinima();
        if(financiamentoImoveis.getEntrada() < entradaMinima) {
            throw new IllegalArgumentException(String.format(
                    "Entrada insuficiente. A entrada mínima exigida é R$ %.2f.", entradaMinima));
        }

        double valorParcela = financiamentoImoveis.calcularValorParcela();
        double limite = cliente.getRendaMensal() * 0.30;
        if(valorParcela > limite) {
            throw new IllegalArgumentException(String.format("Renda insuficiente. A parcela (R$ %.2f) excede 30%% da renda mensal (R$ %.2f).\n", valorParcela, limite));
        }

        if(financiamentoImoveis.getNumeroDeParcelas() > 360) {
            throw new IllegalArgumentException("Número de parcelas excede o limite máximo de 360 meses.");
        }
    }

    public List<FinanciamentoDeImoveis> getListImoveis(){
        return listImoveis;
    }

}

