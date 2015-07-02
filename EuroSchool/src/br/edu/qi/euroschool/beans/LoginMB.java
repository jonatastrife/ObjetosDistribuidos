package br.edu.qi.euroschool.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.edu.qi.euroschool.dao.LoginDao;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	private String pwd;
	private String msg;
	private String user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	// validate login
	public String validaUsuario() {
		boolean valid = LoginDao.validate(user, pwd);
		if (valid) {
			HttpSession session = SessionBean.getSession();
			session.setAttribute("username", user);
			return "home";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Usuário ou Senha inválidos, palhaço!",
							"Porfavor informe o usuário e senha corretos "));
			return "login";
		}
	}

	// logout event, invalidate session
	public String logout() {
		HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "login";
	}
}
