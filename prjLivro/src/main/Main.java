package main;

import view.UILivro;


public class Main {
	
	public static void main(String[] args) {
		UILivro gui = new UILivro();
		try {
			gui.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
