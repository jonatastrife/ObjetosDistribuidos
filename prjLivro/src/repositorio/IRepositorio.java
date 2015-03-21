package repositorio;

import java.util.ArrayList;

public interface IRepositorio <T> {
	
	public void save(T t) throws Exception;
	public void delete(T t) throws Exception;
	public void update(T t) throws Exception;
	public T find(int i) throws Exception;
	public ArrayList<T> findAll() throws Exception;

}
