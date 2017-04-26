package com.webservice.model;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.sqlite.SQLiteDataSource;

public class Conector {
	static final String url = "/db/WebService.sqlite";
	
	public Connection getConnection() throws SQLException, IOException{
		String path = new File(".").getCanonicalPath();
		SQLiteDataSource dataSource = new SQLiteDataSource();
		dataSource.setUrl("jdbc:sqlite:" + path + url);
		return dataSource.getConnection();
	}	

}
