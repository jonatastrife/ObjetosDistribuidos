package br.edu.qi.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;

import br.edu.qi.dao.LoginDao;
import br.edu.qi.model.Login;

@Stateless
@Local
public class LoginBean {

	private LoginDao loginDao = new LoginDao();
	
	public boolean verificaLogin(Login login) {
		if (loginDao.verificaLogin(login)) {
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("login",login.getCd_usuario());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("senha",login.getSenha());
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("senha");
			
			return true;
		}else {
			return false;
		}
		
	}
	
}
