package com.webservice.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.webservice.model.Bandeira;
import com.webservice.model.Conector;

public class BandeiraDao implements GenericDao<Bandeira>{
	
	Connection connection;
	
	public BandeiraDao() throws SQLException, IOException{
		this.connection = new Conector().getConnection();
	}
	
	public List<Bandeira> getAll() throws SQLException {
		
		List<Bandeira> bandeiras = new ArrayList<Bandeira>();	
		
		ResultSet executeQuery = connection.createStatement().executeQuery("select * from \"Bandeira\"");
		
		while (executeQuery.next()) {
			bandeiras.add(
				new Bandeira(
					executeQuery.getInt("id"), 
					executeQuery.getString("nome")
				)
			);
        }
		
		return bandeiras;
	}

	@Override
	public List<Bandeira> getAllByParam(HashMap<String, String> params) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bandeira getByParam(HashMap<String, String> params) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bandeira insert(Bandeira object) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
