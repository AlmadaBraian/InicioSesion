package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.Conexion;

public class Consultas extends Conexion{
	
	public static boolean autenticacion(String usuario,String contrasenia) throws ClassNotFoundException, SQLException {
		Connection conexion=Conexion.crearConexion();
		PreparedStatement statement = null;
		ResultSet resultado=null;
		try {
			conexion.setAutoCommit(false);
			
			String comando = "select * from users where nombreusuario=? and contrasenia=? ";
			statement=conexion.prepareStatement(comando);
			statement.setString(1, usuario);
			statement.setString(2, contrasenia);

			resultado=statement.executeQuery();
			
			if(resultado.next()) {
				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			conexion.rollback();
			e.printStackTrace();
		}
		conexion.commit();
		statement.close();
		conexion.close();

		return false;
	}
}
