package com.cenfotec.proyecto.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import com.cenfotec.proyecto.clases.*;
import com.cenfotec.proyecto.fabrica.FabricaGestores;
import com.cenfotec.proyecto.fabrica.InterfaceGestores;
import com.cenfotec.proyecto.fabrica.TiposGestor;
import com.cenfotec.proyecto.gestores.*;

<<<<<<< HEAD
<<<<<<< HEAD
/*OBSERVACIONES
 * -El gestor puede declararse de forma global
 * -A la hora de mostrar los menus, en ves de hacerlos en métodos aparte, se pudo hacer en el mismo
 * -Cuando se realizan los procesos, hacerlo en metodos más específicos
 * */

=======
>>>>>>> Rafa_Bricenoa
=======
>>>>>>> josue_calderon
public class UI {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;
	static Usuario usuario = new Usuario();
	static Tarea tarea = new Tarea();
	static Proceso proceso = new Proceso();
<<<<<<< HEAD
	static GestorHistorial gestorH = new GestorHistorial();
	static GestorProceso gestorP = new GestorProceso();
	static GestorUsuario gestorUsuario = new GestorUsuario();

<<<<<<< HEAD
=======
	static InterfaceGestores intGest;
	static GestorHistorial gH = (GestorHistorial) FabricaGestores.instanciarGestores(TiposGestor.GHISTORIAL);
	static GestorProceso gP = (GestorProceso) FabricaGestores.instanciarGestores(TiposGestor.GPROCESO);
	static GestorTarea gT = (GestorTarea) FabricaGestores.instanciarGestores(TiposGestor.GTAREA);
	static GestorUsuario gU = (GestorUsuario) FabricaGestores.instanciarGestores(TiposGestor.GUSUARIO);
	
>>>>>>> Rafa_Bricenoa
	static {
		try {
			Datos datos = new Datos();
			datos.quemaDeDatos();
		} catch (IOException e) {
<<<<<<< HEAD
=======
	static {
		try {

			gestorUsuario.quemarDatosUsuario();

		} catch (IOException e) {
>>>>>>> josue_calderon

			e.printStackTrace();

		}

	}

<<<<<<< HEAD
	/* Se ingresan los datos para iniciar sesión */
	public static void main(String[] args) throws Exception {
=======
	public static void main(String[] args) throws Exception {

		menuInicial();
>>>>>>> josue_calderon

=======
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
>>>>>>> Rafa_Bricenoa
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
			iniciar = gU.iniciarSesion(correo, contrasenna);

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
<<<<<<< HEAD
		usuario = gU.obtenerUsuario(pCorreo);
		if (usuario.getGrupo().equals("administrador")) {// Validar grupo en InicioSesion
=======

		usuario = gestorUsuario.obtenerUsuario(pCorreo);

		if (usuario.getGrupo().equals("administrador")) {

>>>>>>> josue_calderon
			verMenuAdministrador();

		} else {

			verMenuGrupo(pCorreo);

		}
<<<<<<< HEAD
=======

>>>>>>> josue_calderon
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
<<<<<<< HEAD
		int opc = -1;
=======

		int opc;
>>>>>>> josue_calderon
		boolean noSalir = true;
<<<<<<< HEAD

<<<<<<< HEAD
=======
>>>>>>> Rafa_Bricenoa
=======
>>>>>>> josue_calderon
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
			noSalir = ejecutarMenuGrupo(opc, pCorreo);

		} while (noSalir);
<<<<<<< HEAD

<<<<<<< HEAD
=======
>>>>>>> Rafa_Bricenoa
=======
>>>>>>> josue_calderon
		if (noSalir == false) {

			main(null);

		}
<<<<<<< HEAD
=======

>>>>>>> josue_calderon
	}

	public static int recOpc(String pCorreo) throws IOException {
		int opc;
		opc = Integer.parseInt(in.readLine());
		ejecutarMenuGrupo(opc, pCorreo);
		return opc;
	}

	static void mostrarMenu(String[] plista) {
		out.println();
<<<<<<< HEAD

		List<String> list = Arrays.asList(plista);

		Iterator<String> iterator = list.iterator();

		while (iterator.hasNext()) {
			out.println(iterator.next());
		}

	}// eliminar metodo luego de modificar el verMenuGrupo
=======
		for (int i = 0; i < plista.length; i++) {

			out.println(plista[i]);

		}

		out.println();
<<<<<<< HEAD
	}
>>>>>>> Rafa_Bricenoa

=======

	}

>>>>>>> josue_calderon
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
			out.println(gH.verHistorial());
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
<<<<<<< HEAD
	}

=======

	}

>>>>>>> josue_calderon
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
		ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
		
		out.println("Indique el nombre del proceso que desea realizar");
		nomProceso = in.readLine();
		while (true) {
			try {

				out.println("Indique la cantidad de tareas que desea asignarle al proceso");
				cantTareas = Integer.parseInt(in.readLine());
				if (cantTareas <= 0) {
					continue;
<<<<<<< HEAD

				} else {

<<<<<<< HEAD
					break;

=======
				}else {
					break;
>>>>>>> Rafa_Bricenoa
=======
				} else {

					break;

>>>>>>> josue_calderon
				}

			} catch (NumberFormatException e) {
				out.println("Ingresar numeros positivos");
			}

		}
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> Rafa_Bricenoa
		listaTareas = contruirTarea(cantTareas);
		gP.crearProceso(nomProceso, listaTareas);
=======

		listaTareas = contruirTarea(cantTareas);

		gestorP.crearProceso(nomProceso, listaTareas);

