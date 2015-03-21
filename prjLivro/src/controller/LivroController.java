package controller;

import java.util.ArrayList;

import model.Livro;
import model.LivroRepositorio;

public class LivroController implements IController<Livro> {

	private LivroRepositorio lr;
	
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
	public Livro find(Livro l) throws Exception {
		return lr.find(l);
	}

	@Override
	public ArrayList<Livro> findAll() throws Exception {
		return lr.findAll();
	}


	
}
