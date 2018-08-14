package com.cenfotec.proyecto.fabrica;

import com.cenfotec.proyecto.gestores.GestorHistorial;
import com.cenfotec.proyecto.gestores.GestorProceso;
import com.cenfotec.proyecto.gestores.GestorTarea;
import com.cenfotec.proyecto.gestores.GestorUsuario;

public class FabricaGestores {
	public static InterfaceGestores instanciarGestores(TiposGestor pTGestor) {
		switch(pTGestor) {
		case GHISTORIAL:
			return new GestorHistorial();
		case GPROCESO:
			return new GestorProceso();
		case GTAREA:
			return new GestorTarea();
		case GUSUARIO:
			return new GestorUsuario();
		default:
			return null;
		}
	}
}