>>>>>>> josue_calderon
	}

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
<<<<<<< HEAD
			} while (resInd > 2 || resInd < 0);
<<<<<<< HEAD

=======
>>>>>>> Rafa_Bricenoa
			grupo = grupo.toLowerCase();
			tarea = gT.crearTarea(titTarea, grupo, listaIndicaciones);
			listaTareas.add(tarea);
=======

			} while (resInd > 2 || resInd < 0);

			grupo = grupo.toLowerCase();
			tarea = gestorTarea.crearTarea(titTarea, grupo, listaIndicaciones);


			listaTareas.add(tarea);

		}
>>>>>>> josue_calderon

		}
		return listaTareas;
	}
<<<<<<< HEAD
	
<<<<<<< HEAD
	/* Se crean las indicaciones para la tarea y se devuelve un arreglo de estas */
=======
>>>>>>> Rafa_Bricenoa
=======

>>>>>>> josue_calderon
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
<<<<<<< HEAD
	}

=======
		
	}
>>>>>>> josue_calderon
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
				errorC = gU.validarCorreo(correo);
				if (errorC) {
<<<<<<< HEAD
=======
					
>>>>>>> josue_calderon
					out.println("El correo que desea registrar ya pertenece a un usuario registrado; Por favor digite un correo diferente");
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
		gU.crearUsuario(nombre, apellido, grupo, correo, contrasenna);
	}

	static boolean validarDatosUsuario(String[] pDatos) throws java.io.IOException {
		
		boolean error = false;
		for (int i = 0; i < pDatos.length; i++) {
			
			if (pDatos[i].equals("") || pDatos[i].equals(" ")) {
				error = true;
				
			}
			
		}
		return error;
	}

<<<<<<< HEAD
=======

>>>>>>> josue_calderon
	static void ejecutarProceso(String pCorreo) throws java.io.IOException {
		
		int cantProc = 0, opc;
		Proceso proceso;
		cantProc = verProcesos(pCorreo);
		if (cantProc > 0) {
			
			out.println("Seleccione el número del proceso que desea realizar");
			opc = Integer.parseInt(in.readLine());
			proceso = seleccionarProceso(opc, pCorreo);
<<<<<<< HEAD
			
			GestorTarea.completarTarea(proceso, pCorreo);
=======
			completarTarea(proceso, pCorreo);
			
>>>>>>> josue_calderon
		}
		
	}

<<<<<<< HEAD
	static int verProcesos(String pCorreo) throws java.io.IOException {
		Usuario usuario = gU.obtenerUsuario(pCorreo);
		ArrayList<Proceso> listaProcesos = gP.getListaProcesos();
		int indice, contador = 0;
=======

	static int verProcesos(String pCorreo) throws java.io.IOException {
		
		Usuario usuario = gestorUsuario.obtenerUsuario(pCorreo);
		ArrayList<Proceso> listaProcesos = gestorP.getListaProcesos();
		int indice = 0, contador = 0;
>>>>>>> josue_calderon
		ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
		String grupoUsuario, grupoTarea;
<<<<<<< HEAD
	

		Iterator<Proceso> iterator = listaProcesos.iterator();

		while (iterator.hasNext()) {

			proceso = iterator.next();
=======
		for (int i = 0; i < listaProcesos.size(); i++) {
			proceso = listaProcesos.get(i);
>>>>>>> Rafa_Bricenoa
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

	static Proceso seleccionarProceso(int opc, String pCorreo) throws java.io.IOException {
<<<<<<< HEAD
		ArrayList<Proceso> listaProcesos = gP.getListaProcesos();
=======
		
		ArrayList<Proceso> listaProcesos = gestorP.getListaProcesos();
>>>>>>> josue_calderon
		int indice, contador = 0;
		ArrayList<Tarea> listaTareas = new ArrayList<Tarea>();
		Usuario usuario = gU.obtenerUsuario(pCorreo);
		String grupoUsuario, grupoTarea;
		Proceso procesoSelec = new Proceso();
<<<<<<< HEAD
<<<<<<< HEAD
=======
		
>>>>>>> josue_calderon

=======
>>>>>>> Rafa_Bricenoa
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
<<<<<<< HEAD
	}

<<<<<<< HEAD
=======
=======
		
	}
>>>>>>> josue_calderon
	static void completarTarea(Proceso pProceso, String pCorreo) throws java.io.IOException {
		
		int indice = pProceso.getIndiceTarea();
		ArrayList<Tarea> listaTareas = pProceso.getTareas();
		Tarea tarea = listaTareas.get(indice);
		ArrayList<String> indicaciones = tarea.getIndicaciones();
		ArrayList<String> respuestas = new ArrayList<String>();
		Tarea tarAct = new Tarea();
		Proceso proAct = new Proceso();
		Usuario usuario = gU.obtenerUsuario(pCorreo);
		for (int i = 0; i < indicaciones.size(); i++) {
			
			out.println(indicaciones.get(i));
			respuestas.add(in.readLine());
			
		}
		tarAct = gT.actualizarTarea(tarea, respuestas);
		listaTareas.remove(indice);
		listaTareas.add(indice, tarAct);
		proAct = gP.actulizarProceso(pProceso, listaTareas);
		gP.actualizarListaProcesos(proAct);
		gH.registrarHistorial(pProceso.getNomProceso(), tarea.getTitulo(),
				usuario.getNombre() + " " + usuario.getApellido());
<<<<<<< HEAD
	}
>>>>>>> Rafa_Bricenoa
=======
		
	}
>>>>>>> josue_calderon
}