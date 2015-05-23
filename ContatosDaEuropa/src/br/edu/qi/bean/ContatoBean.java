package br.edu.qi.bean;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.ContatoDao;
import br.edu.qi.model.Contato;

@Stateless
@Local
public class ContatoBean{
	private static ContatoDao contatoDao = new ContatoDao();

	public void save(Contato contato) throws Exception {
		contatoDao.save(contato);
	}
	
	public List<Contato> findAll() throws Exception {
		return contatoDao.findAll();
	}
	
}
