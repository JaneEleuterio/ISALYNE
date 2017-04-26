package com.webservice.model;

public class Resposta {
	int id;
	String mensagem;
	
	public Resposta (int id, String mensagem) {
		this.setId(id);
		this.setMensagem(mensagem);
	}	

	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public String getMensagem() {
		return mensagem;
	}
	private void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
