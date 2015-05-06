package br.edu.qi.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.qi.beans.NotasBean;

@ManagedBean
@ViewScoped
public class NotaMB {

	@EJB
	NotasBean notaBean;
	
	double nota1;
	double nota2;
	double media;
	
	public void calcularMedia()
	{
		this.media=this.notaBean.calcularMedia(this.nota1, 
				this.nota2);
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	
	
}
