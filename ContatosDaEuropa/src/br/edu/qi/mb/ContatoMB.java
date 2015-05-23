package br.edu.qi.mb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.qi.bean.ContatoBean;


@ManagedBean
@ViewScoped
public class ContatoMB implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	ContatoBean bean;
	
	private String nome;
	private String apelido;
	private String email;
	private String telephone;
	private String celular;
	private String dt_nasc;
	
	private String mensagemAlerta;

	public void save() {
		this.setMensagemAlerta("");
		
		try {
			this.validation();
			
			
			
		} catch (Exception e) {
			this.buildMessage("mensagemAlerta", e.getMessage());
		}
	}
	
	private void validation() throws Exception{
		
		if (this.getNome().trim().isEmpty()) {
			throw new Exception("Nome n�o deve ficar em branco!");
		}
		if (this.getApelido().trim().isEmpty()) {
			throw new Exception("Apelido n�o deve ficar em branco!");
		}
		if (this.getEmail().trim().isEmpty()) {
			throw new Exception("Email n�o deve ficar em branco!");
		}
		if (this.getTelephone().trim().isEmpty()) {
			throw new Exception("Telefone n�o deve ficar em branco!");
		}
		if (this.getCelular().trim().isEmpty()) {
			throw new Exception("Celular n�o deve ficar em branco!");
		}
		if (this.getDt_nasc().trim().isEmpty()) {
			throw new Exception("Data de nascimento n�o deve ficar em branco!");
		}
		
		if (!isNumeric(this.getTelephone().trim())) {
			throw new Exception("Telefone deve ser num�rico!");
		}
		if (!isNumeric(this.getCelular().trim())) {
			throw new Exception("Celular deve ser num�rico!");
		}
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(String dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public String getMensagemAlerta() {
		return mensagemAlerta;
	}

	public void setMensagemAlerta(String mensagemAlerta) {
		this.mensagemAlerta = mensagemAlerta;
	}

	private boolean isNumeric(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void buildMessage(String idElementoNaTela, String mensagem) {
		FacesMessage facesMessage = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(idElementoNaTela,
				facesMessage);
	}
	
}