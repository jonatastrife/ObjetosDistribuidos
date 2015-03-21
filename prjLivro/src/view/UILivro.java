package view;

import controller.FacadeLivro;
import model.Livro;

public class UILivro {
	
	private static FacadeLivro fl = new FacadeLivro();
	
	private void exibeLivros() throws Exception{
		for (Livro l: fl.findAll()){
			System.out.println(l);
		}
	}
	
	public void execute() throws Exception {
		
		System.out.println("Inserindo um livro");
		Livro livro = new Livro("687","Sherlock Holmes","Um autor qualquer", "Editora qualquer", 1990);	
		fl.save(livro);		
		exibeLivros();
		
		System.out.println("Deletando o mesmo livro");
		fl.delete(livro);
		exibeLivros();
		
		System.out.println("Salvando o mesmo livro");
		fl.save(livro);
		exibeLivros();
		
		System.out.println("Alterando o livro");
		livro.setTitulo("Teste");
		fl.update(livro);
		exibeLivros();
		
		System.out.println("Buscando o livro de antes, alterando e exibindo que alterou o mesmo já existente e inserindo outro igual");
		Livro livroClone = fl.find(0);
		livroClone.setTitulo("O mesmo livro de antes");
		fl.update(livroClone);
		fl.save(livroClone);
		exibeLivros();	
	}
}
