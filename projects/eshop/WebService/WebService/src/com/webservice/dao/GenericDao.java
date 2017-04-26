package com.webservice.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface GenericDao<T> {
	public abstract List<T> getAll() throws SQLException;
	public abstract List<T> getAllByParam(HashMap<String, String> params) throws SQLException;
	public abstract T getByParam(HashMap<String, String> params) throws SQLException;
	public abstract T insert(T object) throws SQLException, IOException;
}
