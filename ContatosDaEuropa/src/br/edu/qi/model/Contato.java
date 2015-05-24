package br.edu.qi.model;

import java.util.Date;

public class Contato {

	private String nome;
	private String apelido;

	private String email;
	private String telephone;
	private String celular;
	private Date dt_nasc;

	boolean editable;

	public Contato(String nome, String apelido, String email, String telephone,
			String celular, Date dt_nasc) {
		this.nome = nome;
		this.apelido = apelido;
		this.email = email;
		this.telephone = telephone;
		this.celular = celular;
		this.dt_nasc = dt_nasc;
	}

	public Contato() {
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

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

}
