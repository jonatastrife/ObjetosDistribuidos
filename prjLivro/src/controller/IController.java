package controller;

import model.Acao;

public interface IController<T> {

	public void execute (Acao acao, String method) throws Exception ;
	
	public void execute(Acao acao) throws Exception;
	
}
