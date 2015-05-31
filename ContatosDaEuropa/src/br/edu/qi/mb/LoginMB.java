package br.edu.qi.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.qi.bean.LoginBean;
import br.edu.qi.model.Login;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	LoginBean bean;

	private String username;
	private String password;

	private String mensagemAlerta;

	public String getUsuarioValido() throws Exception {
		this.validaLogin();
		return null;
	}

	public void executeLogin() {
		this.setMensagemAlerta("");

		try {
			this.validation();

			Login login = new Login(this.getUsername(), this.getPassword());

			if (bean.verificaLogin(login)) {
				MBUtils.redirecionarPara(Urls.URL + Urls.CONTATOS);
			} else {
				MBUtils.buildMessage("mensagemAlerta",
						"Usuário não encontrado!");
			}
		} catch (Exception e) {
			MBUtils.buildMessage("mensagemAlerta", e.getMessage());
		}
	}
	
	public void validaLogin() throws Exception{
		if (bean.getUsuarioLogado() == null) {
			MBUtils.redirecionarPara(Urls.URL + Urls.LOGIN);
		}
	}

	public void deslogarUsuario() throws IOException {
		MBUtils.encerrarSessao();
		MBUtils.redirecionarPara(Urls.URL + Urls.LOGIN);
	}

	private void validation() throws Exception {
		if (this.getUsername().trim().isEmpty()) {
			throw new Exception("Username não deve ficar em branco!");
		}
		if (this.getPassword().trim().isEmpty()) {
			throw new Exception("Password não deve ficar em branco!");
		}

	}

	// Métodos para tela

	public String getMensagemAlerta() {
		return mensagemAlerta;
	}

	public void setMensagemAlerta(String mensagemAlerta) {
		this.mensagemAlerta = mensagemAlerta;
	}

	public String getUsername() throws Exception {		
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
