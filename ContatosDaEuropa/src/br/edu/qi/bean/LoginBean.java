package br.edu.qi.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;

import br.edu.qi.dao.LoginDao;
import br.edu.qi.mb.MBUtils;
import br.edu.qi.model.Login;

@Stateless
@Local
public class LoginBean {

	private LoginDao loginDao = new LoginDao();
	
	public boolean verificaLogin(Login login) {
		//Aqui testa se o usuário existe no banco ou não
		if (loginDao.verificaLogin(login) || true) {			
			//Se existe adiciona na sessão o login e senha
			MBUtils.setAttribute("Login", login);
			
			return true;
		}else {
			return false;
		}
		
	}
	
	public Login getUsuarioLogado(){
		return (Login) MBUtils.getAttribute("Login");
	}
	
}
