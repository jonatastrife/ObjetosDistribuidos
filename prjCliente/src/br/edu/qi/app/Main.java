package br.edu.qi.app;

import br.edu.qi.view.ClienteGui;

public class Main {
	
	public static void main(String[] args) {
		ClienteGui gui = new ClienteGui();
		try {
			gui.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
