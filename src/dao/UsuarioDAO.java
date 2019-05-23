package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Usuario.Usuario;
import conexion.Conexion;

public class UsuarioDAO {
	private Connection conexion;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	public static boolean guardar(Usuario usuario,Connection conexion) throws SQLException, ClassNotFoundException {
		String sql=" Insert into users (idUsuario,nombreUsuario,contrasenia,correo,nombre,apellido) values (?,?,?,?,?,?)";
		boolean estadoOperacion=false;
		PreparedStatement statement;
		
		try {
			conexion.setAutoCommit(false);
			statement=conexion.prepareStatement(sql);
			statement.setInt(1, 1);
			statement.setString(2, usuario.getNombreUsuario() );
			statement.setString(3, usuario.getContrasenia() );
			statement.setString(4, usuario.getCorreo() );
			statement.setString(5, usuario.getNombre() );
			statement.setString(6, usuario.getApellido() );
			
			estadoOperacion=statement.executeUpdate()>0;
			
			conexion.commit();
			statement.close();
			conexion.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			conexion.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
		
	}
	
	public static boolean guardar(Usuario usuario) throws SQLException, ClassNotFoundException {
		String sql=" Insert into users (nombreUsuario,contrasenia,correo,nombre,apellido) values (?,?,?,?,?)";
		boolean estadoOperacion=false;
		PreparedStatement statement;
		Connection conexion = Conexion.crearConexion();
		try {
			
			conexion.setAutoCommit(false);
			statement=conexion.prepareStatement(sql);
			statement.setString(1, usuario.getNombreUsuario() );
			statement.setString(2, usuario.getContrasenia() );
			statement.setString(3, usuario.getCorreo() );
			statement.setString(4, usuario.getNombre() );
			statement.setString(5, usuario.getApellido() );
			
			if(statement.executeUpdate()>0) {
				estadoOperacion=true;
			}
			
			conexion.commit();
			statement.close();
			conexion.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//conexion.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
		
	}
	
	public boolean editar(String columna,String nuevoValor,Usuario usuario) throws ClassNotFoundException, SQLException {
		String comando=" Update usuarios set "+columna+"=? where idUsuario=?";
		estadoOperacion=false;
		conexion=Conexion.crearConexion();
		try {
			PreparedStatement declaracion = conexion.prepareStatement(comando);
			declaracion.setString(1,nuevoValor);
			declaracion.setInt(2,usuario.getIdUsuario());
			
			estadoOperacion=statement.executeUpdate()>0;
			
			conexion.commit();
			statement.close();
			conexion.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			conexion.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	public boolean editar(Usuario usuario) throws ClassNotFoundException, SQLException {
		String comando=" Update usuarios set nombreUsuario=?,contrasenia=?,correo=?,nombre=?,apellido=? where idUsuario=?";
		estadoOperacion=false;
		conexion=Conexion.crearConexion();
		
		try {
			conexion.setAutoCommit(false);
			statement=conexion.prepareStatement(comando);
			statement.setString(1,usuario.getNombreUsuario());
			statement.setString(2,usuario.getContrasenia());
			statement.setString(3,usuario.getCorreo());
			statement.setString(4,usuario.getNombre());
			statement.setString(5,usuario.getApellido());
			
			estadoOperacion=statement.executeUpdate()>0;
			conexion.commit();
			statement.close();
			conexion.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			conexion.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
		
	}
	
	static void eliminar(int idUsuario) throws SQLException, ClassNotFoundException {
		String sql = "Delete from usuarios where idUsuario=?";
		Connection conexion=Conexion.crearConexion();
		try {
			conexion.setAutoCommit(false);
			PreparedStatement statement=conexion.prepareStatement(sql);

			statement.setInt(1,idUsuario);
			statement.executeUpdate();
			
			conexion.commit();
			statement.close();
			conexion.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			conexion.rollback();
			e.printStackTrace();
		}
		
	}
	
	public List<Usuario> obtenerUsuarios() throws SQLException, ClassNotFoundException {
		ResultSet resultset=null;
		List<Usuario> listaUsuarios = new ArrayList<>();
		estadoOperacion=false;
		
		try {
			conexion=Conexion.crearConexion();
			
			resultset=statement.executeQuery("select * from usuarios");
			while(resultset.next()) {
				Usuario u=new Usuario();
				u.setIdUsuario(resultset.getInt(1));
				u.setNombreUsuario(resultset.getString(2));
				u.setContrasenia(resultset.getString(3));
				u.setCorreo(resultset.getString(4));
				u.setNombre(resultset.getString(5));
				u.setApellido(resultset.getString(6));
				listaUsuarios.add(u);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaUsuarios;
		
	}
	
	public Usuario obtenerUsuario(int idUsuario) throws SQLException, ClassNotFoundException {
		ResultSet resultset=null;
		Statement ejecutor = conexion.createStatement();
		String comando=" Select * from usuarios where idUsuario=?";
		estadoOperacion=false;
		Usuario u=new Usuario();
		try {
			conexion=Conexion.crearConexion();
			statement.setInt(1, idUsuario);
			resultset=statement.executeQuery(comando);

			
			
			u.setIdUsuario(resultset.getInt(1));				u.setNombreUsuario(resultset.getString(2));
			u.setContrasenia(resultset.getString(3));
			u.setCorreo(resultset.getString(4));
			u.setNombre(resultset.getString(5));
			u.setApellido(resultset.getString(6));

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
}
