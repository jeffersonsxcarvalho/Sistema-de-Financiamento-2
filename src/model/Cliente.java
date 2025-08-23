package model;

public class Cliente {

	private String nome;
	private int idade;
	private double rendaMensal;
	
	
	public Cliente(String nome, int idade, double rendaMensal) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.rendaMensal = rendaMensal;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		if(nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome de preenchimento obrigatório.");
		} else {
			this.nome = nome;
		}
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		if(idade < 0) {
			throw new IllegalArgumentException("Idade deve ser um valor positivo.");
		} else {
			this.idade = idade;
		}
	}


	public double getRendaMensal() {
		return rendaMensal;
	}


	public void setRendaMensal(double rendaMensal) {
		if(rendaMensal <= 0) {
			throw new IllegalArgumentException("Renda mensal deve ser um valor positivo.");
		} else {
			this.rendaMensal = rendaMensal;
		}
	}


	@Override
	public String toString() {
		return String.format("Cliente nome:  %s, idade:  %d, renda mensal R$ %.2f", nome, idade, rendaMensal);
	}

	
}
