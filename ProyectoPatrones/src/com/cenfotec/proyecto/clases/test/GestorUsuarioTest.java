package com.cenfotec.proyecto.clases.test;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import com.cenfotec.proyecto.gestores.GestorUsuario;

class GestorUsuarioTest {
	
	@Test
	public void validarCorreoTest() throws IOException {
		GestorUsuario gu = new GestorUsuario();
		gu.quemarDatos();
		assertEquals(false, gu.validarCorreo("silvia@gmail.com"));
		assertEquals(true, gu.validarCorreo("susana@gmail.com"));
	}
	
	@Test
	public void obtenerCorreoUsuarioTest()throws IOException{
		GestorUsuario gu = new GestorUsuario();
		assertEquals("correo default",gu.obtenerCorreoUsuario());
	}
	
	@Test
	public void obtenerCorreoUsuarioTest2()throws IOException{
		GestorUsuario gu = new GestorUsuario();
		gu.quemarDatos();
		gu.iniciarSesion("susana@gmail.com", "741");
		assertEquals("susana@gmail.com",gu.obtenerCorreoUsuario());
	}
	
	@Test
	public void obtenerCorreoUsuarioTest3()throws IOException{
		GestorUsuario gu = new GestorUsuario();
		gu.quemarDatos();
		gu.iniciarSesion("roberto@gmail.com", "7524");
		assertEquals("correo default",gu.obtenerCorreoUsuario());
	}

}
