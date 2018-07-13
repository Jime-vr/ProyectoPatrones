package com.cenfotec.proyecto.clases;

import java.util.ArrayList;

public class Tarea {
	private String titulo;
	private String grupoResponsable;
	private ArrayList<String> indicaciones = new ArrayList<String>();
	private ArrayList<String> respuestas = new ArrayList<String>();
	
	public Tarea() {
		
	}
	
	public Tarea(String titulo, String grupoResponsable, ArrayList<String> indicaciones, ArrayList<String> respuestas) {
		super();
		this.titulo = titulo;
		this.grupoResponsable = grupoResponsable;
		this.indicaciones = indicaciones;
		this.respuestas = respuestas;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getGrupoResponsable() {
		return grupoResponsable;
	}
	public void setGrupoResponsable(String grupoResponsable) {
		this.grupoResponsable = grupoResponsable;
	}
	
	public ArrayList<String> getIndicaciones() {
		return indicaciones;
	}
	public void setIndicaciones(ArrayList<String> indicaciones) {
		this.indicaciones = indicaciones;
	}
	
	public ArrayList<String> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(ArrayList<String> respuestas) {
		this.respuestas = respuestas;
	}
}
