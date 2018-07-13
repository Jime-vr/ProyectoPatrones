package com.cenfotec.proyecto.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.cenfotec.proyecto.clases.Gestor;
import com.cenfotec.proyecto.clases.Tarea;

public class GestorTest {
	
	Gestor gestor = new Gestor();
	
	@Test
	public void crearTareaTest() throws IOException {
		Tarea tareaTest = new Tarea();
		ArrayList<String> indicaciones = new ArrayList<String>();
		indicaciones.addAll(Arrays.asList("¿Es mayor de edad?"));
		tareaTest = gestor.crearTarea("Valoración edad", "Recursos", indicaciones);
		
		assertTrue(tareaTest.getIndicaciones().size() == 1);
	}
	
	@Test
	public void actualizarTareaTest() throws IOException {
		Tarea tareaTest = new Tarea();
		Tarea tareaTestR = new Tarea();
		ArrayList<String> indicaciones = new ArrayList<String>();
		ArrayList<String> respuestas = new ArrayList<String>();
		indicaciones.addAll(Arrays.asList("¿Es mayor de edad?"));
		respuestas.addAll(Arrays.asList("Si"));
		tareaTestR = gestor.actualizarTarea(tareaTest, respuestas);
		
		assertEquals("Si", tareaTestR.getRespuestas().get(0));
	}

}