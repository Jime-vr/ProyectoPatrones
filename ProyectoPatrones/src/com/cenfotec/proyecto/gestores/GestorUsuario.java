package com.cenfotec.proyecto.gestores;
 
import java.io.IOException;
import java.util.ArrayList;

import com.cenfotec.proyecto.clases.Tarea;
import com.cenfotec.proyecto.clases.Usuario;

 public class GestorUsuario {
	
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private String correo = "correo default";
	
	public void quemarDatosUsuario() throws java.io.IOException {
		
		GestorTarea gestorTarea = new GestorTarea();
		GestorProceso gestorProceso = new GestorProceso();
		
		/* Usuarios */
		Usuario usuario = new Usuario("Rafael", "Briceño", "administrador", "rafa@gmail.com", "123");
		listaUsuarios.add(usuario);

		Usuario usuario2 = new Usuario("Luis", "Vargas", "recursos", "luis@gmail.com", "456");
		listaUsuarios.add(usuario2);

		Usuario usuario3 = new Usuario("Juan", "Calderon", "contaduría", "juan@gmail.com", "789");
		listaUsuarios.add(usuario3);

		Usuario usuario4 = new Usuario("Susana", "Zelaya", "gerencia", "susana@gmail.com", "741");
		listaUsuarios.add(usuario4);
		
		ArrayList<Tarea> tareas = gestorTarea.quemarDatosTarea();
		gestorProceso.quemarDatosProceso(tareas);
		
	}
	
	public void guardarCorreoActual(String pcorreo) {
		correo = pcorreo;
	}
	
	public String obtenerCorreoUsuario() {
		return correo;
	}
	
	public void crearUsuario(String pNombre, String pApellido, String pGrupo, String pCorreo, String pContrasenna)
			throws java.io.IOException {
		Usuario usuario = new Usuario(pNombre, pApellido, pGrupo, pCorreo, pContrasenna);

		listaUsuarios.add(usuario);

		System.out.println("El usuario se ha registrado correctamente");
	}
	
	public ArrayList<Usuario> getListaUsuarios() throws java.io.IOException {
		return listaUsuarios;
	}
	
	public boolean validarCorreo(String pCorreo) throws IOException {
		boolean error = false;

		ArrayList<Usuario> listaUsuarios = getListaUsuarios();
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (pCorreo.equals(listaUsuarios.get(i).getCorreo())) {
				error = true;
			}
		}

		return error;
	}
	
	public boolean iniciarSesion(String pCorreo, String pContrasenna) throws java.io.IOException {
		boolean iniciar = false;
		String correo, contrasenna;

		ArrayList<Usuario> listaUsuarios = getListaUsuarios();
		for (int i = 0; i < listaUsuarios.size(); i++) {

			correo = listaUsuarios.get(i).getCorreo();
			contrasenna = listaUsuarios.get(i).getContrasenna();

			if (pCorreo.equals(correo) && pContrasenna.equals(contrasenna)) {
				guardarCorreoActual(correo);
				iniciar = true;
			}
		}

		return iniciar;
	}
	
	public Usuario obtenerUsuario(String pCorreo) throws java.io.IOException {

		String correo;
		Usuario usuario = new Usuario();

		ArrayList<Usuario> listaUsuarios = getListaUsuarios();

		for (int i = 0; i < listaUsuarios.size(); i++) {

			correo = listaUsuarios.get(i).getCorreo();

			if (correo.equals(pCorreo)) {
				 usuario = listaUsuarios.get(i);
			}
		}

		return usuario;
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
 }