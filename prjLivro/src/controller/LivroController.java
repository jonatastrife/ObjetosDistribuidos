package controller;

import java.util.ArrayList;

import repositorio.LivroRepositorio;
import model.Livro;

public class LivroController implements IController<Livro> {

	private LivroRepositorio lr;
	
	public LivroController() {
		lr = new LivroRepositorio();
	}
	
	@Override
	public void save(Livro l) throws Exception {
		lr.save(l);		
	}

	@Override
	public void delete(Livro l) throws Exception {
		lr.delete(l);
	}

	@Override
	public void update(Livro l) throws Exception {
		lr.update(l);
	}

	@Override
	public Livro find(int i) throws Exception {
		return lr.find(i);
	}

	@Override
	public ArrayList<Livro> findAll() throws Exception {
		return lr.findAll();
	}


	
}
