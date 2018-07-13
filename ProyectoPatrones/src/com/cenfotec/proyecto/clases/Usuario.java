package com.cenfotec.proyecto.clases;

public class Usuario {
	private String nombre;
	private String apellido;
	private String grupo;
	private String correo;
	private String contrasenna;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String apellido, String grupo, String correo, String contrasenna) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.grupo = grupo;
		this.correo = correo;
		this.contrasenna = contrasenna;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenna() {
		return contrasenna;
	}
	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
}
