package com.webservice.model;

public class Cartao {
	private int id;
	private String numero;
	private String codigo;	
	private String nome;
	private String validade;
	private int bandeira;
	private float limite;
	
	public Cartao(int id, String numero, String codigo, 
			String nome, String validade, int bandeira, float limite){
		this.setId(id);
		this.setNumero(numero);
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setValidade(validade);
		this.setBandeira(bandeira);
		this.setLimite(limite);
	}
	

	public int getId() {
		return this.id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	private void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCodigo() {
		return codigo;
	}
	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return this.nome;
	}
	private void setNome(String nome) {
		this.nome = nome;
	}
	public String getValidade() {
		return validade;
	}
	private void setValidade(String validade) {
		this.validade = validade;
	}
	public int getBandeira() {
		return bandeira;
	}
	private void setBandeira(int bandeira) {
		this.bandeira = bandeira;
	}
	public float getLimite() {
		return limite;
	}
	private void setLimite(float limite) {
		this.limite = limite;
	}	
}
