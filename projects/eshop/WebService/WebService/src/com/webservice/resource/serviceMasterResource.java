package com.webservice.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.webservice.dao.CartaoDao;
import com.webservice.dao.CompraDao;
import com.webservice.model.Cartao;
import com.webservice.model.Compra;
import com.webservice.model.Resposta;

@Path("/master")
public class serviceMasterResource {	
	
	@GET
	@Path("/disponibilidade")
	@Produces("application/json")
	public Resposta getDisponibilidade() {
		return new Resposta(0, "OK");
	}
	
	@POST
	@Path("/registraCompra")
	@Produces("application/json")
	public Resposta registraCompra(@Context HttpHeaders info) {		
		String numero = info.getRequestHeaders().getFirst("numero");
		String codigo = info.getRequestHeaders().getFirst("codigo");
		String nome = info.getRequestHeaders().getFirst("nome");
		String validade = info.getRequestHeaders().getFirst("validade");
		
		float valorCompra = 0;
		int parcelas = 0;
		Date dataCompra = new Date();
		
		try {
			valorCompra = Float.parseFloat(info.getRequestHeaders().getFirst("valor"));
			parcelas = Integer.parseInt(info.getRequestHeaders().getFirst("parcelas"));
		} catch(Exception ex) {
			return new Resposta(7, "Dados inválidos");
		}
		
		HashMap<String,String> params = new HashMap<String, String>();
		params.put("numero", numero);
		params.put("codigo", codigo);
		params.put("nome", nome);
		params.put("validade", validade);
		
		List<Cartao> cartoes = new ArrayList<Cartao>();
		
		try {
			cartoes = new CartaoDao().getAllByParam(params);
		} catch (Exception ex) {
			return new Resposta(2, "Erro ao buscar o cartão");
		}
		
		if(cartoes.size() == 0) {
			return new Resposta(3, "Cartão Inválido");
		} else {
			Cartao cartao = cartoes.get(0);
			
			float limiteDisponivel = 0;
			try {
				limiteDisponivel = new CartaoDao().getLimiteDisponivel(cartao.getId());
			} catch (Exception ex) {
				return new Resposta(4, "Erro ao consultar o saldo");
			}
			
			if (valorCompra > cartao.getLimite() || valorCompra > limiteDisponivel) {
				return new Resposta(5, "Limite Excedido");
			} else {			
				Compra compra = new Compra(cartao.getId(), dataCompra, valorCompra, parcelas);
				try {
					compra = new CompraDao().insert(compra);
				} catch(Exception ex){
					new Resposta(6, "Erro ao registrar compra");
				}
				return new Resposta(1, "Compra Registrada - Código: " + cartao.getId());
			}
		}
	}
}