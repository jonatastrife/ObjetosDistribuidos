package br.edu.qi.mb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.qi.bean.ContatoBean;
import br.edu.qi.model.Contato;

@ManagedBean(name = "listaContato")
@SessionScoped
public class ListarContatosMB implements Serializable {

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

	public String salvarAlteracoes(Contato contato) {
		try {
			bean.update(contato);
		} catch (Exception e) {
			MBUtils.buildMessage("mensagemAlerta", e.getMessage());
		}
		contatos = null;
		return null;
	}

}
