package com.cenfotec.proyecto.gestores;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cenfotec.proyecto.clases.Tarea;
import com.cenfotec.proyecto.clases.Usuario;
import com.cenfotec.proyecto.fabrica.InterfaceGestores;
import com.cenfotec.proyecto.multi.MultiUsuario;

 public class GestorUsuario implements InterfaceGestores{
	
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private String correo = "correo default";
	
//	public void quemarDatosUsuario() throws java.io.IOException {
//		
//		GestorTarea gestorTarea = new GestorTarea();
//		GestorProceso gestorProceso = new GestorProceso();
//		
//		/* Usuarios */
//		Usuario usuario = new Usuario("Rafael", "Briceño", "administrador", "rafa@gmail.com", "123");
//		listaUsuarios.add(usuario);
//
//		Usuario usuario2 = new Usuario("Luis", "Vargas", "recursos", "luis@gmail.com", "456");
//		listaUsuarios.add(usuario2);
//
//		Usuario usuario3 = new Usuario("Juan", "Calderon", "contaduría", "juan@gmail.com", "789");
//		listaUsuarios.add(usuario3);
//
//		Usuario usuario4 = new Usuario("Susana", "Zelaya", "gerencia", "susana@gmail.com", "741");
//		listaUsuarios.add(usuario4);
//		
//		ArrayList<Tarea> tareas = gestorTarea.quemarDatosTarea();
//		gestorProceso.quemarDatosProceso(tareas);
//		
//	}
	
	public void guardarCorreoActual(String pcorreo) {
		correo = pcorreo;
	}
	
	public String obtenerCorreoUsuario() {
		return correo;
	}
	
	
	public ArrayList<Usuario> getListaUsuarios() throws java.io.IOException {
		return listaUsuarios;
	}
	
	/* Se valida que el correo no este repetido */
	public boolean validarCorreo(String pCorreo) {

		try {
			return MultiUsuario.revisarCorreo(pCorreo);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/* Valida los datos ingresados para el inicio de sesión */
	public boolean iniciarSesion(String pCorreo, String pContrasenna) throws java.io.IOException {
		
		try {
			return MultiUsuario.iniciarSesion(pCorreo, pContrasenna);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	

	
	public boolean validarDatosUsuario(String[] pDatos) throws java.io.IOException {
		boolean error = false;

		for (int i = 0; i < pDatos.length; i++) {
			if (pDatos[i].equals("") || pDatos[i].equals(" ")) {
				error = true;
			}
		}
 
		return error;
	}

	public Usuario obtenerUsuario(String pCorreo) {
		// TODO Auto-generated method stub
		try {
			return MultiUsuario.informacionUsuario(pCorreo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void crearUsuario(String nombre, String apellido, String grupo, String correo, String contrasenna) {
		try {
			MultiUsuario.crearUsuario(nombre, apellido, grupo, correo, contrasenna);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void quemarDatos() throws IOException {
		// TODO Auto-generated method stub
		
	}
 }