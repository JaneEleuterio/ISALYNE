package com.webservice.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import com.webservice.model.Conector;
import com.webservice.model.Parcela;

public class ParcelaDao implements GenericDao<Parcela> {
	Connection connection;
	
	public ParcelaDao() throws SQLException, IOException {
		connection = new Conector().getConnection();
	}

	@Override
	public List<Parcela> getAll() throws SQLException {
		
		List<Parcela> parcelas = new ArrayList<Parcela>();

		ResultSet executeQuery = connection.createStatement().executeQuery("select * from \"Parcela\"");
		
		while(executeQuery.next()) {
			parcelas.add(
				new Parcela(
					executeQuery.getInt("cartao"),
					executeQuery.getInt("parcela"),
					executeQuery.getFloat("valor"),
					executeQuery.getDate("data"),
					executeQuery.getBoolean("finalizada")
				)
			);
		}		
		
		return parcelas;
	}

	@Override
	public List<Parcela> getAllByParam(HashMap<String, String> params) throws SQLException {
		
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
        
        List<Parcela> parcelas = new ArrayList<Parcela>();

		ResultSet executeQuery = connection.createStatement().executeQuery("select * from \"Parcela\"" + parametros + ";");
		
		while(executeQuery.next()) {
			parcelas.add(
				new Parcela(
					executeQuery.getInt("compra"),
					executeQuery.getInt("parcela"),
					executeQuery.getFloat("valor"),
					executeQuery.getDate("data"),
					executeQuery.getBoolean("finalizada")
				)
			);
		}		
		
		return parcelas;
	}

	@Override
	public Parcela getByParam(HashMap<String, String> params) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parcela insert(Parcela object) throws SQLException {
		
		Date dataParcela = object.getData();

		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
		String data = DATE_FORMAT.format(dataParcela);
		
		String sql = "INSERT INTO Parcela (compra, parcela, valor, data) VALUES("+
				object.getCompra() + "," +
				object.getParcela() + "," +
				object.getValor() + ",'" +
				data + "');";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
		
		return object;
	}

}
