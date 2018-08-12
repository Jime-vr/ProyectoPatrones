package com.cenfotec.proyecto.gestores;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.cenfotec.proyecto.clases.Historial;
import com.cenfotec.proyecto.fabrica.InterfaceGestores;

public class GestorHistorial implements InterfaceGestores{

	private static ArrayList<Historial> listaHistorial = new ArrayList<Historial>();

	public ArrayList<Historial> getListaHistorial() {
		return listaHistorial;
	}

	public static void setListaHistorial(ArrayList<Historial> listaHistorial) {
		GestorHistorial.listaHistorial = listaHistorial;
	}

	public static Historial registrarHistorial(String pNomProceso, String pTituloTarea, String pAutor) throws java.io.IOException {
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
		return historial;
	}
	
	public String verHistorial() throws java.io.IOException {

		String info = "";
		
		ArrayList<Historial> listaHistorial = getListaHistorial();
		Historial historial;

		if (listaHistorial.size() != 0) {
			for (int i = 0; i < listaHistorial.size(); i++) {
				historial = listaHistorial.get(i);
				info += historial.toString() + "/n";
			}
		} else {
			info =  "No se han ejecutado procesos";
		}
		return info;
	}

	@Override
	public void quemarDatos() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
