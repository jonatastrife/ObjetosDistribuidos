package br.edu.qi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ConnectionManager {

	/**
	 * Classe padrão Singleton - trabalha somente com uma instância para toda a aplicação
	 */
	
	private static ConnectionManager connection;
	private static ResourceBundle config;
	
	private ConnectionManager() {
		config = ResourceBundle.getBundle("config"); 
	}
	
	public static ConnectionManager getInstance() {
		if (connection==null) {
			connection = new ConnectionManager();
		}
		return connection;
	}
	
	public void close() throws ClassNotFoundException, SQLException {
		if (getInstance().getConnection() != null) {
			getInstance().getConnection().close();
		}
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		//carregar a classe com o Driver do mysql
		Class.forName(config.getString("br.edu.qi.Driver"));
		return DriverManager.getConnection(config.getString("br.edu.qi.url"),
										   config.getString("br.edu.qi.user"),
										   config.getString("br.edu.qi.pwd"));
	}
	
}
