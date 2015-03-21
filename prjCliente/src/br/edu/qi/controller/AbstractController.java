package br.edu.qi.controller;

public interface AbstractController<T> {
	
	public void save(T t);
	public void delete(T t);
	
}
