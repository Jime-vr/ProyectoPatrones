package com.cenfotec.proyecto.multi;

import java.util.ArrayList;

import com.cenfotec.proyecto.acceso.Conector;
import com.cenfotec.proyecto.clases.Usuario;

public class MultiUsuario {
	// crear usuario :: boolean

	// public static ArrayList<String> datos = Conector.obtenerDatosAcceso();

	public static boolean crearUsuario(String nombre, String apellido, String grupo, String correo, String contrasenna)
			throws Exception {
		boolean creado = false;
		String sql = "INSERT INTO usuario (nombre, apellido, grupo, correo, contrasenna) VALUES ('" + nombre + "', '"
				+ apellido + "', '" + grupo + "', '" + correo + "', '" + contrasenna + "');";

		try {
			Conector.getConector().ejecutarSQL(sql);
			creado = true;

		} catch (Exception e) {
			throw new Exception(e);
		}
		return creado;
	}

	public static boolean iniciarSesion(String correo, String contrasenna) throws java.sql.SQLException, Exception {
		boolean existe = false;
		String sql;
		java.sql.ResultSet rs;
		sql = "SELECT * FROM usuario WHERE correo='" + correo + "' AND contrasenna = '" + contrasenna + "';";

		rs = Conector.getConector().ejecutarSQL(sql, true);

		if (rs.next()) {
			existe = true;
		}

		return existe;
	}

	public static boolean revisarCorreo(String correo) throws java.sql.SQLException, Exception {
		boolean existe = false;
		String sql;
		java.sql.ResultSet rs;
		sql = "SELECT * FROM usuario WHERE correo='" + correo + "';";

		rs = Conector.getConector().ejecutarSQL(sql, true);

		if (rs.next()) {
			existe = true;
		}

		return existe;
	}

	public static Usuario informacionUsuario(String correo) throws Exception {

		String sql;
		java.sql.ResultSet rs;
		Usuario usuario = null;

		sql = "SELECT * FROM usuario WHERE correo = '" + correo + "';";

		rs = Conector.getConector().ejecutarSQL(sql, true);

		while (rs.next()) {
			usuario = new Usuario(rs.getString("nombre"), rs.getString("apellido"), rs.getString("grupo"),
					rs.getString("correo"), rs.getString("contrasenna"));
		}

		return usuario;
	}

}
