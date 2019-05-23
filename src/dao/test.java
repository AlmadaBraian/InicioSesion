package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Usuario.Usuario;
import conexion.Conexion;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario usuario=new Usuario(1, "pedorro", "cacona", "cacona", "cacona",
				"cacona");

		System.out.println(usuario.getNombreUsuario());
		try {
			//Connection conexion = Conexion.crearConexion();
			//conexion.setAutoCommit(false);
			//PreparedStatement statement;
			//String sql=" Insert into users (nombreusuario,contrasenia,correo,nombre,apellido) values (?,?,?,?,?)";
			//statement=conexion.prepareStatement(sql);
			//statement.setString(1, usuario.getNombreUsuario() );
			//statement.setString(2, usuario.getContrasenia() );
			//statement.setString(3, usuario.getCorreo() );
			//statement.setString(4, usuario.getNombre() );
			//statement.setString(5, usuario.getApellido() );
			
			//statement.executeUpdate();
			
			//conexion.commit();
			//statement.close();
			//conexion.close();
			System.out.println(UsuarioDAO.guardar(usuario));
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
