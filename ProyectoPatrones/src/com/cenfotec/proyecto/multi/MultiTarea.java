package com.cenfotec.proyecto.multi;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cenfotec.proyecto.acceso.Conector;
import com.cenfotec.proyecto.clases.Tarea;

public class MultiTarea {
	
	public static boolean crearTarea(String nombreProceso, String titulo, String grupo) throws Exception{
        boolean creado = false;    
        String sql = "INSERT INTO tarea (nomProceso, titulo, grupo, estado) VALUES ('"+nombreProceso+"', '"+titulo+"', '"+grupo+"' , 'false');";
		
        try{
            Conector.getConector().ejecutarSQL(sql);
            creado = true;
            
        }catch(Exception e){
            throw new Exception(e);
        }
        return creado;
    }

	public static ArrayList<Tarea> obtenerTareas(String grupo) throws Exception {
        String sql;
        java.sql.ResultSet rs;
        Tarea tarea= null;
        ArrayList<Tarea> tareas = null;

        
        tareas=null;
        
		sql = "SELECT * FROM tarea "
				+ "WHERE grupo = '"+grupo+"';";
        
        
        rs = Conector.getConector().ejecutarSQL(sql,true);
      
        tareas = new ArrayList<Tarea>();
        while (rs.next()) {
        	tarea = new Tarea (rs.getString("nomProceso"), 
        			rs.getString("titulo"),
        			rs.getString("grupo"),
            		rs.getString("estado"));
            tareas.add(tarea);
                 
        }
        
        return tareas;
	}

	public static void actualizarTarea(String nomProceso, String titulo) throws Exception {
        String sql;
        
        sql = "UPDATE tarea SET estado = 'true' WHERE nomProceso= '"+nomProceso+"' AND titulo = '"+titulo+"';";
        
  
        try{
            Conector.getConector().ejecutarSQL(sql);
            
        }catch(Exception e){
            throw new Exception(e);
        }
		
	}
}
