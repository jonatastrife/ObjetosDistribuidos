package main;

import view.UILivro;


public class Main {
	
	public static void main(String[] args) {
		UILivro uiLivro = new UILivro();
		try {
			uiLivro.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
