package entidades;

public class Task {
	
	private String titulo;
	private int id;
	
	public Task (int id, String nome) {
		this.id = id;
		titulo = nome;
	}

	public Task() {
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
