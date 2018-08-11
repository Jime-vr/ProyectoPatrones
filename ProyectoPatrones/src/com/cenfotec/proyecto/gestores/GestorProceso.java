package com.cenfotec.proyecto.gestores;

import java.util.ArrayList;

import com.cenfotec.proyecto.clases.Proceso;
import com.cenfotec.proyecto.clases.Tarea;

public class GestorProceso {
	
	public static ArrayList<Proceso> listaProcesos = new ArrayList<Proceso>();

	
	public void quemarDatosProceso(ArrayList<Tarea> tareas) throws java.io.IOException {

		
		String nomProceso = "Contratación";

		Proceso proceso = new Proceso();
		proceso.setNomProceso(nomProceso);
		proceso.setTareas(tareas);

		GestorProceso procesoq = new GestorProceso();
		procesoq.listaProcesos.add(proceso);

		System.out.println("Listo!");
	}
	
	
	public ArrayList<Proceso> getListaProcesos() {
		return listaProcesos;
	}

	public void setListaProcesos(ArrayList<Proceso> listaProcesos) {
		GestorProceso.listaProcesos = listaProcesos;
	}
	
	public Proceso crearProceso(String pNomProceso, ArrayList<Tarea> pListaTareas) {
		Proceso proceso = new Proceso();

		proceso.setNomProceso(pNomProceso);
		proceso.setTareas(pListaTareas);

		listaProcesos.add(proceso);

		System.out.println("El proceso se ha almacenado correctamente");
		return proceso;
	}
	
	public Proceso actulizarProceso(Proceso pProceso, ArrayList<Tarea> pListaTareas) throws java.io.IOException {
		int indice = pProceso.getIndiceTarea();
		pProceso.setIndiceTarea(indice + 1);
		pProceso.setTareas(pListaTareas);

		return pProceso;
	}
	
	public void actualizarListaProcesos(Proceso pProAct) throws java.io.IOException {
		String nomProAct = pProAct.getNomProceso();
		Proceso proceso = new Proceso();
		String nomPro;

		for (int i = 0; i < listaProcesos.size(); i++) {
			proceso = listaProcesos.get(i);
			nomPro = proceso.getNomProceso();

			if (nomProAct.equals(nomPro)) {
				listaProcesos.remove(i);
				listaProcesos.add(i, pProAct);
			}
		}

		System.out.println("La tarea se completó satisfactoriamente");
	}
	
	

}
