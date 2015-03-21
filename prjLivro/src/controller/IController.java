package controller;

import java.util.ArrayList;

public interface IController <T>{

	public void save(T t) throws Exception;
	public void delete(T t) throws Exception;
	public void update(T t) throws Exception;
	public T find(T t) throws Exception;
	public ArrayList<T> findAll() throws Exception;
}
