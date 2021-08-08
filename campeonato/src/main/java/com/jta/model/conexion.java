package com.jta.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class conexion 
{

	private static Connection cnx = null;
	public static Connection obtener() throws SQLException,  ClassNotFoundException 
	{
		
		
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				String url = "jdbc:mysql://127.0.0.1:3306/bd_campeonato?serverTimezone=" + TimeZone.getDefault().getID();
				cnx = DriverManager.getConnection(url, "root", "Logimar0580");
			} 
			catch (SQLException ex) {
				throw new SQLException(ex);
			} catch (ClassNotFoundException ex) {
				throw new ClassCastException(ex.getMessage());
		//}
	}
	
		return cnx;
		
  }

	public static void cerrar() throws SQLException 
	{
		System.out.println("entro a cerrar la conexion");
		if (cnx != null) 
		{
			cnx.close();
		}
	}
	
}
