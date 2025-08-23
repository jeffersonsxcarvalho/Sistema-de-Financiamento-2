package model;

import java.util.Locale;
import java.util.Scanner;

import service.ClienteService;
import service.FinanciamentoVeiculosService;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		ClienteService clienteService = new ClienteService();
		FinanciamentoVeiculosService financiamentoVeiculosService = new FinanciamentoVeiculosService();
		
		int opcao;
		do {
			System.out.println("===MENU PRINCIPAL===");
			System.out.println("1 - Financiamento de imóvel");
			System.out.println("2 - Financiamento de veículo");
			System.out.println("3 - Listar Financiamentos de Imóveis");
			System.out.println("4 - Listar Financiamentos de Veículos");
			System.out.println("0 - Sair");
			
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch(opcao) {
			
			case 1:
				
				
			case 2:
				Cliente cliente = clienteService.solicitarDadosDosClientes(sc);
				FinanciamentoDeVeiculos financiamentoVeiculo = financiamentoVeiculosService.solicitarDadosFinanciamentoVeiculos(cliente, sc);
				break;
				
			case 3: 
				
			case 4:
				
			case 0:
				System.out.println("Saindo..");
				
			default:
				throw new IllegalArgumentException("Opção inválida.");
				
			}
			
		} while(opcao != 0);

	}

}
