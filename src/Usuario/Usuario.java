package Usuario;


public class Usuario {
	private int idUsuario;
	String nombreUsuario,contrasenia,correo,nombre,apellido;
	
	public Usuario(int idUsuario, String nombreUsuario, String contrasenia, String correo, String nombre,
			String apellido) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.correo = correo;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public Usuario() {
		
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia
				+ ", correo=" + correo + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	

}
