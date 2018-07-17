package com.cenfotec.proyecto.clases.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.cenfotec.proyecto.clases.Gestor;
import com.cenfotec.proyecto.clases.Historial;
import com.cenfotec.proyecto.clases.Tarea;

public class GestorTest {
	

	
	@Test
	public void validarCorreoTest() throws IOException {
		gestor.quemarDatos();
		assertEquals(false, gestor.validarCorreo("silvia@gmail.com"));
		assertEquals(true, gestor.validarCorreo("susana@gmail.com"));
	}
	
	@Test
	public void verHistorialTest() throws IOException {
		Historial h = new Historial();
		assertEquals("No se han ejecutado procesos", h.verHistorial());
	}

}
