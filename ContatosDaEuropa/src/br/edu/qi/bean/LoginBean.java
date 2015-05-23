package br.edu.qi.bean;

import br.edu.qi.dao.LoginDao;
import br.edu.qi.model.Login;

public class LoginBean {

	private LoginDao loginDao = new LoginDao();
	
	public boolean verificaLogin(Login login) {
		return loginDao.verificaLogin(login);
	}
	
}
