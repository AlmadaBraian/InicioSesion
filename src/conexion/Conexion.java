package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	 static final String URL = "jdbc:postgresql://localhost:5432/usuarios"; 
	 static final String USER = "postgres"; 
	 static final String PASS = "ComproMiso15";
	 static Connection conexion;
	 
	 public static Connection crearConexion()
			throws ClassNotFoundException, SQLException{ Class.forName("org.postgresql.Driver"); 
			try {
				conexion = DriverManager.getConnection(URL, USER, PASS); 
				 if (conexion != null){ 
					 System.out.print("Conexion establecida...");
					 return conexion; 
				} 
			}catch (SQLException e) {
				conexion.rollback();
				e.printStackTrace();
				
			}

			 return null; }


				 
} 
