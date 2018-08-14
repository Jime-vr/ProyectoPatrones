package com.cenfotec.proyecto.clases;

public class Historial {
	private String nomProceso;
	private String tituloTarea;
	private String autor;
	private String fecha;
	private String hora;

	public Historial() {

	}

	public Historial(String nomProceso, String tituloTarea, String autor, String fecha, String hora) {
		super();
		this.nomProceso = nomProceso;
		this.tituloTarea = tituloTarea;
		this.autor = autor;
		this.fecha = fecha;
		this.hora = hora;
	}

	public String getNomProceso() {
		return nomProceso;
	}

	public void setNomProceso(String nomProceso) {
		this.nomProceso = nomProceso;
	}

	public String getTituloTarea() {
		return tituloTarea;
	}

	public void setTituloTarea(String tituloTarea) {
		this.tituloTarea = tituloTarea;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String toString() {
		String info = "";

		info += "Se ejecutó el proceso: " + getNomProceso() + '\n'+ "Se completó la tarea: " + getTituloTarea() + '\n'+ "Por: "
				+ getAutor() + '\n'+ "La fecha: " + getFecha() + '\n'+ "A la hora: " + getHora() + '\n' + "<-------------------------------->" + '\n';
		return info;
	}
}
