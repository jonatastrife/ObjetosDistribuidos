package br.edu.qi.bean;

import br.edu.qi.dao.ContatoDao;
import br.edu.qi.model.Contato;



public class ContatoBean{

	public void save(Contato contato) throws Exception {
		new ContatoDao().save(contato);
	}
}
