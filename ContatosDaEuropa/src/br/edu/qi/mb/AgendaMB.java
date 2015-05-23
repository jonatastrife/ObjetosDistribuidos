package br.edu.qi.mb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.qi.bean.AgendaBean;
import br.edu.qi.model.Contato;


@ManagedBean
@ViewScoped
public class AgendaMB implements Serializable{

	

	@EJB
	AgendaBean bean;
	
	private List<Contato> contatos;

	public void carregarContatos() {
	}
	

	
}
