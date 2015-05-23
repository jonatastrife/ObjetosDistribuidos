package br.edu.qi.dao;

import java.util.List;

public interface IDAO<T> {

	public void save(T obj) throws Exception;
	public void delete(T obj) throws Exception;
	public T find(T obj) throws Exception;
	public List<T> findAll() throws Exception;
	public void update (T obj) throws Exception;
}
