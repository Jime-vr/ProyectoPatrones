package com.cenfotec.proyecto.gestores;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.cenfotec.proyecto.clases.Proceso;
import com.cenfotec.proyecto.clases.Tarea;
import com.cenfotec.proyecto.clases.Usuario;
import com.cenfotec.proyecto.fabrica.InterfaceGestores;

public class GestorTarea implements InterfaceGestores{
	
<<<<<<< HEAD
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
=======
	static ArrayList<Tarea> infoTarea = new ArrayList<Tarea>();
>>>>>>> Rafa_Bricenoa
	
	public Tarea crearTarea(String pTitTarea, String pGrupo, ArrayList<String> pListaIndicaciones)
			throws java.io.IOException {
		Tarea tarea = new Tarea();

		tarea.setTitulo(pTitTarea);
		tarea.setGrupoResponsable(pGrupo);
		tarea.setIndicaciones(pListaIndicaciones);

		return tarea;
	}
	
	public void quemarDatos() throws java.io.IOException {

		/* Tareas del proceso Contratación */
		String titTar = "Formulario de empleado";
		String grupo = "Recursos";
		ArrayList<String> indicaciones1 = new ArrayList<String>();
		indicaciones1.add("Indique el nombre del empleado");
		indicaciones1.add("Indique el apellido del empleado");
		indicaciones1.add("Indique el correo del empleado");
		Tarea tarea1 = new Tarea();
		tarea1.setTitulo(titTar);
		tarea1.setGrupoResponsable(grupo);
		tarea1.setIndicaciones(indicaciones1);

		String titTar2 = "Asignación de salario";
		String grupo2 = "Contaduría";
		ArrayList<String> indicaciones2 = new ArrayList<String>();
		indicaciones2.add("Indique el monto salarial del empleado");
		Tarea tarea2 = new Tarea();
		tarea2.setTitulo(titTar2);
		tarea2.setGrupoResponsable(grupo2);
		tarea2.setIndicaciones(indicaciones2);

		String titTar3 = "Asignación de puesto";
		String grupo3 = "gerencia";
		ArrayList<String> indicaciones3 = new ArrayList<String>();
		indicaciones3.add("Indique el puesto del empleado");
		Tarea tarea3 = new Tarea();
		tarea3.setTitulo(titTar3);
		tarea3.setGrupoResponsable(grupo3);
		tarea3.setIndicaciones(indicaciones3);

		infoTarea.add(tarea1);
		infoTarea.add(tarea2);
		infoTarea.add(tarea3);
	}
	
	public ArrayList<Tarea> obtenerTarea(){
		return infoTarea;
	}

	public static Tarea actualizarTarea(Tarea pTarea, ArrayList<String> pRespuestas) throws java.io.IOException {
		pTarea.setRespuestas(pRespuestas);

		return pTarea;
	}
	
	public static void completarTarea(Proceso pProceso, String pCorreo) throws java.io.IOException {
		int indice = pProceso.getIndiceTarea();
		ArrayList<Tarea> listaTareas = pProceso.getTareas();
		Tarea tarea = listaTareas.get(indice);
		ArrayList<String> indicaciones = tarea.getIndicaciones();
		ArrayList<String> respuestas = new ArrayList<String>();
		Tarea tarAct = new Tarea();
		Proceso proAct = new Proceso();
		Usuario usuario = GestorUsuario.obtenerUsuario(pCorreo);

		for (int i = 0; i < indicaciones.size(); i++) {
			System.out.println(indicaciones.get(i));
			respuestas.add(in.readLine());
		}

		tarAct = actualizarTarea(tarea, respuestas);
		listaTareas.remove(indice);
		listaTareas.add(indice, tarAct);
		proAct = GestorProceso.actulizarProceso(pProceso, listaTareas);
		GestorProceso.actualizarListaProcesos(proAct);

		GestorHistorial.registrarHistorial(pProceso.getNomProceso(), tarea.getTitulo(), usuario.getNombre() + " " + usuario.getApellido());
	}
}
