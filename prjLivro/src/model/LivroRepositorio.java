package model;

import java.util.ArrayList;

public class LivroRepositorio implements IRepositorio<Livro>{

	private ArrayList<Livro> livros;
	
	public LivroRepositorio() {
		livros = new ArrayList<Livro>();
	}
	
	@Override
	public void save(Livro l) throws Exception {
		livros.add(l);
		System.out.print("Salvou: "+l);
	}
	@Override
	public void delete(Livro l) throws Exception {
		for (Livro l1: livros){
			if (l1.getTitulo().equals(l.getTitulo())){
				livros.remove(l1);
			}
		}		
	}
	@Override
	public void update(Livro l) throws Exception {
		for (Livro l1: livros){
			if (l1.getTitulo().equals(l.getTitulo())){
				livros.set(livros.indexOf(l1), l);
			}
		}
	}
	@Override
	public Livro find(int i) throws Exception {		
		return livros.get(i);
	}
	@Override
	public ArrayList<Livro> findAll() throws Exception {
		return livros;
	}
	
	
}
