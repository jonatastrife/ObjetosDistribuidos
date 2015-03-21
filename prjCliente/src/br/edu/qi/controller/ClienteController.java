package br.edu.qi.controller;

import br.edu.qi.dto.Cliente;

public class ClienteController implements AbstractController<Cliente>{

	private static ClienteBo bo = new ClienteBo();
	private Cliente dto;
	
	public void save(Cliente cliente) {
		bo.save(cliente);
	}

	public void delete(Cliente cliente) {
		bo.delete(cliente);
	}

	public void setDto(Cliente dto) {
		this.dto = dto;
	}
	
	private void validation() throws Exception {
		if (this.dto.getCodigo() <= 0) {
			throw new Exception("ISSO É PHP CARALHO");
		}
		if (this.dto.getNome().trim().isEmpty()) {
			throw new Exception("ISSO É PHP CARALHO");
		}
		
	}
	
	public void execute (Acao acao, String method) throws Exception {
	}

	public void execute(Acao acao) throws Exception {
		switch (acao) {
		case UPDATE:
		case INSERT:
			validation();
			bo.save(this.dto);
			break;
		case DELETE:
			validation();
			bo.delete(dto);
			break;
		default:
			break;
		}		
	}
	
}
