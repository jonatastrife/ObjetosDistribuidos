package br.edu.qi.mb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.qi.bean.ContatoBean;
import br.edu.qi.model.Contato;

@ManagedBean(name="listaContato")
@SessionScoped
public class ListarContatosMB implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	ContatoBean bean;
	
	private ArrayList<Contato> contatos;

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

	public void setContatos(ArrayList<Contato> contatos) {
		this.contatos = contatos;
	}

	public String deleteContato(Contato contato) {
		try {
			bean.delete(contato);
			contatos.remove(contato);
			this.buildMessage("mensagemAlerta", "Contato excluido!");
		} catch (Exception e) {
			this.buildMessage("mensagemAlerta", e.getMessage());
		}
		return null;
	}
	
	public String atualizarContato(Contato contato) {
		contato.setEditable(true);
		return null;
	}
	
	public String salvarAlteracoes() {
		for (Contato contato : contatos){
			if (contato.isEditable()) {
				try {
					bean.update(contato);
				} catch (Exception e) {
					this.buildMessage("mensagemAlerta", e.getMessage());
				}
				contato.setEditable(false);
			}
		}
		contatos = null;
		return null;
	}
	
	private void buildMessage(String idElementoNaTela, String mensagem) {
		FacesMessage facesMessage = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(idElementoNaTela,
				facesMessage);
	}
	
}
