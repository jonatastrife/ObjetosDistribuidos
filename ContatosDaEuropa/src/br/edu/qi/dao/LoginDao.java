package br.edu.qi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.qi.model.Login;

public class LoginDao extends GenericDao {

	private static final String FIND_LOGIN = " SELECT * FROM Usuarios WHERE cd_usuario = '?' AND senha = '?' "; 
	
	public boolean verificaLogin(Login login) {
		PreparedStatement pstm = null;
		
		boolean encontrouLogin = false;
		
		try {
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(FIND_LOGIN);
			pstm.setString(1, login.getCd_usuario());
			pstm.setString(2, login.getSenha());
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				encontrouLogin = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return encontrouLogin;
	}
	
	
}
