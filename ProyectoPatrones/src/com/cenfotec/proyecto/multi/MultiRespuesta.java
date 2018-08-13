package com.cenfotec.proyecto.multi;

import com.cenfotec.proyecto.acceso.Conector;

public class MultiRespuesta {

	public static void crearRespuesta(String nomProceso, String respuesta, String titulo) {    
        String sql = "INSERT INTO respuesta (nomProceso, respuesta, titulo) VALUES ('"+nomProceso+"', '"+respuesta+"', '"+titulo+"');";
		
        try{
            Conector.getConector().ejecutarSQL(sql);
            
        }catch(Exception e){
            try {
				throw new Exception(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        
		
	}
	
	
}
