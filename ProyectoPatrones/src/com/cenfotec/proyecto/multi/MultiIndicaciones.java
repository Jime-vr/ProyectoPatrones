package com.cenfotec.proyecto.multi;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cenfotec.proyecto.acceso.Conector;
import com.cenfotec.proyecto.clases.Tarea;

public class MultiIndicaciones {
	
	public static boolean crearIndicacion(String nombreProceso, String indicacion, String titulo) throws Exception{
        boolean creado = false;    
        String sql = "INSERT INTO indicacion (nomProceso, indicacion, titulo) VALUES ('"+nombreProceso+"', '"+indicacion+"', '"+titulo+"');";
		
        try{
            Conector.getConector().ejecutarSQL(sql);
            creado = true;
            
        }catch(Exception e){
            throw new Exception(e);
        }
        return creado;
    }

	public static ArrayList<String> obtenerIndicaciones(String nomProceso, String titulo) throws SQLException, Exception {
		ArrayList<String> indicaciones = new ArrayList<String>();
		String indicacion = "";
        String sql;
        java.sql.ResultSet rs;
        
        sql="SELECT indicacion FROM indicacion WHERE nomProceso='" + nomProceso + "' AND titulo= '"+ titulo +"';";
        
        rs=Conector.getConector().ejecutarSQL(sql,true);
        
        while (rs.next()){ 
        	indicacion = rs.getString("indicacion");
        	indicaciones.add(indicacion);
        }
        
    return indicaciones;
    }
	
	

	
	
	
	
}
