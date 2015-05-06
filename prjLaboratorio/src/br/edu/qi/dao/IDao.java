package br.edu.qi.dao;

import java.util.ArrayList;

public interface IDao<T> {

	public int save(T obj) throws Exception;
	public int delete(T obj) throws Exception;
	public T find(T obj) throws Exception;
	public ArrayList<T> findAll() throws Exception;
}
