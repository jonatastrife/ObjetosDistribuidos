package br.edu.qi.dao;

import java.util.ArrayList;

import br.edu.qi.dto.Cliente;

public class ClienteDao extends GenericDao implements IDAO<Cliente>{

	private static final String INSERT = "INSERT INTO CLIENTE VALUES (?, ?)";
	private static final String DELETE = "DELETE FROM CLIENTE WHERE codigo = ?";
	private static final String UPDATE = "UPDATE CLIENTE SET NOME = ? WHERE codigo = ?";
	
	public void save(Cliente obj) throws Exception {
		try {
			super.executeSQL(INSERT, obj.getCodigo(), obj.getNome());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void delete(Cliente obj) throws Exception {
		try {
			super.executeSQL(DELETE, obj.getCodigo());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Cliente find(Cliente obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Cliente obj) throws Exception {
		super.executeSQL(UPDATE, obj.getNome(), obj.getCodigo());
		
	}

	
	
}
