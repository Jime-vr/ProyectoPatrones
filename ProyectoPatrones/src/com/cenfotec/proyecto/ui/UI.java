package com.cenfotec.proyecto.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import com.cenfotec.proyecto.clases.Gestor;
import com.cenfotec.proyecto.clases.Historial;
import com.cenfotec.proyecto.clases.Proceso;
import com.cenfotec.proyecto.clases.Tarea;
import com.cenfotec.proyecto.clases.Usuario;

/*OBSERVACIONES
 * -El gestor puede declararse de forma global
 * -A la hora de mostrar los menus, en ves de hacerlos en métodos aparte, se pudo hacer en el mismo
 * -Cuando se realizan los procesos, hacerlo en metodos más específicos
 * */

public class UI {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;
	static Gestor gestor = new Gestor();
	static Usuario usuario = new Usuario();
	static Tarea tarea = new Tarea();
	static Proceso proceso = new Proceso();

	static {

		try {
			gestor.quemarDatos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* Se ingresan los datos para iniciar sesión */
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

			iniciar = gestor.iniciarSesion(correo, contrasenna);

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

		usuario = gestor.obtenerUsuario(pCorreo);

		if (usuario.getGrupo().equals("Administrador")) {// Validar grupo en InicioSesion
			verMenuAdministrador();
		} else {
			verMenuGrupo(pCorreo);
		}
	}// InicioSesion?

	/* Devuelve al usuario de acuerdo al correo con el que se inició sesión */

	/* Muestra el menú del usuario administrador */
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

	/* Muestra el menú para los demás grupos --- (Se puede hacer diferente) */
	static void verMenuGrupo(String pCorreo) throws java.io.IOException {

		/*
		 * int opc; boolean noSalir = true; String[] listaMenu = {
		 * "<---- Menú de ejecución de procesos ---->", " ", "1.  Ejecutar proceso",
		 * "2.  Ver procesos disponibles", "3.  Salir", };
		 * 
		 * do{ mostrarMenu(listaMenu); opc = leerOpcion(); noSalir =
		 * ejecutarMenuGrupo(opc); }while (noSalir); if(noSalir == false) { main(null);
		 * }
		 */

		int opc = -1;

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
			out.println(" La opcion ingresada fue " + opc);
			out.println();
		} while (opc != 3);
	}// Modificar metodo

	public static int recOpc(String pCorreo) throws IOException {

		int opc;
		opc = Integer.parseInt(in.readLine());
		ejecutarMenuGrupo(opc, pCorreo);
		return opc;

	}

	/* Imprime el arreglo del menú */
	static void mostrarMenu(String[] plista) {

		out.println();

		for (int i = 0; i < plista.length; i++) {
			out.println(plista[i]);
		}
		out.println();
	}// eliminar metodo luego de modificar el verMenuGrupo

	/* Se ingresa la opción deseada y la retorna */
	static int leerOpcion() throws java.io.IOException {

		int opcion;

		out.print("Seleccione su opción: ");
		opcion = Integer.parseInt(in.readLine());
		out.println();

		return opcion;
	}

	/* Ejecuta los metodos de acuerdo a la opción ingresada por el administrador */
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
			verHistorial(); // out.println(gestor.verHistorial()); CAMBIAR A ESTO
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

	/* Ejecuta los metodos de acuerdo a la opción ingresada por el usuario */
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
		ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();

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
		
		listaTareas = contruirTarea(cantTareas);

