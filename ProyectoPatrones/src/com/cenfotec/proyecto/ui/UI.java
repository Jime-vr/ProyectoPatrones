package com.cenfotec.proyecto.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import com.cenfotec.proyecto.clases.*;
import com.cenfotec.proyecto.gestores.*;
import com.cenfotec.proyecto.multi.Multi;
import com.cenfotec.proyecto.multi.MultiUsuario;


/*OBSERVACIONES
 * -El gestor puede declararse de forma global
 * -A la hora de mostrar los menus, en ves de hacerlos en m�todos aparte, se pudo hacer en el mismo
 * -Cuando se realizan los procesos, hacerlo en metodos m�s espec�ficos
 * */

public class UI {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;
	static GestorTarea gestorTarea = new GestorTarea();
	static Usuario usuario = new Usuario();
	static Tarea tarea = new Tarea();
	static Proceso proceso = new Proceso();
	static GestorHistorial gestorH = new GestorHistorial();
	static GestorProceso gestorP = new GestorProceso();
	static GestorUsuario gestorUsuario = new GestorUsuario();
	
	
	/* Se ingresan los datos para iniciar sesi�n */
	public static void main(String[] args) throws Exception {
		
		MultiUsuario m = new MultiUsuario();
		menuInicial();

	}

	static void menuInicial() throws Exception {

		String correo, contrasenna;
		boolean iniciar = false;

		do {
			out.println("<---- Iniciar sesi�n ---->");
			out.println("");
			out.println("Digite su correo electr�nico");
			correo = in.readLine();
			out.println("Digite su contrase�a");
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

	/* Redirecciona al usuario dependiendo del grupo al que pertenezca */
	static void mostrarMenuGrupo(String pCorreo) throws Exception {
		Usuario usuario;

		usuario = gestorUsuario.obtenerUsuario(pCorreo);

		if (usuario.getGrupo().equals("administrador")) {// Validar grupo en InicioSesion
			verMenuAdministrador();
		} else {
			verMenuGrupo(pCorreo);
		}
	}// InicioSesion?

	/* Devuelve al usuario de acuerdo al correo con el que se inici� sesi�n */

	/* Muestra el men� del usuario administrador */
	static void verMenuAdministrador() throws Exception {
		int opc;
		boolean noSalir = true;
		String[] listaMenu = { "<---- Men� manejo de procesos ---->", " ", "1.  Crear proceso", "2.  Registrar usuario",
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

	/* Muestra el men� para los dem�s grupos --- (Se puede hacer diferente) */
	static void verMenuGrupo(String pCorreo) throws Exception {

		int opc = -1;
		boolean noSalir = true;

		
		do {

			out.println("<---- Men� de ejecuci�n de procesos ---->");
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
			out.println(" La opcion ingresada fue " + opc);
			out.println();
			noSalir = ejecutarMenuGrupo(opc, pCorreo);

		} while (noSalir);


		if (noSalir == false) {
			main(null);
		}
	}// Modificar metodo

	public static int recOpc(String pCorreo) throws IOException {

		int opc;
		opc = Integer.parseInt(in.readLine());
		ejecutarMenuGrupo(opc, pCorreo);
		return opc;

	}

	/* Imprime el arreglo del men� */
	static void mostrarMenu(String[] plista) {

		out.println();

		for (int i = 0; i < plista.length; i++) {
			out.println(plista[i]);
		}
		out.println();
	}// eliminar metodo luego de modificar el verMenuGrupo

	/* Se ingresa la opci�n deseada y la retorna */
	static int leerOpcion() throws java.io.IOException {

		int opcion;

		out.print("Seleccione su opci�n: ");
		opcion = Integer.parseInt(in.readLine());
		out.println();

		return opcion;
	}

	/* Ejecuta los metodos de acuerdo a la opci�n ingresada por el administrador */
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
			out.println(gestorH.verHistorial()); 
			break;

		case 4:
			noSalir = false;
			// correoUsuario = "";
			break;

		default:
			out.println("Opcion invalida");
			out.println();
			break;
		}

		return noSalir;
	}// Enviar a clase MenuDeSistema

	/* Ejecuta los metodos de acuerdo a la opci�n ingresada por el usuario */
	static boolean ejecutarMenuGrupo(int popcion, String pCorreo) throws java.io.IOException {
		boolean noSalir = true;
		int num = 0;

		switch (popcion) {

		case 1:
			ejecutarProceso(pCorreo);
			break;

		case 2:
			num = verProcesos(pCorreo);
			break;

		case 3:
			noSalir = false;
			// correoUsuario = "";
			break;

		default:
			out.println("Opcion invalida");
			out.println();
			break;
		}

		return noSalir;
	}// Enviar a clase MenuDeSistema

	/* Se crea un proceso */
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
		
		
	}// Enviar a Proceso

	/* Se crean las partes de una tarea y retorna una lista de tareas */// *************************************************

	public static void contruirTarea(int pCantTareas, String nomProceso) throws java.io.IOException {
		String titTarea, grupo;
		int resInd;

		for (int i = 0; i < pCantTareas; i++) {

			out.println("Indique el t�tulo de la tarea " + (i + 1));
			titTarea = in.readLine();

			out.println("Indique el grupo responsable de la tarea " + (i + 1));
			grupo = in.readLine();

			do {
				out.println("�Desea ingresar un formulario o una pregunta a la tarea " + (i + 1) + " ?");
				out.println("Digite 1 para formulario � 2 para pregunta");
				resInd = Integer.parseInt(in.readLine());

				if (!(resInd > 2 || resInd < 0)) {

					crearIndicaciones(resInd, i, nomProceso, titTarea);
					
				} else {
					out.println("Opci�n incorrecta, por favor digite 1 para formulario � 2 para pregunta");
				}
			} while (resInd > 2 || resInd < 0);


			grupo = grupo.toLowerCase();
			
			gestorTarea.crearTarea(nomProceso, titTarea, grupo);

		}

	}

	/* Se crean las indicaciones para la tarea y se devuelve un arreglo de estas */
	static void crearIndicaciones(int pRestIndi, int pI, String nomProceso, String titTarea) throws java.io.IOException {
		int cantDatos;
		String indicacion, resPregunta;
		ArrayList<String> listaIndicaciones = new ArrayList<String>();

		if (pRestIndi == 1) {
			out.println("Indique la cantidad de datos que desea agregar al formulario");
			cantDatos = Integer.parseInt(in.readLine());

			for (int j = 0; j < cantDatos; j++) {
				out.println("Digite la indicaci�n del dato " + (j + 1));
				indicacion = in.readLine();

				GestorTarea.crearIndicacion(nomProceso, indicacion, titTarea);
			}
		} else {
			out.println("Digite la pregunta de la tarea " + (pI + 1));
			resPregunta = in.readLine();

			GestorTarea.crearIndicacion(nomProceso, resPregunta, titTarea);
		}

	}// *********************************************************************************************************************

	/* Se registran los datos de un nuevo usuario */
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
				out.println("Digite el correo electr�nico del usuario");
				correo = in.readLine();

				errorC = gestorUsuario.validarCorreo(correo);

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
				out.println("Dej� datos en blanco; Por favor digite los datos correctamente");
			}
		} while (error);

		gestorUsuario.crearUsuario(nombre, apellido, grupo, correo, contrasenna);
	}

	/* Se validan los datos del usuario */
	static boolean validarDatosUsuario(String[] pDatos) throws java.io.IOException {
		boolean error = false;

		for (int i = 0; i < pDatos.length; i++) {
			if (pDatos[i].equals("") || pDatos[i].equals(" ")) {
				error = true;
			}
		}

		return error;
	}

	/*
	 * Se selecciona el proceso para ejecutar la tarea de acuerdo al grupo que
	 * pertenece el usuario
	 */
	static void ejecutarProceso(String pCorreo) throws java.io.IOException {
		int cantProc = 0;
		ArrayList<String> indicacion;
		String titulo, nomProceso;

		cantProc = verProcesos(pCorreo);

		if (cantProc > 0) {
			out.println("Ingrese el nombre de la tarea que desea realizar");
			titulo = in.readLine();
			out.println("Ingrese el nombre del proceso que desea realizar");
			nomProceso = in.readLine();
			indicacion = seleccionarProceso(titulo, nomProceso);
			completarTarea(titulo, nomProceso, indicacion);
		}
	}

	/*
	 * Se muestran los procesos y las tareas de acuerdo al grupo que pertenece el
	 * usuario
	 */
	static int verProcesos(String pCorreo) throws java.io.IOException {
		
		Usuario usuario = gestorUsuario.obtenerUsuario(pCorreo);
		ArrayList<Tarea> listaTareas = gestorTarea.obtenerTareas(usuario.getGrupo());
		
		int contador = 0;
		
		for (int i = 0; i < listaTareas.size(); i++) {
			out.println("Proceso: " + listaTareas.get(i).getNomProceso());
			out.println("Tarea: " + listaTareas.get(i).getTitulo());
			out.println("");
			out.println("<---------------------->");
			contador++;
			
		}
		
		if (contador == 0) {
			out.println("");
			out.println("No hay tareas de procesos a ejecutar disponibles");
			out.println("");
		}
		
		return contador;
		
	}

	/*
	 * Se selecciona el proceso de acuerdo a la tarea del grupo seleccionado por el
	 * usuario
	 */
	static ArrayList<String> seleccionarProceso(String nomProceso, String titulo)  {
		
		ArrayList<String> indicacion = gestorTarea.obtenerIndicaciones(nomProceso, titulo);
		return indicacion;
		
	}// Enviar a Proceso

	/* Se ejecuta la tarea de acuerdo al grupo del usuario */
	static void completarTarea(String titulo, String nomProceso, ArrayList<String> indicaciones) throws java.io.IOException {
		
	
		
		String respuesta = "";

		for (int i = 0; i < indicaciones.size(); i++) {
			out.println(indicaciones.get(i));
			respuesta = in.readLine();
			
			gestorTarea.crearRespuesta(nomProceso,respuesta,titulo);
		}


	}// Enviar a Tarea
}