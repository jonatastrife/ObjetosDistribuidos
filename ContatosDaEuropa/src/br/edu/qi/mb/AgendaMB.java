package br.edu.qi.mb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.qi.bean.AgendaBean;


@ManagedBean
@ViewScoped
public class AgendaMB implements Serializable{

	

	@EJB
	AgendaBean bean;
	
	private List<Contato> contatos;
	private int ;

	public void carregarContatos() {
	}
	

	
}
