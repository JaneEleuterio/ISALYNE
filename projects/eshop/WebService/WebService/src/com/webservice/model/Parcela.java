package com.webservice.model;

import java.util.Date;

public class Parcela {
	private int compra;
	private int parcela;
	private float valor;
	private Date data;
	private boolean finalizada;

	public Parcela (int compra, int parcela, float valor, Date data, boolean finalizada) {
		this.setCompra(compra);
		this.setParcela(parcela);
		this.setValor(valor);
		this.setData(data);
		this.setFinalizada(finalizada);
	}

	public int getCompra() {
		return compra;
	}
	private void setCompra(int compra) {
		this.compra = compra;
	}
	public int getParcela() {
		return parcela;
	}
	private void setParcela(int parcela) {
		this.parcela = parcela;
	}
	public float getValor() {
		return valor;
	}
	private void setValor(float valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	private void setData(Date data) {
		this.data = data;
	}
	public boolean isFinalizada() {
		return finalizada;
	}
	private void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
}
