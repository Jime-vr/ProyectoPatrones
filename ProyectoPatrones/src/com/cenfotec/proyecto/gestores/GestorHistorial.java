package com.cenfotec.proyecto.gestores;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.cenfotec.proyecto.clases.Historial;
import com.cenfotec.proyecto.fabrica.InterfaceGestores;
import com.cenfotec.proyecto.multi.MultiHistorial;

public class GestorHistorial implements InterfaceGestores{

	private static ArrayList<Historial> listaHistorial = new ArrayList<Historial>();

	public ArrayList<Historial> getListaHistorial() {
		return listaHistorial;
	}

	public static void setListaHistorial(ArrayList<Historial> listaHistorial) {
		GestorHistorial.listaHistorial = listaHistorial;
	}

	public static void registrarHistorial(String pNomProceso, String pTituloTarea, String pAutor) throws java.io.IOException {
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

		try {
			MultiHistorial.crearHistorial(pNomProceso, pTituloTarea, pAutor, fecha, hora);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Historial> verHistorial() throws java.io.IOException {

		try {
			return MultiHistorial.historial();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void quemarDatos() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
