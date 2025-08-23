package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Financiamento;
import model.FinanciamentoDeVeiculos;

public class ClienteService {
	
	private List<Cliente> list;
	
	
	public ClienteService() {
		list = new ArrayList<Cliente>();
	}
	
	public Cliente solicitarDadosDosClientes(Scanner sc) {
		System.out.println("Digite seu nome: ");
		String nome = sc.nextLine();
		
		System.out.println("Digite sua idade: ");
		int idade = sc.nextInt();
		
		System.out.println("Digite sua renda mensal: ");
		double rendaMensal = sc.nextDouble();
		
		
		Cliente cliente = new Cliente(nome, idade, rendaMensal);
		list.add(cliente);
		return cliente;
	}
	
	

}
