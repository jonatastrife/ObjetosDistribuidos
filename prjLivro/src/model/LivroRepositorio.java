package model;

import java.util.ArrayList;

public class LivroRepositorio implements IRepositorio<Livro>{

	private ArrayList<Livro> livros = new ArrayList<Livro>();
	
	@Override
	public void save(Livro T) throws Exception {
		// TODO Auto-generated method stub
		livros.add(T);
	}
	@Override
	public void delete(Livro T) throws Exception {
		for (Livro l: livros){
			if (l.getTitulo().equals(((Livro) T).getTitulo())){
				livros.remove(l);
			}
		}		
	}
	@Override
	public void update(Livro T) throws Exception {
		for (Livro l: livros){
			if (l.getTitulo().equals(((Livro) T).getTitulo())){
				livros.set(livros.indexOf(l), (Livro) T);
			}
		}
	}
	@Override
	public Livro find(Livro T) throws Exception {		
		for (Livro l: livros){
			if (l.getTitulo().equals(((Livro) T).getTitulo())){
				return (T);
			}
		}
		return null;
	}
	@Override
	public ArrayList<Livro> findAll() throws Exception {
		// TODO Auto-generated method stub
		return livros;
	}
	
	
}
