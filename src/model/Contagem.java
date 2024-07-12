package model;

public class Contagem {
	
	private Estoque estoque;
	protected String nome;
	protected int quantidade;
	
	public Contagem() {
	}
	
	public Contagem(String nome, int quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return getNome() + "," + getQuantidade();
	}

	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}

