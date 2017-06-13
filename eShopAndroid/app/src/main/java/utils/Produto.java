package utils;

public class Produto {
	private int id;
	private String nome;
	private float preco;
	private int quantidadeEstoque;
	private String descricao;
	
	
	public Produto(int id , String nome , float preco , int quantidadeEstoque ,String descricao){
		setId(id);
		setNome(nome);
		setPreco(preco);
		setQuantidadeEstoque(quantidadeEstoque);
		setDescricao(descricao);
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id >= 0)
			this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null)
			this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		if(preco >= 0.1)
			this.preco = preco;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		if(quantidadeEstoque > -1)
			this.quantidadeEstoque = quantidadeEstoque;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
