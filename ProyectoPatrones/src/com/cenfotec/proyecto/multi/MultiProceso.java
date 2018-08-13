package com.cenfotec.proyecto.multi;

import java.util.ArrayList;

import com.cenfotec.proyecto.acceso.Conector;
import com.cenfotec.proyecto.clases.Proceso;
import com.cenfotec.proyecto.clases.Usuario;

public class MultiProceso {
	public static boolean crearProceso(String nombre) throws Exception{
        boolean creado = false;    
        String sql = "INSERT INTO proceso (nomProceso, indice) VALUES ('"+nombre+"', 0);";
		
        try{
            Conector.getConector().ejecutarSQL(sql);
            creado = true;
            
        }catch(Exception e){
            throw new Exception(e);
        }
        return creado;
    }


}
