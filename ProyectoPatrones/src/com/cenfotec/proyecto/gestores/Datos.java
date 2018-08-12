package com.cenfotec.proyecto.gestores;

import java.io.IOException;

import com.cenfotec.proyecto.fabrica.FabricaGestores;
import com.cenfotec.proyecto.fabrica.TiposGestor;

public class Datos {
	static GestorHistorial gH = (GestorHistorial) FabricaGestores.instanciarGestores(TiposGestor.GHISTORIAL);
	static GestorProceso gP = (GestorProceso) FabricaGestores.instanciarGestores(TiposGestor.GPROCESO);
	static GestorTarea gT = (GestorTarea) FabricaGestores.instanciarGestores(TiposGestor.GTAREA);
	static GestorUsuario gU = (GestorUsuario) FabricaGestores.instanciarGestores(TiposGestor.GUSUARIO);
	public void quemaDeDatos() throws IOException {
		gU.quemarDatos();
		gT.quemarDatos();
		gP.quemarDatos();
	}
}