		gestor.crearProceso(nomProceso, listaTareas);
	}// Enviar a Proceso

	/* Se crean las partes de una tarea y retorna una lista de tareas */// *************************************************

	public static ArrayList<Tarea> contruirTarea(int pCantTareas) throws java.io.IOException {
		String titTarea, grupo;
		int resInd;
		ArrayList<String> listaIndicaciones = new ArrayList<String>();

		ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();

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

					listaIndicaciones = crearIndicaciones(resInd, i);
				} else {
					out.println("Opción incorrecta, por favor digite 1 para formulario ó 2 para pregunta");
				}
			} while (resInd > 2 || resInd < 0);

			tarea = gestor.crearTarea(titTarea, grupo, listaIndicaciones);
			listaTareas.add(tarea);
		}

		return listaTareas;
	}// Duda de que
		// hacer*****************************************************************************************************

	/* Se crean las indicaciones para la tarea y se devuelve un arreglo de estas */
	static ArrayList<String> crearIndicaciones(int pRestIndi, int pI) throws java.io.IOException {
		int cantDatos;
		String indiDato, resPregunta;
		ArrayList<String> listaIndicaciones = new ArrayList<String>();

		if (pRestIndi == 1) {
			out.println("Indique la cantidad de datos que desea agregar al formulario");
			cantDatos = Integer.parseInt(in.readLine());

			for (int j = 0; j < cantDatos; j++) {
				out.println("Digite la indicación del dato " + (j + 1));
				indiDato = in.readLine();

				listaIndicaciones.add(indiDato);
			}
		} else {
			out.println("Digite la pregunta de la tarea " + (pI + 1));
			resPregunta = in.readLine();

			listaIndicaciones.add(resPregunta);
		}

		return listaIndicaciones;
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
				out.println("Digite el correo electrónico del usuario");
				correo = in.readLine();

				errorC = gestor.validarCorreo(correo);

				if (errorC) {
					out.println(
							"El correo que desea registrar ya pertenece a un usuario registrado; Por favor digite un correo diferente");
				}
			} while (errorC);

			out.println("Digite la contrasenna del usuario");
			contrasenna = in.readLine();

			String[] datos = { nombre, apellido, grupo, correo, contrasenna };
			error = validarDatosUsuario(datos);

			if (error) {
				out.println("Dejó datos en blanco; Por favor digite los datos correctamente");
			}
		} while (error);

		gestor.crearUsuario(nombre, apellido, grupo, correo, contrasenna);
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
	}// Enviar a Usuario

	/*
	 * Se selecciona el proceso para ejecutar la tarea de acuerdo al grupo que
	 * pertenece el usuario
	 */
	static void ejecutarProceso(String pCorreo) throws java.io.IOException {
		int cantProc = 0, opc;
		Proceso proceso;

		cantProc = verProcesos(pCorreo);

		if (cantProc > 0) {
			out.println("Seleccione el número del proceso que desea realizar");
			opc = Integer.parseInt(in.readLine());
			proceso = seleccionarProceso(opc, pCorreo);
			completarTarea(proceso, pCorreo);
		}
	}

	static void verHistorial() throws java.io.IOException { // BORRAR

		ArrayList<Historial> listaHistorial = gestor.getListaHistorial();
		Historial historial;

		if (listaHistorial != null) {
			for (int i = 0; i < listaHistorial.size(); i++) {
				historial = listaHistorial.get(i);
				out.println("Se ejecutó el proceso: " + historial.getNomProceso());
				out.println("Se completó la tarea: " + historial.getTituloTarea());
				out.println("Por: " + historial.getAutor());
				out.println("La fecha: " + historial.getFecha());
				out.println("A la hora: " + historial.getHora());
				out.println("");
				out.println("<-------------------------------->");
				out.println("");
			}
		} else {
			out.println("No se han ejecutado procesos");
		}

	}

	/*
	 * Se muestran los procesos y las tareas de acuerdo al grupo que pertenece el
	 * usuario
	 */
	static int verProcesos(String pCorreo) throws java.io.IOException {
		Usuario usuario = gestor.obtenerUsuario(pCorreo);
		ArrayList<Proceso> listaProcesos = gestor.getListaProcesos();
		int indice, contador = 0;
		ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
		String grupoUsuario, grupoTarea;

		for (int i = 0; i < listaProcesos.size(); i++) {

			proceso = listaProcesos.get(i);
			indice = proceso.getIndiceTarea();

			listaTareas = proceso.getTareas();
			tarea = listaTareas.get(indice);

			grupoUsuario = usuario.getGrupo();
			grupoTarea = tarea.getGrupoResponsable();

			if (grupoUsuario.equals(grupoTarea)) {
				out.println("");
				out.println((contador + 1) + ".");
				out.println("Proceso: " + proceso.getNomProceso());
				out.println("Tarea: " + tarea.getTitulo());
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

	/*
	 * Se selecciona el proceso de acuerdo a la tarea del grupo seleccionado por el
	 * usuario
	 */
	static Proceso seleccionarProceso(int opc, String pCorreo) throws java.io.IOException {
		ArrayList<Proceso> listaProcesos = gestor.getListaProcesos();
		int indice, contador = 0;
		ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
		Usuario usuario = gestor.obtenerUsuario(pCorreo);
		String grupoUsuario, grupoTarea;
		Proceso procesoSelec = new Proceso();
		;

		for (int i = 0; i < listaProcesos.size(); i++) {
			proceso = listaProcesos.get(i);
			indice = proceso.getIndiceTarea();
			listaTareas = proceso.getTareas();
			tarea = listaTareas.get(indice);

			grupoUsuario = usuario.getGrupo();
			grupoTarea = tarea.getGrupoResponsable();

			if (grupoUsuario.equals(grupoTarea)) {

				if ((opc - 1) == contador) {
					procesoSelec = proceso;
				}

				contador++;
			}
		}

		return procesoSelec;
	}// Enviar a Proceso

	/* Se ejecuta la tarea de acuerdo al grupo del usuario */
	static void completarTarea(Proceso pProceso, String pCorreo) throws java.io.IOException {
		int indice = pProceso.getIndiceTarea();
		ArrayList<Tarea> listaTareas = pProceso.getTareas();
		Tarea tarea = listaTareas.get(indice);
		ArrayList<String> indicaciones = tarea.getIndicaciones();
		ArrayList<String> respuestas = new ArrayList<String>();
		Tarea tarAct = new Tarea();
		Proceso proAct = new Proceso();
		Usuario usuario = gestor.obtenerUsuario(pCorreo);

		for (int i = 0; i < indicaciones.size(); i++) {
			out.println(indicaciones.get(i));
			respuestas.add(in.readLine());
		}

		tarAct = gestor.actualizarTarea(tarea, respuestas);
		listaTareas.remove(indice);
		listaTareas.add(indice, tarAct);
		proAct = gestor.actulizarProceso(pProceso, listaTareas);
		gestor.actualizarListaProcesos(proAct);

		gestor.registrarHistorial(pProceso.getNomProceso(), tarea.getTitulo(),
				usuario.getNombre() + " " + usuario.getApellido());
	}// Enviar a Tarea
}