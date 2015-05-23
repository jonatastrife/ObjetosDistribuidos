package br.edu.qi.dao;

import java.util.ArrayList;

public interface IDAO<T> {

	public void save(T obj) throws Exception;
	public void delete(T obj) throws Exception;
	public T find(T obj) throws Exception;
	public ArrayList<T> findAll() throws Exception;
	public void update (T obj) throws Exception;
}
