package pojo;

import java.util.ArrayList;

public class Serie {
	private int id;
	private String titulo;
	private int edad;
	private String plataforma;
	private ArrayList<Temporada>temporadas;
	
	public Serie(String titulo, int edad, String platadforma) {
		super();
		this.titulo = titulo;
		this.edad = edad;
		this.plataforma = platadforma;
		
	}

	public Serie(int id, String titulo, int edad, String platadforma, ArrayList<Temporada> temporadas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.edad = edad;
		this.plataforma = platadforma;
		this.temporadas = temporadas;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String platadforma) {
		this.plataforma = platadforma;
	}

	public ArrayList<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(ArrayList<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	@Override
	public String toString() {
		return "Serie [id=" + id + ", titulo=" + titulo + ", edad=" + edad + ", platadforma=" + plataforma
				+ ", temporadas=" + temporadas + "]";
	}
	
	
	
}
