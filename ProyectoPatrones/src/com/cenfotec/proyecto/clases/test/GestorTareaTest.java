package com.cenfotec.proyecto.clases.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.cenfotec.proyecto.clases.Tarea;
import com.cenfotec.proyecto.gestores.GestorTarea;
import com.cenfotec.proyecto.multi.MultiIndicaciones;
import com.cenfotec.proyecto.multi.MultiTarea;
import com.cenfotec.proyecto.multi.MultiUsuario;

class GestorTareaTest {

	@Test
	public void obtenerTitulo() throws Exception {
		assertEquals("titulo_tarea", MultiTarea.obtenerTareas("gerencia").get(0));
	}

//	@Test
//	public void obtenerIndicacion() throws Exception {
//		assertEquals("camila", MultiIndicaciones.obtenerIndicaciones("proceso2", "asdf").get(0));
//	}
	
//	@Test
//	public void crearTarea() throws Exception {
//		assertEquals(true, MultiTarea.crearTarea("procesoTest", "tituloTest", "grupoTest"));
//	}
	
	
//	GestorTarea gestor = new GestorTarea();
//	
//	@Test
//	public void crearTareaTest() throws IOException {
//		Tarea tareaTest = new Tarea();
//		ArrayList<String> indicaciones = new ArrayList<String>();
//		indicaciones.addAll(Arrays.asList("�Es mayor de edad?"));
//		tareaTest = gestor.crearTarea("Valoraci�n edad", "Recursos", indicaciones);
//		
//		assertTrue(tareaTest.getIndicaciones().size() == 1);
//	}
//	
//	@Test
//	public void actualizarTareaTest() throws IOException {
//		Tarea tareaTest = new Tarea();
//		Tarea tareaTestR = new Tarea();
//		ArrayList<String> indicaciones = new ArrayList<String>();
//		ArrayList<String> respuestas = new ArrayList<String>();
//		indicaciones.addAll(Arrays.asList("�Es mayor de edad?"));
//		respuestas.addAll(Arrays.asList("Si"));
//		tareaTestR = gestor.actualizarTarea(tareaTest, respuestas);
//		
//		assertEquals("Si", tareaTestR.getRespuestas().get(0));
//	}

}
