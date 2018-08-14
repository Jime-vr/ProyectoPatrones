package com.cenfotec.proyecto.gestores;

import java.io.IOException;
import java.util.ArrayList;

import com.cenfotec.proyecto.clases.Proceso;
import com.cenfotec.proyecto.clases.Tarea;
import com.cenfotec.proyecto.fabrica.InterfaceGestores;
import com.cenfotec.proyecto.multi.MultiProceso;

public class GestorProceso implements InterfaceGestores{
	
	

	
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

	
	public void crearProceso(String pNomProceso) {
		try {
			MultiProceso.crearProceso(pNomProceso);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void quemarDatos() throws IOException {
		
	}
	


}
