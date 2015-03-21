package br.edu.qi.view;

import br.edu.qi.controller.Acao;
import br.edu.qi.controller.ClienteController;
import br.edu.qi.dto.Cliente;

public class ClienteGui {
	public void execute() throws Exception {
		Cliente cliente = new Cliente();
		cliente.setCodigo(9);
		cliente.setNome("Rapaz");
		
		ClienteController controller = new ClienteController();
		controller.setDto(cliente);
		controller.execute(Acao.INSERT);
		
		//controller.save(cliente);
		//controller.delete(cliente);
	}
}
