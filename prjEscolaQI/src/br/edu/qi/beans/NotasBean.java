package br.edu.qi.beans;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class NotasBean {

	public double calcularMedia(double n1,
								double n2)
	{
		return (n1+n2)/2;
	}

	
}
