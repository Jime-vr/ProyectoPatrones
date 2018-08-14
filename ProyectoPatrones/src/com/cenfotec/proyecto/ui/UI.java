package com.cenfotec.proyecto.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.*;

import com.cenfotec.proyecto.clases.*;
import com.cenfotec.proyecto.fabrica.FabricaGestores;
import com.cenfotec.proyecto.fabrica.TiposGestor;
import com.cenfotec.proyecto.gestores.*;


public class UI {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;
	static Usuario usuario = new Usuario();
	static Tarea tarea = new Tarea();
	static Proceso proceso = new Proceso();
//	static GestorHistorial gestorH = new GestorHistorial();
//	static GestorProceso gestorP = new GestorProceso();
//	static GestorUsuario gestorUsuario = new GestorUsuario();
	
	static GestorHistorial gestorH = (GestorHistorial) FabricaGestores.instanciarGestores(TiposGestor.GHISTORIAL);
	static GestorProceso gestorP = (GestorProceso) FabricaGestores.instanciarGestores(TiposGestor.GPROCESO);
	static GestorTarea gestorTarea = (GestorTarea) FabricaGestores.instanciarGestores(TiposGestor.GTAREA);
	static GestorUsuario gestorUsuario = (GestorUsuario) FabricaGestores.instanciarGestores(TiposGestor.GUSUARIO);
	
	

	public static void main(String[] args) throws Exception {
		
		
		menuInicial();

	}

	static void menuInicial() throws Exception {

		String correo, contrasenna;
		boolean iniciar = false;

		do {
			
			out.println("<---- Iniciar sesión ---->");
			out.println("");
			out.println("Digite su correo electrónico");
			correo = in.readLine();
			out.println("Digite su contraseña");
			contrasenna = in.readLine();

			iniciar = gestorUsuario.iniciarSesion(correo, contrasenna);

			if (iniciar) {
				
				out.println("Bienvenido");
				mostrarMenuGrupo(correo);
				
			} else {
				
				out.println("Los datos ingresados son incorrectos");
				
			}
			
		} while (!iniciar);

	}

	static void mostrarMenuGrupo(String pCorreo) throws Exception {
		Usuario usuario;

		usuario = gestorUsuario.obtenerUsuario(pCorreo);

		if (usuario.getGrupo().equals("administrador")) {
			
			verMenuAdministrador();
			
		} else {
			
			verMenuGrupo(pCorreo);
			
		}
		
	}
	
	static void verMenuAdministrador() throws Exception {
		
		int opc;
		boolean noSalir = true;
		String[] listaMenu = { "<---- Menú manejo de procesos ---->", " ", "1.  Crear proceso", "2.  Registrar usuario",
				"3.  Ver historial", "4.  Salir", };

		do {
			
			mostrarMenu(listaMenu);
			opc = leerOpcion();
			noSalir = ejecutarMenuAdministrador(opc);
			
		} while (noSalir);
		if (noSalir == false) {
			main(null);
		}
	}

	
	static void verMenuGrupo(String pCorreo) throws Exception {

		int opc = -1;
		boolean noSalir = true;

		
		do {

			out.println("<---- Menú de ejecución de procesos ---->");
			out.println();
			out.println("1.  Ejecutar proceso.");
			out.println("2.  Ver procesos disponibles.");
			out.println("3.  Salir.");
			out.println();
			out.println(" Digite la opcion: ");
			out.println();
			out.println();
			opc = recOpc(pCorreo);
			out.println();
			out.println();
			noSalir = ejecutarMenuGrupo(opc, pCorreo);

		} while (noSalir);


		if (noSalir == false) {
			main(null);
		}
	}

