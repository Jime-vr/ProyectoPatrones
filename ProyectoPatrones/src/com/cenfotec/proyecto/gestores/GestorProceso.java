package com.cenfotec.proyecto.gestores;

import java.util.ArrayList;

import com.cenfotec.proyecto.clases.Proceso;
import com.cenfotec.proyecto.clases.Tarea;
import com.cenfotec.proyecto.multi.MultiProceso;

public class GestorProceso {
	
	

	
//	public void quemarDatosProceso(ArrayList<Tarea> tareas) throws java.io.IOException {
//
//		/* Proceso Contratación */
//		String nomProceso = "Contratación";
//
//		Proceso proceso = new Proceso();
//		proceso.setNomProceso(nomProceso);
//		proceso.setTareas(tareas);
//
//		GestorProceso procesoq = new GestorProceso();
//		procesoq.listaProcesos.add(proceso);
//
//		System.out.println("Listo!");
//	}
//	
//	
//	public ArrayList<Proceso> getListaProcesos(String grupo) {
//
//		return MultiProceso.getListaProcesos(grupo);
//	}
//
//	public void setListaProcesos(ArrayList<Proceso> listaProcesos) {
//		GestorProceso.listaProcesos = listaProcesos;
//	}
	
	public void crearProceso(String pNomProceso) {
		try {
			MultiProceso.crearProceso(pNomProceso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public Proceso actulizarProceso(Proceso pProceso, ArrayList<Tarea> pListaTareas) throws java.io.IOException {
//		int indice = pProceso.getIndiceTarea();
//		pProceso.setIndiceTarea(indice + 1);
//		pProceso.setTareas(pListaTareas);
//
//		return pProceso;
//	}
//	
//	public void actualizarListaProcesos(Proceso pProAct) throws java.io.IOException {
//		String nomProAct = pProAct.getNomProceso();
//		Proceso proceso = new Proceso();
//		String nomPro;
//
//		for (int i = 0; i < listaProcesos.size(); i++) {
//			proceso = listaProcesos.get(i);
//			nomPro = proceso.getNomProceso();
//
//			if (nomProAct.equals(nomPro)) {
//				listaProcesos.remove(i);
//				listaProcesos.add(i, pProAct);
//			}
//		}
//
//		System.out.println("La tarea se completó satisfactoriamente");
//	}
//	
//	

}
