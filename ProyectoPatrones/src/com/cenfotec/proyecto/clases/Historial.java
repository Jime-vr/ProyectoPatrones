package com.cenfotec.proyecto.clases;

import java.io.IOException;
import java.util.ArrayList;

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
		return "\nSe ejecutó el proceso: " + this.getNomProceso() + "\nSe completó la tarea: " + this.getTituloTarea() + "\nPor: " + this.getAutor() + "La fecha: " + this.getFecha() + "A la hora: " + this.getHora();
	}
	
	public String verHistorial() throws IOException{
		Gestor gestor = new Gestor();
		ArrayList<Historial> listaHistorial = gestor.getListaHistorial();
		Historial historial;
		
		if(listaHistorial != null) {
			for(int i = 0; i < listaHistorial.size(); i++) {
				historial = listaHistorial.get(i);
				return "\nSe ejecutó el proceso: " + historial.getNomProceso() + "\nSe completó la tarea: " + historial.getTituloTarea() + "\nPor: " + historial.getAutor() + "La fecha: " + historial.getFecha() + "A la hora: " + historial.getHora();
			}
		}else {
			return "No se han ejecutado procesos";
		}
		return "No se han ejecutado procesos";
		
	}
	
}
