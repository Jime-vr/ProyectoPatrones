package com.cenfotec.proyecto.clases;

import java.util.ArrayList;

public class Proceso {
	private String nomProceso;
	private int indiceTarea = 0;
	private ArrayList<Tarea> tareas	= new ArrayList<Tarea>();
	
	public Proceso() {
		
	}
	
	public Proceso(String nomProceso, int indiceTarea, ArrayList<Tarea> tareas) {
		super();
		this.nomProceso = nomProceso;
		this.indiceTarea = indiceTarea;
		this.tareas = tareas;
	}

	public String getNomProceso() {
		return nomProceso;
	}
	public void setNomProceso(String nomProceso) {
		this.nomProceso = nomProceso;
	}
	
	public int getIndiceTarea() {
		return indiceTarea;
	}
	public void setIndiceTarea(int indiceTarea) {
		this.indiceTarea = indiceTarea;
	}
	
	public ArrayList<Tarea> getTareas() {
		return tareas;
	}
	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}
}
