package com.webservice.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.webservice.model.Cartao;
import com.webservice.model.Conector;

public class CartaoDao implements GenericDao<Cartao> {
	
	Connection connection;
	
	public CartaoDao() throws SQLException, IOException{
		this.connection = new Conector().getConnection();
	}
	
	@Override
	public List<Cartao> getAll() throws SQLException {
		
		List<Cartao> cartoes = new ArrayList<Cartao>();	
		
		ResultSet executeQuery = connection.createStatement().executeQuery("select * from \"Cartao\"");
		
		while (executeQuery.next()) {
			
			cartoes.add(
					new Cartao(
							executeQuery.getInt("id"),
							executeQuery.getString("numero"),
							executeQuery.getString("codigo"),
							executeQuery.getString("nome"),
							executeQuery.getString("validade"),
							executeQuery.getInt("bandeira"),
							executeQuery.getFloat("limite")
					)
			);
        }
		
		return cartoes;
	}
	
	@Override
	public List<Cartao> getAllByParam(HashMap<String, String> params) throws SQLException {
		
		String parametros = "";

		Set<Entry<String, String>> mapSet = params.entrySet();
        Iterator<Entry<String, String>> mapIterator = mapSet.iterator();
        while (mapIterator.hasNext()) {
        	Entry<String, String> mapEntry = mapIterator.next();
            String key = mapEntry.getKey();
            String value = mapEntry.getValue();
            
            if(parametros.isEmpty())
            	parametros += " where " + key + " = '" + value + "'";
            else            
            	parametros += " and " + key + " = '" + value + "'";
        }

		List<Cartao> cartoes = new ArrayList<Cartao>();	
			
		ResultSet executeQuery = connection.createStatement().executeQuery("select * from \"Cartao\"" + parametros + ";");
			
		while (executeQuery.next()) {
			
			cartoes.add(
					new Cartao(
							executeQuery.getInt("id"),
							executeQuery.getString("numero"),
							executeQuery.getString("codigo"),
							executeQuery.getString("nome"),
							executeQuery.getString("validade"),
							executeQuery.getInt("bandeira"),
							executeQuery.getFloat("limite")
					)
			);
        }
		
		return cartoes;
	}
	
	public float getLimiteDisponivel(int cartaoId) throws SQLException {
		
		String sql = 
				"SELECT Card.id, " +
				"Card.limite - (CASE WHEN Comp.parcelas > 1 THEN SUM(Parc.valor) WHEN Comp.parcelas = 1 THEN SUM(Comp.valor) ELSE 0 END) as valor " +
				"FROM Cartao Card LEFT JOIN Compra Comp ON Comp.cartao = Card.id AND Comp.finalizada = 0 " +
				"LEFT JOIN Parcela Parc ON Parc.compra = Comp.id AND Parc.finalizada = 0 " +
				"WHERE Card.id = " + cartaoId + " " +
				"GROUP BY Card.id;";
		
		float valor = 0;
		
		ResultSet executeQuery = connection.createStatement().executeQuery(sql);
		
		while (executeQuery.next()) {
			valor += executeQuery.getFloat("valor");
		}
		
		return valor;
	}

	@Override
	public Cartao getByParam(HashMap<String, String> params) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cartao insert(Cartao object) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
