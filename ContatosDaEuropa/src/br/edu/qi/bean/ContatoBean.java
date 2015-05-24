package br.edu.qi.bean;

import java.util.ArrayList;

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
	
	public ArrayList<Contato> getContatos() throws Exception {		
		return contatoDao.findAll();
	}

	public void delete(Contato c) throws Exception {
		// TODO Auto-generated method stub
		contatoDao.delete(c);
	}
}
