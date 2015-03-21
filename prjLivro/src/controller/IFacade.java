package controller;

import java.util.ArrayList;

public interface IFacade <T>{

	public void save(Object T) throws Exception;
	public void delete(Object T) throws Exception;
	public void update(Object T) throws Exception;
	public T find(Object T) throws Exception;
	public ArrayList<T> findAll() throws Exception;
}
