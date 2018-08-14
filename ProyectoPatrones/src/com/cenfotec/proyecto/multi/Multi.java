package com.cenfotec.proyecto.multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.cenfotec.proyecto.acceso.Conector;
import com.cenfotec.proyecto.clases.Usuario;

public class Multi {
	
	//public static ArrayList<String> datos = Conector.obtenerDatosAcceso();
	
	public static void dbSelect(String query) {
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_patrones", "root", "");
			
			System.out.println("Connection successful");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query); 
			
			while(rs.next()) {
				System.out.println("Name: " + rs.getString("nombre") + ". Apellido: " + rs.getString("apellido"));
			}
			
		}catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static void dbNonSelect(String query) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_patrones", "root", "");
				 
				//String query = "UPDATE usuario SET nombre = 'hola' Where nombre = 'silvi'";
						
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.executeUpdate();
	}
	
}
	