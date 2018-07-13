package com.cenfotec.proyecto.clases;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Gestor {

	private static ArrayList<Proceso> listaProcesos = new ArrayList<Proceso>();
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static ArrayList<Historial> listaHistorial = new ArrayList<Historial>();

	public Tarea crearTarea(String pTitTarea, String pGrupo, ArrayList<String> pListaIndicaciones)
			throws java.io.IOException {
		Tarea tarea = new Tarea();

		tarea.setTitulo(pTitTarea);
		tarea.setGrupoResponsable(pGrupo);
		tarea.setIndicaciones(pListaIndicaciones);

		return tarea;
	}

	public void crearProceso(String pNomProceso, ArrayList<Tarea> pListaTareas) {
		Proceso proceso = new Proceso();

		proceso.setNomProceso(pNomProceso);
		proceso.setTareas(pListaTareas);

		listaProcesos.add(proceso);

		System.out.println("El proceso se ha almacenado correctamente");
	}

	public void quemarDatos() throws java.io.IOException {

		/* Usuarios */
		Usuario usuario = new Usuario("Rafael", "Briceño", "Administrador", "rafa@gmail.com", "123");
		listaUsuarios.add(usuario);

		Usuario usuario2 = new Usuario("Luis", "Vargas", "Recursos", "luis@gmail.com", "456");
		listaUsuarios.add(usuario2);

		Usuario usuario3 = new Usuario("Juan", "Calderon", "Contaduría", "juan@gmail.com", "789");
		listaUsuarios.add(usuario3);

		Usuario usuario4 = new Usuario("Susana", "Zelaya", "Gerencia", "susana@gmail.com", "741");
		listaUsuarios.add(usuario4);

		/* Tareas del proceso Contratación */
		String titTar = "Formulario de empleado";
		String grupo = "Recursos";
		ArrayList<String> indicaciones1 = new ArrayList<String>();
		indicaciones1.add("Indique el nombre del empleado");
		indicaciones1.add("Indique el apellido del empleado");
		indicaciones1.add("Indique el correo del empleado");
		Tarea tarea1 = new Tarea();
		tarea1.setTitulo(titTar);
		tarea1.setGrupoResponsable(grupo);
		tarea1.setIndicaciones(indicaciones1);

		String titTar2 = "Asignación de salario";
		String grupo2 = "Contaduría";
		ArrayList<String> indicaciones2 = new ArrayList<String>();
		indicaciones2.add("Indique el monto salarial del empleado");
		Tarea tarea2 = new Tarea();
		tarea2.setTitulo(titTar2);
		tarea2.setGrupoResponsable(grupo2);
		tarea2.setIndicaciones(indicaciones2);

		String titTar3 = "Asignación de puesto";
		String grupo3 = "Gerencia";
		ArrayList<String> indicaciones3 = new ArrayList<String>();
		indicaciones3.add("Indique el puesto del empleado");
		Tarea tarea3 = new Tarea();
		tarea3.setTitulo(titTar3);
		tarea3.setGrupoResponsable(grupo3);
		tarea3.setIndicaciones(indicaciones3);

		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
		tareas.add(tarea1);
		tareas.add(tarea2);
		tareas.add(tarea3);

		/* Proceso Contratación */
		String nomProceso = "Contratación";

		Proceso proceso = new Proceso();
		proceso.setNomProceso(nomProceso);
		proceso.setTareas(tareas);

		listaProcesos.add(proceso);

		System.out.println("Listo!");
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

	public ArrayList<Proceso> getListaProcesos() throws java.io.IOException {
		return listaProcesos;
	}

	public Tarea actualizarTarea(Tarea pTarea, ArrayList<String> pRespuestas) throws java.io.IOException {
		pTarea.setRespuestas(pRespuestas);

		return pTarea;
	}

	public Proceso actulizarProceso(Proceso pProceso, ArrayList<Tarea> pListaTareas) throws java.io.IOException {
		int indice = pProceso.getIndiceTarea();
		pProceso.setIndiceTarea(indice + 1);
		pProceso.setTareas(pListaTareas);

		return pProceso;
	}

	public void actualizarListaProcesos(Proceso pProAct) throws java.io.IOException {
		String nomProAct = pProAct.getNomProceso();
		Proceso proceso = new Proceso();
		String nomPro;

		for (int i = 0; i < listaProcesos.size(); i++) {
			proceso = listaProcesos.get(i);
			nomPro = proceso.getNomProceso();

			if (nomProAct.equals(nomPro)) {
				listaProcesos.remove(i);
				listaProcesos.add(i, pProAct);
			}
		}

		/*
		 * Proceso procesopru = listaProcesos.get(0); ArrayList<Tarea> listatpru =
		 * procesopru.getTareas(); Tarea tareapru = listatpru.get(0); ArrayList<String>
		 * listaresp = tareapru.getRespuestas();
		 * 
		 * System.out.println(listaresp.get(0));
		 */

		System.out.println("La tarea se completó satisfactoriamente");
	}

	public void registrarHistorial(String pNomProceso, String pTituloTarea, String pAutor) throws java.io.IOException {
		String fecha, hora;
		int anno, dia, mes, minuto, horas, segundos;

		LocalDate fechaC = LocalDate.now();
		LocalTime horaC = LocalTime.now();

		anno = fechaC.getYear();
		dia = fechaC.getDayOfMonth();
		mes = fechaC.getMonthValue();

		fecha = anno + "-" + mes + "-" + dia;

		minuto = horaC.getMinute();
		horas = horaC.getHour();
		segundos = horaC.getSecond();

		hora = horas + ":" + minuto + ":" + segundos;

		Historial historial = new Historial(pNomProceso, pTituloTarea, pAutor, fecha, hora);
		listaHistorial.add(historial);
	}

	public ArrayList<Historial> getListaHistorial() throws java.io.IOException {
		return listaHistorial;
	}// pasar get a la BD

	/* Se valida que el correo no este repetido */
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

	/* Valida los datos ingresados para el inicio de sesión */
	public boolean iniciarSesion(String pCorreo, String pContrasenna) throws java.io.IOException {
		String correoUsuario = "";
		boolean iniciar = false;
		String correo, contrasenna;

		ArrayList<Usuario> listaUsuarios = getListaUsuarios();
		for (int i = 0; i < listaUsuarios.size(); i++) {

			correo = listaUsuarios.get(i).getCorreo();
			contrasenna = listaUsuarios.get(i).getContrasenna();

			if (pCorreo.equals(correo) && pContrasenna.equals(contrasenna)) {
				correoUsuario = correo;
				iniciar = true;
			}
		}

		return iniciar;
	}// Poner en clase InicioSesion?
	
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
	}// Usuario*
}
