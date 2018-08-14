package com.cenfotec.proyecto.gestores;

import java.io.IOException;
import java.util.ArrayList;

import com.cenfotec.proyecto.clases.Proceso;
import com.cenfotec.proyecto.clases.Tarea;
import com.cenfotec.proyecto.clases.Usuario;
import com.cenfotec.proyecto.fabrica.InterfaceGestores;
import com.cenfotec.proyecto.multi.MultiIndicaciones;
import com.cenfotec.proyecto.multi.MultiRespuesta;
import com.cenfotec.proyecto.multi.MultiTarea;

public class GestorTarea implements InterfaceGestores{
	
	
	public void crearTarea(String nomProceso, String pTitTarea, String pGrupo) {
		try {
			MultiTarea.crearTarea(nomProceso, pTitTarea, pGrupo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<Tarea> quemarDatosTarea() throws java.io.IOException {

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
		String grupo3 = "Gerencia";
		ArrayList<String> indicaciones3 = new ArrayList<String>();
		indicaciones3.add("Indique el puesto del empleado");
		Tarea tarea3 = new Tarea();
		tarea3.setTitulo(titTar3);
		tarea3.setGrupoResponsable(grupo3);
		tarea3.setIndicaciones(indicaciones3);

		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
		tareas.add(tarea1);
		tareas.add(tarea2);
		tareas.add(tarea3);

		return tareas;
	}

//	public Tarea actualizarTarea(Tarea pTarea, ArrayList<String> pRespuestas) throws java.io.IOException {
//		pTarea.setRespuestas(pRespuestas);
//
//		return pTarea;
//	}

	public static void crearIndicacion(String nomProceso, String indicacion, String titulo) {
		try {
			MultiIndicaciones.crearIndicacion(nomProceso, indicacion, titulo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Tarea> obtenerTareas(String grupo) {
		try {
			return MultiTarea.obtenerTareas(grupo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<String> obtenerIndicaciones(String nomProceso, String titulo) {
		try {
			return MultiIndicaciones.obtenerIndicaciones(nomProceso, titulo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void crearRespuesta(String nomProceso, String respuesta, String titulo) {
		MultiRespuesta.crearRespuesta(nomProceso, respuesta, titulo);
		
	}

	@Override
	public void quemarDatos() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void actualizarTarea(String nomProceso, String titulo) {
		try {
			MultiTarea.actualizarTarea(nomProceso, titulo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
