package br.edu.qi.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.ContatoDao;
import br.edu.qi.model.Contato;

@Stateless
@Local
public class ContatoBean{

	public void save(Contato contato) throws Exception {
		new ContatoDao().save(contato);
	}
}
