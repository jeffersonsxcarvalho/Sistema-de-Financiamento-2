package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Financiamento;
import model.FinanciamentoDeVeiculos;

public class FinanciamentoVeiculosService {
	
	private List<FinanciamentoDeVeiculos> listVeiculos;
	
	public FinanciamentoVeiculosService() {
		listVeiculos = new ArrayList<FinanciamentoDeVeiculos>();
	}
	
	public FinanciamentoDeVeiculos solicitarDadosFinanciamentoVeiculos(Cliente cliente, Scanner sc) {
		
		System.out.println("Digite o valor do veículo: ");
		double valorDoBem = sc.nextDouble();
		
		System.out.println("Digite o número de parcelas: ");
		int numeroDeParcelas = sc.nextInt();

		System.out.println("Digite o valor da entrada: ");
		double entrada = sc.nextDouble();
		
		FinanciamentoDeVeiculos financiamentoVeiculos = new FinanciamentoDeVeiculos(cliente, valorDoBem, numeroDeParcelas, entrada);
		
		try{
			validarVeiculo(cliente, financiamentoVeiculos);
	        listVeiculos.add(financiamentoVeiculos);
	        System.out.println(financiamentoVeiculos.toString());
	    } catch (IllegalArgumentException e) {
			System.out.println("Financiamento recusado! " + e.getMessage());
		}
	    return financiamentoVeiculos;
	}
	
	private void validarVeiculo(Cliente cliente, Financiamento financiamentoVeiculos) {
		
        if(cliente.getIdade() < 18) {
        	throw new IllegalArgumentException("Idade inválida. É necessário ter no mínimo 18 anos.");
        } 
        
        double valorParcela = financiamentoVeiculos.calcularValorParcela();
        double limite = cliente.getRendaMensal() * 0.20;
        if(valorParcela > limite) {
        	throw new IllegalArgumentException(String.format("Renda insuficiente. A parcela (R$ %.2f) excede 20%% da renda mensal (R$ %.2f).\n", valorParcela, limite));
        }
        
        if(financiamentoVeiculos.getNumeroDeParcelas() > 60) {
        	throw new IllegalArgumentException("Número de parcelas excede o limite máximo de 60 meses.");
        }
    }
	
	public List<FinanciamentoDeVeiculos> getListVeiculos(){
    	return listVeiculos;
    }

}
