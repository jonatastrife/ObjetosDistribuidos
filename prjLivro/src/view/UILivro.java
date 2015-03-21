package view;

import controller.FacadeLivro;
import model.Livro;

public class UILivro {
	
	private static FacadeLivro fl = new FacadeLivro();
	
	public void execute() throws Exception {
		
		Livro livro = new Livro("687","Sherlock Holmes","Um autor qualquer", "Editora qualquer", 1990);	
		fl.save(livro);
			
	}
}
