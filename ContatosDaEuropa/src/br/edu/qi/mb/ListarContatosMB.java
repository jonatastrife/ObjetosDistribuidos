package br.edu.qi.mb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.edu.qi.bean.ContatoBean;
import br.edu.qi.model.Contato;

@ManagedBean(name="listaContato")
@SessionScoped
public class ListarContatosMB implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	ContatoBean bean;
	
	private ArrayList<Contato> contatos;
//	private static final ArrayList<Contato> contatos= new ArrayList<Contato>(Arrays.asList(
//			new Contato("Dionatan", "Dio", "shjds", "sdfs", "sjka", new Date())));;
	

	private Contato contatoSelecionado;
	
	public Contato getContatoSelecionado() {
		return contatoSelecionado;
	}

	public void setContatoSelecionado(Contato contatoSelecionado) {
		this.contatoSelecionado = contatoSelecionado;
	}

	public ArrayList<Contato> getContatos() {
		if (contatos == null) {
			try {
				contatos = bean.getContatos();
			} catch (Exception e) {
				contatos = new ArrayList<Contato>();
			}
		}
		return contatos;
	}

	public String deleteContato(Contato contato) {
		try {
			bean.delete(contato);
			contatos.remove(contato);
			MBUtils.buildMessage("mensagemAlerta", "Contato excluido!");
		} catch (Exception e) {
			MBUtils.buildMessage("mensagemAlerta", e.getMessage());
		}
		return null;
	}
	
	public String atualizarContato(Contato contato) {
		contato.setEditable(true);
		return null;
	}
	
	private transient DataModel<Contato> model;
	
	public DataModel<Contato> getModel() {
	    if (model == null) {
	    	try {
				model = new ListDataModel<Contato>(bean.getContatos());
			} catch (Exception e) {
				MBUtils.buildMessage("mensagemAlerta", e.getMessage());
			}
	    }
	    return model;
	}
	
	public String salvarAlteracoes(Contato contato) {
		getContatoSelecionado();
		FacesContext context = FacesContext.getCurrentInstance();
	    Contato outro = context.getApplication().evaluateExpressionGet(context, "#{contato}", Contato.class);
		Contato novo = model.getRowData();
		
		for (Contato c : contatos){
			if (c.isEditable()) {
				try {
					bean.update(c);
				} catch (Exception e) {
					MBUtils.buildMessage("mensagemAlerta", e.getMessage());
				}
				c.setEditable(false);
			}
		}
		contatos = null;
		return null;
	}	
	
}
