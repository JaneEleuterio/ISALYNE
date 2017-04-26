package com.webservice.model;

public class Bandeira {
	int id;
	String nome;
	
	public Bandeira(int id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

}
