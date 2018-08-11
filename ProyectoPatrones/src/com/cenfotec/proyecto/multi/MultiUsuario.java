package com.cenfotec.protecto.multi;

import java.util.ArrayList;

import com.cenfotec.proyecto.acceso.Conector;
import com.cenfotec.proyecto.clases.Usuario;

public interface MultiUsuario {
	// crear usuario :: boolean
	
	public static ArrayList<String> datos = Conector.obtenerDatosAcceso();
	
	public static boolean crear(String nombre, String apellido, String grupo, String correo, String contrasenna) throws java.sql.SQLException, Exception {
		boolean creado = false;
		Usuario newUsuario = null;
		String sql = "INSERT INTO usuario ('id', 'nombre', 'apellido', 'grupo', 'correo', 'contrasenna') VALUES (NULL, 'rafael', 'bricenos', 'grupo', 'rafael@gmail.com', 'contrasenna2');";
		
		try {
			Conector.getConector(datos).ejecutarSQL(sql);
			creado = true;
			newUsuario = new Usuario(nombre, apellido, grupo, correo, contrasenna);
		} catch (Exception e) {
			
		}
		return creado;
	}
	
	public static boolean iniciarSesion(String correo, String constrasenna) throws java.sql.SQLException, Exception {
		
		Multi m = new Multi();
		boolean existe = false;
		
		String query = "SELECT * FROM usuario WHERE correo = " + "'" +correo +"' AND contrasenna = '" + constrasenna +"'";
		
		try {
			m.dbSelect(query);
			existe = true;
		} catch (Exception e) {
			
		}
		return existe;
	}

	
	// crear lista usuarios :: arraylist <Usuario> 

}
