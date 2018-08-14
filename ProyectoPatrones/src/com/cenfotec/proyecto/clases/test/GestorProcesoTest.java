package com.cenfotec.proyecto.clases.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.cenfotec.proyecto.clases.Proceso;
import com.cenfotec.proyecto.clases.Tarea;
import com.cenfotec.proyecto.gestores.GestorProceso;
import com.cenfotec.proyecto.gestores.GestorTarea;

class GestorProcesoTest {
	
	GestorTarea gestor = new GestorTarea();
	GestorProceso gestorP = new GestorProceso();

//	@Test
//	void CrearProcesoTest() throws IOException {
//
//		Tarea tareaTest = new Tarea();
//		Proceso proceso = new Proceso();
//		ArrayList<String> indicaciones = new ArrayList<String>();
//		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
//		indicaciones.addAll(Arrays.asList("¿Es mayor de edad?"));
//		tareaTest = gestor.crearTarea("Valoración edad", "Recursos", indicaciones);
//		tareas.add(tareaTest);
//		
//		proceso = gestorP.crearProceso("Registro", tareas);
//		assertTrue(proceso.getNomProceso() == "Registro");
//
//	}

}
