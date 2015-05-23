package br.edu.qi.bean;

import java.util.ArrayList;

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
	
	public ArrayList<Contato> getContatos() throws Exception
	{		
		return new ContatoDao().findAll();
	}
}
