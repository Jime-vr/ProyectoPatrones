package com.cenfotec.proyecto.clases.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.cenfotec.proyecto.gestores.GestorHistorial;

class GestorHistorialTest {

	GestorHistorial gestor = new GestorHistorial();
	
	@Test
	void verHistorial() throws IOException {
		
		String info =  "No se han ejecutado procesos";
		
		assertEquals(info, gestor.verHistorial());
		
	}

}
