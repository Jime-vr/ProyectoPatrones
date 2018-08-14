package com.cenfotec.proyecto.multi;

import java.util.ArrayList;

import com.cenfotec.proyecto.acceso.Conector;
import com.cenfotec.proyecto.clases.Historial;

public class MultiHistorial {

	public static void crearHistorial(String nomProceso, String titulo, String pAutor, String fecha, String hora) throws Exception{
	      
	    String sql;
	    
	    sql = "INSERT INTO historial (nomProceso, titulo, autor, fecha, hora) "
	    	+ "VALUES ('"+nomProceso+"','"+titulo+"','"+pAutor+"','"+fecha+"','"+hora+"');";
	    
	
	    try{
	        Conector.getConector().ejecutarSQL(sql);
	        
	    }catch(Exception e){
	        throw new Exception(e);
	    }
	}

    public static ArrayList<Historial> historial()throws java.sql.SQLException,Exception{
        String sql;
        java.sql.ResultSet rs;
        Historial historal= null;
        ArrayList<Historial> historiales = null;

        
        historiales=null;
        
		sql = "SELECT * from historial";
        
        rs = Conector.getConector().ejecutarSQL(sql,true);
      
        historiales = new ArrayList<Historial>();
        while (rs.next()) {
        	historal = new Historial (rs.getString("nomProceso"), 
            		rs.getString("titulo"), 
            		rs.getString("autor"), 
            		rs.getString("fecha"), 
            		rs.getString("hora"));
        	historiales.add(historal);
                 
        }
        
        return historiales;
    }
}
