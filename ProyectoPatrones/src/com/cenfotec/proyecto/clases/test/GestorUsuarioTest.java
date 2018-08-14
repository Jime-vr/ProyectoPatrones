package com.cenfotec.proyecto.clases.test;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.cenfotec.proyecto.clases.Usuario;
import com.cenfotec.proyecto.gestores.GestorUsuario;
import com.cenfotec.proyecto.multi.MultiUsuario;

class GestorUsuarioTest {
	
	@Test
	public void validarCorreoTest() throws Exception {
		assertEquals(true, MultiUsuario.revisarCorreo("silvia@gmail.com"));
	}
	
	@Test
	public void validarCorreoTest2() throws Exception {
		assertEquals(false, MultiUsuario.revisarCorreo("false@gmail.com"));
	}
	
	@Test
	public void obtenerCorreoUsuarioTest()throws SQLException, Exception{
		assertEquals(true,MultiUsuario.iniciarSesion("silvia@gmail.com", "123"));
	}
	
	@Test
	public void obtenerCorreoUsuarioTest2()throws SQLException, Exception{
		assertEquals(false,MultiUsuario.iniciarSesion("silvia@gmail.com", "321"));
	}
	
	@Test
	public void obtenerUsuarioTest()throws SQLException, Exception{
		Usuario u = new Usuario ("silvia", "bolanos", "gerencia", "silvia@gmail.com", "123");
		assertEquals(u.getNombre(),MultiUsuario.informacionUsuario("silvia@gmail.com").getNombre());
		assertEquals(u.getApellido(),MultiUsuario.informacionUsuario("silvia@gmail.com").getApellido());
	}
	
	
	
	
	
	
//	@Test
//	public void validarCorreoTest() throws IOException {
//		GestorUsuario gu = new GestorUsuario();
//		gu.quemarDatosUsuario();
//		assertEquals(false, gu.validarCorreo("silvia@gmail.com"));
//		assertEquals(true, gu.validarCorreo("susana@gmail.com"));
//	}
//	
//	@Test
//	public void obtenerCorreoUsuarioTest()throws IOException{
//		GestorUsuario gu = new GestorUsuario();
//		assertEquals("correo default",gu.obtenerCorreoUsuario());
//	}
//	
//	@Test
//	public void obtenerCorreoUsuarioTest2()throws IOException{
//		GestorUsuario gu = new GestorUsuario();
//		//gu.quemarDatosUsuario();
//		gu.iniciarSesion("susana@gmail.com", "741");
//		//assertEquals("susana@gmail.com",gu.obtenerCorreoUsuario());
//	}
//	
//	@Test
//	public void obtenerCorreoUsuarioTest3()throws IOException{
//		GestorUsuario gu = new GestorUsuario();
//		//gu.quemarDatosUsuario();
//		gu.iniciarSesion("roberto@gmail.com", "7524");
//		//assertEquals("correo default",gu.obtenerCorreoUsuario());
//	}

}
