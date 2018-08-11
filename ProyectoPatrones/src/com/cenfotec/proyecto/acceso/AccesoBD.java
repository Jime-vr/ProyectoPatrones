/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.*;
/**
 *
 * @author silviabolanos
 */

public class AccesoBD {
    //atributos del objeto
	private Connection conn=null;
	private Statement st;
        
        //private String driver = "com.mysql.jdbc.mysql-connector-java-6.0.5-bin";
        //private String conexion = ;

    
        
	/**
     * @param driver
	 *@param conexion cadena de conexi�n con la
	 *base de datos
	 *@param usuario nombre del usuario de la base 
	 *de datos, si no se utiliza, se debe enviar
	 *un string vac�o
	 *@param clave palabra clave del usuario
	 *para realizar su autenticaci�n en la base
	 *de datos
	 */
//	public AccesoBD(String driver, String conexion,	String usuario, String clave) throws SQLException,Exception{
//		Class.forName(driver);
//		conn = DriverManager.getConnection(conexion, usuario, clave);
//		st = conn.createStatement();
//	}
public AccesoBD (){
}
	


        public AccesoBD(String driver,String conexion) throws SQLException,Exception{
		Class.forName(driver);
		conn = DriverManager.getConnection(conexion);
		st = conn.createStatement();
	}
	

	public void ejecutarSQL(String sentencia) 
	throws SQLException,Exception{	
		st.execute(sentencia);		
	}	
        
	public ResultSet ejecutarSQL(String sentencia, boolean retorno)
	throws SQLException,Exception{
		ResultSet rs;
		rs = st.executeQuery(sentencia);
		return rs;
	}
	 
	protected void finalize(){
		try {
			conn.close();	
		}
		catch(Exception e){
			/*este m�todo es llamado por el
			 *garbage collector, por lo tanto
			 *se atrapa la excepci�n pero no se
			 *reporta*/			
		}
	}
}
