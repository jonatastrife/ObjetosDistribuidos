package br.edu.qi.controller;

public interface AbstractBo<T> {
	
	public void save(T t);
	public void delete(T t);
	
}