	public static int recOpc(String pCorreo) throws IOException {

		int opc;
		opc = Integer.parseInt(in.readLine());
		ejecutarMenuGrupo(opc, pCorreo);
		return opc;

	}

	
	static void mostrarMenu(String[] plista) {

		out.println();
		
		List<String> list = Arrays.asList(plista);
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			out.println(iterator.next());
		}
		
		
		out.println();
	}
	static int leerOpcion() throws java.io.IOException {

		int opcion;

		out.print("Seleccione su opción: ");
		opcion = Integer.parseInt(in.readLine());
		out.println();

		return opcion;
	}

	
	static boolean ejecutarMenuAdministrador(int popcion) throws Exception {
		boolean noSalir = true;

		switch (popcion) {
		case 1:
			crearProceso();
			break;

		case 2:
			registrarUsuario();
			break;

		case 3:
			for(int i = 0; i < gestorH.verHistorial().size(); i++)
			out.println(gestorH.verHistorial().get(i).toString()); 
			break;

		case 4:
			noSalir = false;
			break;

		default:
			out.println("Opcion invalida");
			out.println();
			break;
		}

		return noSalir;
	}
	static boolean ejecutarMenuGrupo(int popcion, String pCorreo) throws java.io.IOException {
		boolean noSalir = true;
		

		switch (popcion) {

		case 1:
			ejecutarProceso(pCorreo);
			break;

		case 2:
			verProcesos(pCorreo);
			break;

		case 3:
			noSalir = false;
			
			break;

		default:
			out.println("Opcion invalida");
			out.println();
			break;
		}

		return noSalir;
	}
	static void crearProceso() throws Exception {
		String nomProceso;
		int cantTareas = 0;

		out.println("Indique el nombre del proceso que desea realizar");
		nomProceso = in.readLine();

		while (true) {

			try {
				out.println("Indique la cantidad de tareas que desea asignarle al proceso");
				cantTareas = Integer.parseInt(in.readLine());

				if (cantTareas <= 0) {

					continue;

				}else {
					
					break;
					
				}
			} catch (NumberFormatException e) {

				out.println("Ingresar numeros positivos");

			}
		}
		
		contruirTarea(cantTareas, nomProceso);

		gestorP.crearProceso(nomProceso);
		
		
	}


	public static void contruirTarea(int pCantTareas, String nomProceso) throws java.io.IOException {
		String titTarea, grupo;
		int resInd;

		for (int i = 0; i < pCantTareas; i++) {

			out.println("Indique el título de la tarea " + (i + 1));
			titTarea = in.readLine();

			out.println("Indique el grupo responsable de la tarea " + (i + 1));
			grupo = in.readLine();

			do {
				out.println("¿Desea ingresar un formulario o una pregunta a la tarea " + (i + 1) + " ?");
				out.println("Digite 1 para formulario ó 2 para pregunta");
				resInd = Integer.parseInt(in.readLine());

				if (!(resInd > 2 || resInd < 0)) {

					crearIndicaciones(resInd, i, nomProceso, titTarea);
					
				} else {
					out.println("Opción incorrecta, por favor digite 1 para formulario ó 2 para pregunta");
				}
			} while (resInd > 2 || resInd < 0);


			grupo = grupo.toLowerCase();
			
			gestorTarea.crearTarea(nomProceso, titTarea, grupo);

		}

	}

	
	static void crearIndicaciones(int pRestIndi, int pI, String nomProceso, String titTarea) throws java.io.IOException {
		int cantDatos;
		String indicacion, resPregunta;
		ArrayList<String> listaIndicaciones = new ArrayList<String>();

		if (pRestIndi == 1) {
			out.println("Indique la cantidad de datos que desea agregar al formulario");
			cantDatos = Integer.parseInt(in.readLine());

			for (int j = 0; j < cantDatos; j++) {
				out.println("Digite la indicación del dato " + (j + 1));
				indicacion = in.readLine();

				GestorTarea.crearIndicacion(nomProceso, indicacion, titTarea);
			}
		} else {
			out.println("Digite la pregunta de la tarea " + (pI + 1));
			resPregunta = in.readLine();

			GestorTarea.crearIndicacion(nomProceso, resPregunta, titTarea);
		}

	}

	
	static void registrarUsuario() throws java.io.IOException {
		String nombre, apellido, grupo, correo, contrasenna;
		boolean errorC = false;
		boolean error = false;

		do {
			out.println("Digite el nombre del usuario");
			nombre = in.readLine();

			out.println("Digite el apellido del usuario");
			apellido = in.readLine();

			out.println("Digite el grupo al que pertenece el usuario");
			grupo = in.readLine();

			do {
				out.println("Digite el correo electrónico del usuario");
				correo = in.readLine();

				errorC = gestorUsuario.validarCorreo(correo);
					out.println("errorc " + errorC);
				if (errorC) {
					out.println(
							"El correo que desea registrar ya pertenece a un usuario registrado; Por favor digite un correo diferente");
				}
			} while (errorC);

			out.println("Digite la contrasenna del usuario");
			contrasenna = in.readLine();

			grupo = grupo.toLowerCase();

			String[] datos = { nombre, apellido, grupo, correo, contrasenna };
			error = validarDatosUsuario(datos);

			if (error) {
				out.println("Dejó datos en blanco; Por favor digite los datos correctamente");
			}
		} while (error);

		gestorUsuario.crearUsuario(nombre, apellido, grupo, correo, contrasenna);
	}

	
	static boolean validarDatosUsuario(String[] pDatos) throws java.io.IOException {
		out.println("ENTRA validar datos");
		
		boolean error = false;
		
		for(int i = 0; i < pDatos.length; i++) {
			if (pDatos[i].equals("") || pDatos[i].equals(" ")) {
				error = true;
			}
		}
		
		return error;
	}

	
	static void ejecutarProceso(String pCorreo) throws java.io.IOException {
		int cantProc = 0;
		ArrayList<String> indicacion;
		String titulo, nomProceso;

		cantProc = verProcesos(pCorreo);

		if (cantProc > 0 ) {
			out.println("Ingrese el nombre de la proceso que desea realizar");
			nomProceso = in.readLine();
			out.println("Ingrese el nombre del tarea que desea realizar");
			titulo = in.readLine();
			indicacion = seleccionarProceso(nomProceso, titulo);
			completarTarea(titulo, nomProceso, indicacion, pCorreo);
		}
	}


	static int verProcesos(String pCorreo) throws java.io.IOException {		
		
		Usuario usuario = gestorUsuario.obtenerUsuario(pCorreo);
		ArrayList<Tarea> listaTareas = gestorTarea.obtenerTareas(usuario.getGrupo());
		
		Iterator<Tarea> iterator = listaTareas.iterator();
		
		int contador = 0;
		
		while(iterator.hasNext()) {
			
			Tarea tempTarea = iterator.next();
			
			if(tempTarea.getEstado().equals("false")) {
		
			out.println("Proceso: " + tempTarea.getNomProceso()); 
			out.println("Tarea: " + tempTarea.getTitulo());
			out.println("");
			out.println("<---------------------->");
			contador++;
			}
		}
		
		if (contador == 0) {
			out.println("");
			out.println("No hay tareas de procesos a ejecutar disponibles");
			out.println("");
		}
		
		return contador;
		
	}


	static ArrayList<String> seleccionarProceso(String nomProceso, String titulo)  {
		
		ArrayList<String> indicacion = gestorTarea.obtenerIndicaciones(nomProceso, titulo);
		return indicacion;
		
	}
	static void completarTarea(String titulo, String nomProceso, ArrayList<String> indicaciones, String pCorreo) throws java.io.IOException {
		
		String respuesta = "";
		
		Iterator<String> iterator = indicaciones.iterator();
		
		while(iterator.hasNext()) {
		
			out.println(iterator.next());
			respuesta = in.readLine();
			
			gestorTarea.actualizarTarea(nomProceso, titulo);
			
			gestorTarea.crearRespuesta(nomProceso,respuesta,titulo);
			
			GestorHistorial.registrarHistorial(nomProceso, titulo, pCorreo);
		}


	}
}