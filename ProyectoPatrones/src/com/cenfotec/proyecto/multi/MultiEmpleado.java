package prototipo.patrones;
import java.sql.SQLException;
import java.util.Vector;

import bd.Conector;

public class MultiEmpleado {

   // C
	
	public void cambiarAutorizacion(String usuario, String autorizacion) throws Exception {
		
        String sql;
        
        sql = "UPDATE `Empleado` SET `autorizacion`= '"+autorizacion+"' WHERE `usuario`= '"+usuario+"';";
        
  
        try{
            Conector.getConector().ejecutarSQL(sql);
            
        }catch(Exception e){
            throw new Exception(e);
        }
	}
	
	
	
	public void cambiarEstado(String usuario, String estado) throws Exception {
		
        String sql;
        
        sql = "UPDATE `Empleado` SET `estado`= '"+estado+"' WHERE `usuario`= '"+usuario+"';";
        
  
        try{
            Conector.getConector().ejecutarSQL(sql);
            
        }catch(Exception e){
            throw new Exception(e);
        }
	}
	
	public void crearEmpleado(String nombre, String apellido, int cedula, String usuario, String clave, String estado, String autorizacion) throws Exception{
        
        String sql;
        
        sql = "INSERT INTO `Empleado`"
        	+"(`cedula`, `clave`, `usuario`, `estado`, `nombre`, `apellido`, `autorizacion`)" 
        	+ "VALUES ('"+cedula+"','"+clave+"','"+usuario+"','"+estado+"','"+nombre+"','"+apellido+"','"+autorizacion+"');";
        
  
        try{
            Conector.getConector().ejecutarSQL(sql);
            
        }catch(Exception e){
            throw new Exception(e);
        }

    }
	
	
	// H
    public Vector<Empleado> historialEmpleadosPendientes(String autorizacion)throws java.sql.SQLException,Exception{
        String sql;
        java.sql.ResultSet rs;
        Empleado empleado= null;
        Vector<Empleado> empleados = null;

        
        empleados=null;
        
		sql = "SELECT "
				+ "`cedula`, `clave`, `usuario`, `estado`, `nombre`, `apellido`, `autorizacion` "
				+ "FROM `Empleado` "
				+ "WHERE `autorizacion` = '"+autorizacion+"';";
        
        
        rs = Conector.getConector().ejecutarSQL(sql,true);
      
        empleados = new Vector<Empleado>();
        while (rs.next()) {
            empleado = new Empleado (rs.getString("nombre"), 
            		rs.getString("apellido"),
            		rs.getInt("cedula"), 
            		rs.getString("usuario"), 
            		rs.getString("clave"), 
            		rs.getString("estado"),
            		rs.getString("autorizacion"));
            		empleados.add(empleado);
                 
        }
        
        return empleados;
    }
	
	
	
	// I
	
	public Empleado informacionEmpleado(String usuario) throws SQLException, Exception {
		
		String sql;
		java.sql.ResultSet rs;
		Empleado emp = null;
		
		sql = "SELECT "
				+ "`cedula`, `clave`, `usuario`, `estado`, `nombre`, `apellido`, `autorizacion` "
				+ "FROM `Empleado` "
				+ "WHERE `usuario` = '"+usuario+"';";
		
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		while (rs.next()){
            emp = new Empleado (rs.getString("nombre"), 
			            		rs.getString("apellido"),
			            		rs.getInt("cedula"), 
			            		rs.getString("usuario"), 
			            		rs.getString("clave"), 
			            		rs.getString("estado"),
			            		rs.getString("autorizacion"));
        } 
		
		return emp;
	}
	
	// V
	
    public boolean validarEmpleado(String usuario)throws java.sql.SQLException,Exception{
        boolean existe = false;
        String sql;
        java.sql.ResultSet rs;
        sql="SELECT * FROM Empleado WHERE usuario='" + usuario+"';";
        
        rs=Conector.getConector().ejecutarSQL(sql,true);
        
        if (rs.next()){ 
            existe =true;
	}
        
    return existe;
    }
    
    public boolean validarEmpleadoClave(String usuario,String clave)throws java.sql.SQLException,Exception{
        boolean existe = false;
        String sql;
        java.sql.ResultSet rs;
        sql="SELECT * FROM Empleado WHERE usuario='" + usuario+ "' AND clave= '"+ clave +"';";
        
        rs=Conector.getConector().ejecutarSQL(sql,true);
        
        if (rs.next()){ 
            existe =true;
	}
        
    return existe;
    }
    
    public int validarEmpleadoDepartamento(String usuario,int id_departamento)throws java.sql.SQLException,Exception{
        int dep = -1;;
        String sql;
        java.sql.ResultSet rs;
        
        sql="SELECT * FROM Empleado_Departamento WHERE usuario='" + usuario + "' AND id_departamento= '"+ id_departamento +"';";
        
        rs=Conector.getConector().ejecutarSQL(sql,true);
        
        if (rs.next()){ 
        	dep = Integer.parseInt(rs.getString("id_departamento"));
	}
        
    return dep;
    }
    
}
