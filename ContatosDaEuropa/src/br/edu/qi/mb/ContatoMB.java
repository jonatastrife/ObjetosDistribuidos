package br.edu.qi.mb;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.qi.bean.ContatoBean;
import br.edu.qi.model.Contato;


@ManagedBean(name="ContatoMB",eager=true)
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
	private Date dt_nasc;
	
	private String mensagemAlerta;

	public String save() {
		this.setMensagemAlerta("");
		
		try {
			this.validation();
			
			Contato contato = new Contato();
			contato.setNome(this.getNome());
			contato.setApelido(this.getApelido());
			contato.setEmail(this.getEmail());
			contato.setTelephone(this.getTelephone());
			contato.setCelular(this.getCelular());
			contato.setDt_nasc(this.getDt_nasc());
			
			bean.save(contato);
			MBUtils.redirecionarPara(Urls.URL + Urls.CONTATOS);			
		} catch (Exception e) {
			MBUtils.buildMessage("mensagemAlerta", e.getMessage());
		}
		return null;
	}
	
	private void validation() throws Exception{
		
		if (this.getNome().trim().isEmpty()) {
			throw new Exception("Nome não deve ficar em branco!");
		}
		if (this.getApelido().trim().isEmpty()) {
			throw new Exception("Apelido não deve ficar em branco!");
		}
		if (this.getEmail().trim().isEmpty()) {
			throw new Exception("Email não deve ficar em branco!");
		}
		if (this.getTelephone().trim().isEmpty()) {
			throw new Exception("Telefone não deve ficar em branco!");
		}
		if (this.getCelular().trim().isEmpty()) {
			throw new Exception("Celular não deve ficar em branco!");
		}
		if (this.getDt_nasc() == null) {
			throw new Exception("Data de nascimento não deve ficar em branco!");
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

	public Date getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public String getMensagemAlerta() {
		return mensagemAlerta;
	}

	public void setMensagemAlerta(String mensagemAlerta) {
		this.mensagemAlerta = mensagemAlerta;
	}
	
}
