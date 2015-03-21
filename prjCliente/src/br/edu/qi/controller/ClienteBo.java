package br.edu.qi.controller;

import br.edu.qi.dao.ClienteDao;
import br.edu.qi.dto.Cliente;

public class ClienteBo implements AbstractBo<Cliente>{

	ClienteDao dao;

	public ClienteBo() {
		this.dao = new ClienteDao();
	}

	public void save(Cliente cliente) {
		try {
			if (cliente.getCodigo() != null) {
				dao.update(cliente);
			} else {
				dao.save(cliente);
			}
			System.out.println("Gravação com sucesso");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void delete(Cliente cliente) {
		try {
			dao.delete(cliente);
			System.out.println("Exclusão com sucesso");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
