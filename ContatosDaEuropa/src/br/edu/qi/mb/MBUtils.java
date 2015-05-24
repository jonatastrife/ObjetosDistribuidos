package br.edu.qi.mb;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class MBUtils {

	public static void buildMessage(String idElementoNaTela, String mensagem) {
		FacesMessage facesMessage = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(idElementoNaTela,
				facesMessage);
	}

	public static ExternalContext getContexto() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	public static void setAttribute(String nome, Object valor) {
		getContexto().getSessionMap().put(nome, valor);
	}

	public static Object getAttribute(String nome) {
		return getContexto().getSessionMap().get(nome);
	}
}
