package com.cenfotec.proyecto.gestores;

import java.util.ArrayList;
import java.util.Iterator;

import com.cenfotec.proyecto.clases.Proceso;
import com.cenfotec.proyecto.clases.Tarea;
import com.cenfotec.proyecto.clases.Usuario;
import com.cenfotec.proyecto.fabrica.InterfaceGestores;

public class GestorProceso implements InterfaceGestores {

	public static ArrayList<Proceso> listaProcesos = new ArrayList<Proceso>();
	static Proceso proceso = new Proceso();
	static Tarea tarea = new Tarea();
	static GestorUsuario gU = new GestorUsuario();
	static GestorTarea gT = new GestorTarea();

	public void quemarDatos() throws java.io.IOException {

		ArrayList<Tarea> tareas = gT.obtenerTarea();
		String nomProceso = "Contratación";

		Proceso proceso = new Proceso();
		proceso.setNomProceso(nomProceso);
		proceso.setTareas(tareas);

		listaProcesos.add(proceso);

		System.out.println("Listo!");
	}

	public static ArrayList<Proceso> getListaProcesos() {
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

	public static Proceso actulizarProceso(Proceso pProceso, ArrayList<Tarea> pListaTareas) throws java.io.IOException {
		int indice = pProceso.getIndiceTarea();
		pProceso.setIndiceTarea(indice + 1);
		pProceso.setTareas(pListaTareas);

		return pProceso;
	}

	public static void actualizarListaProcesos(Proceso pProAct) throws java.io.IOException {
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
	
	public Proceso seleccionarProceso(int opc, String pCorreo) throws java.io.IOException {

		ArrayList<Proceso> listaProcesos = getListaProcesos();
		ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
		int indice, contador = 0;

		Usuario usuario = gU.obtenerUsuario(pCorreo);
		String grupoUsuario, grupoTarea;
		Proceso procesoSelec = new Proceso();

		for (int i = 0; i < listaProcesos.size(); i++) {

			proceso = listaProcesos.get(i);
			indice = proceso.getIndiceTarea();


			if(indice > 1) {
				indice = indice -1;
			}
			
			
			listaTareas = proceso.getTareas();
			tarea = listaTareas.get(indice);

			grupoUsuario = usuario.getGrupo();
			grupoTarea = tarea.getGrupoResponsable();

			if (grupoUsuario.equals(grupoTarea)) {
				if ((opc - 1) == contador) {

					procesoSelec = proceso;

				}
				contador++;

			}

		}

		return procesoSelec;

	}
	

	public int verProcesos(String pCorreo) throws java.io.IOException {
		Usuario usuario = gU.obtenerUsuario(pCorreo);
		ArrayList<Proceso> listaProcesos = getListaProcesos();
		int indice = 0, contador = 0;
		ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
		String grupoUsuario, grupoTarea;

		Iterator<Proceso> iterator = listaProcesos.iterator();

		while (iterator.hasNext()) {

			proceso = iterator.next();
			indice = proceso.getIndiceTarea();

			listaTareas = proceso.getTareas();
			tarea = listaTareas.get(indice);

			grupoUsuario = usuario.getGrupo();
			grupoTarea = tarea.getGrupoResponsable();

			if (grupoUsuario.equals(grupoTarea)) {

				System.out.println("");
				System.out.println((contador + 1) + ".");
				System.out.println("Proceso: " + proceso.getNomProceso());
				System.out.println("Tarea: " + tarea.getTitulo());
				System.out.println("");
				System.out.println("<---------------------->");
				contador++;

			}

		}
		if (contador == 0) {

			System.out.println("");
			System.out.println("No hay tareas de procesos a ejecutar disponibles");
			System.out.println("");

		}

		return contador;

	}

}
