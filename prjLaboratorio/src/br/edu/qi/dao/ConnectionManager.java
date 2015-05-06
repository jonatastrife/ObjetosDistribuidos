package br.edu.qi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionManager {

	/**
	 * Classe Singleton responsável pelo
	 * gerenciamento das conexões de banco
	 */
	private static ConnectionManager 
					connection;
	private static ResourceBundle config;
	
	private ConnectionManager()
	{
		config = ResourceBundle.getBundle("config");
	}
	public static ConnectionManager getInstance()
	{
		if (connection==null)
			connection = new ConnectionManager();
		return connection;
	}
	public static void close() throws ClassNotFoundException, SQLException
	{
		if (getInstance().getConnection()!=null)
			getInstance().getConnection().close();
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		//procurar o Driver no a.rquivo de propriedades
		//e carragá-lo 
		Class.forName(config.getString("br.edu.qi.Driver"));
		
		return DriverManager.getConnection(
			config.getString("br.edu.qi.url"), 
			config.getString("br.edu.qi.user"), 
			config.getString("br.edu.qi.pwd"));
				
		
	}

}
