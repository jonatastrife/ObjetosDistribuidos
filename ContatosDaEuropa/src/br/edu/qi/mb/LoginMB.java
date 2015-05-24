package br.edu.qi.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.plaf.multi.MultiButtonUI;

import br.edu.qi.bean.LoginBean;
import br.edu.qi.model.Login;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String URL_CONTATOS = "http://localhost:8080/ContatosDaEuropa/view/contatos.xhtml";
	private final String URL_LOGIN = "http://localhost:8080/ContatosDaEuropa/view/login.xhtml";

	@EJB
	LoginBean bean;

	private String username;
	private String password;

	private String mensagemAlerta;

	public void executeLogin() {
		this.setMensagemAlerta("");

		try {
			this.validation();

			Login login = new Login(this.getUsername(), this.getPassword());

			if (bean.verificaLogin(login)) {
				MBUtils.redirecionarPara(URL_CONTATOS);
			} else {
				MBUtils.buildMessage("mensagemAlerta",
						"Usuário não encontrado!");
			}
		} catch (Exception e) {
			MBUtils.buildMessage("mensagemAlerta", e.getMessage());
		}
	}

	public void deslogarUsuario() throws IOException {
		MBUtils.encerrarSessao();
		MBUtils.redirecionarPara(URL_LOGIN);
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

	public String getUsername() {
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
