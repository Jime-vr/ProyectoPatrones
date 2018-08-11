/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author silviabolanos
 */
public class Conector {
    //atributo de la clase	
	private static AccesoBD conectorBD = null;
	
	/**
	 *Metodo estatico que devuelve el 
	 *objeto AccesoBD para que sea utilizado
	 *por las clases
	 *@return objeto del tipo AccesoBD del paquete 
	 *CapaAccesoDatos
	 */
	 
public static AccesoBD getConector()throws java.sql.SQLException,Exception
    {
        try
        {
            java.io.FileReader reader = new java.io.FileReader("conexion.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String conexion = "";
            String driver="";
            int info= 0;
            String[] infotxt= new String[2];
            
            //el bufferedReader extrae cada línea, y verrifica si el resultado es nulo. Si es nulo 
             //es que ya llegó al final del texto.
            //De ahi la condición del ciclo while.
            //while((datos = buffer.readLine()) != null) // Ciclo que imprime cada una de las lineas, 
            //      infotxt[info]= datos;
            //info++;
            
           conexion = infotxt[0];
           driver = infotxt[1];
            
          System.out.println(conexion); 
          reader.close();//se cierra el reader.
          
        if(conectorBD==null){
        conectorBD = new AccesoBD("com.mysql.cj.jdbc.Driver" ,"jdbc:mysql://localhost/patrones_prototipo?user=root&password=");
        }
          
        }
        catch(IOException e)
        {
            e.printStackTrace();//se imprime la pila de llamadas para ver dónde está el error.
        }
        return conectorBD;
    }


}
	

 /*       
        public static AccesoBD getConector() throws java.sql.SQLException,Exception{
		if(conectorBD==null){
			conectorBD = new AccesoBD("com.mysql.cj.jdbc.Driver"
					,"jdbc:mysql://localhost/prueba?user=root&password=");
		}

		return conectorBD;
	}
 */
        
  /*
        public static AccesoBD getConector() throws java.sql.SQLException,Exception{
  if(conectorBD==null){
                String conexion = obtenerConexion();
                        conectorBD = new AccesoBD(conexion);
  }
  return conectorBD;
 }

        public static String obtenerConexion() throws FileNotFoundException, IOException{
        
            java.io.FileReader reader = new java.io.FileReader("Conexion.txt");
            BufferedReader buffer = new BufferedReader(reader);
        try {
            String conexion="";
            String datos;
            StringBuilder sb = new StringBuilder();
            String line = buffer.readLine();

            while ((datos = buffer.readLine())!= null) {
                conexion = datos;
                
            }
            return conexion;
        } finally {
            buffer.close();
        }
        
        }
        */
        
        

