package model;

public class Livro {

	private String isbn;
	private String titulo;
	private String autor;
	private String editora;
	private Integer anoObra;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Integer getAnoObra() {
		return anoObra;
	}

	public void setAnoObra(Integer anoObra) {
		this.anoObra = anoObra;
	}

}
