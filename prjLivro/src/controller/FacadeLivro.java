package controller;

import java.util.ArrayList;

import model.Livro;


public class FacadeLivro implements IFacade <Livro>{

	public LivroController lc;
	
	public FacadeLivro(){
		lc = new LivroController();
	}
	@Override
	public void save(Livro l) throws Exception {
		lc.save(l);
	}

	@Override
	public void delete(Livro l) throws Exception {
		lc.delete(l);
	}

	@Override
	public void update(Livro l) throws Exception {
		lc.update(l);
	}

	@Override
	public Livro find(int i) throws Exception {
		return (Livro) lc.find(i);
	}

	@Override
	public ArrayList<Livro> findAll() throws Exception {
		return lc.findAll();
	}

}
