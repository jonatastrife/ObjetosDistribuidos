package br.edu.qi.mb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MBUtils {
	
	public static void buildMessage(String idElementoNaTela, String mensagem) {
		FacesMessage facesMessage = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(idElementoNaTela, facesMessage);
	}
	
}
