package br.edu.qi.euroschool.dao;

public class LoginDao {

	public static boolean validate(String user, String pwd) {
		
		if (user.equals("admin")) {
			return true;
		} else {
			return false;
		}
	}

}
