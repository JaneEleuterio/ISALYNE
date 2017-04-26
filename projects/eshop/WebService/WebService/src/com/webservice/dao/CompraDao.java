package com.webservice.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import com.webservice.model.Compra;
import com.webservice.model.Conector;
import com.webservice.model.Parcela;

public class CompraDao implements GenericDao<Compra> {

	Connection connection;
	
	public CompraDao() throws SQLException, IOException {
		this.connection = new Conector().getConnection();
	}
	
	@Override
	public List<Compra> getAll() throws SQLException {
		
		List<Compra> compras = new ArrayList<Compra>();

		ResultSet executeQuery = connection.createStatement().executeQuery("select * from \"Compra\"");
		
		while(executeQuery.next()){
			compras.add(
				new Compra(
					executeQuery.getInt("id"),
					executeQuery.getInt("cartao"),
					executeQuery.getDate("data"),
					executeQuery.getFloat("valor"),
					executeQuery.getInt("parcelas"),
					executeQuery.getBoolean("finalizada")
				)						
			);
		}		
		
		return compras;
	}
	
	@Override
	public List<Compra> getAllByParam(HashMap<String, String> params) throws SQLException {
		
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

		List<Compra> compras = new ArrayList<Compra>();

		ResultSet executeQuery = connection.createStatement().executeQuery("select * from \"Compra\"" + parametros + ";");
		
		while(executeQuery.next()){
			compras.add(
				new Compra(
						executeQuery.getInt("id"),
						executeQuery.getInt("cartao"),
						executeQuery.getDate("data"),
						executeQuery.getFloat("valor"),
						executeQuery.getInt("parcelas"),
						executeQuery.getBoolean("finalizada")
				)						
			);
		}		
		
		return compras;
	}
	
	@Override
	public Compra insert(Compra compra) throws SQLException, IOException {
			
		Date dataCompra = compra.getData();

		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
		String data = DATE_FORMAT.format(dataCompra);
		
		int parcelas = compra.getParcelas();
		float valorCompra = compra.getValor();
		
		String sql = "INSERT INTO Compra (cartao, data, valor, parcelas) VALUES (" + 
				compra.getCartao() + ",'" +
				data + "'," +
				valorCompra + "," +
				parcelas + ");";
		
		PreparedStatement statement = connection.prepareStatement(sql, Statement.NO_GENERATED_KEYS);
		statement.execute();
		
		ResultSet chaveGerada = statement.getGeneratedKeys();
		
		if (chaveGerada.next()) {
			compra.setId(chaveGerada.getInt(1));
        }
		
		/// TODO
		if(parcelas > 1){
			float valorParcela = valorCompra / parcelas;
							
			for(int i=0; i<parcelas; i++){
				Calendar cal = new GregorianCalendar();
				cal.setTime(dataCompra);
				cal.add(Calendar.MONTH, i);
				
				Parcela parcela = new Parcela(
										compra.getId(),
										i+1,
										valorParcela,
										cal.getTime(),
										false
									);

				new ParcelaDao().insert(parcela);
			}
		}
		
		return compra;
	}

	@Override
	public Compra getByParam(HashMap<String, String> params) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}	
}
