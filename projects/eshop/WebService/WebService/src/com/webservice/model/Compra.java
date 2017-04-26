package com.webservice.model;

import java.util.Date;

public class Compra {
	private int id;
	private int cartao;
	private Date data;
	private float valor;
	private int parcelas;
	private boolean finalizada;
	
	public Compra(int id, int cartao, Date data, float valor, int parcelas, boolean finalizada){
		this.setId(id);
		this.setCartao(cartao);
		this.setData(data);
		this.setValor(valor);
		this.setParcelas(parcelas);
		this.setFinalizada(finalizada);
	}
	
	public Compra(int cartao, Date data, float valor, int parcelas){
		this.setCartao(cartao);
		this.setData(data);
		this.setValor(valor);
		this.setParcelas(parcelas);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCartao() {
		return cartao;
	}
	private void setCartao(int cartao) {
		this.cartao = cartao;
	}
	public Date getData() {		
		return data;
	}
	private void setData(Date data) {
		this.data = data;
	}
	public float getValor() {
		return valor;
	}
	private void setValor(float valor) {
		this.valor = valor;
	}
	public int getParcelas() {
		return parcelas;
	}
	private void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	public boolean isFinalizada() {
		return finalizada;
	}
	private void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	
	
}
