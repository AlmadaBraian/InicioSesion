package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Usuario.Usuario;
import dao.UsuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet(description = "administra peticiones para la tabla usuarios", urlPatterns = { "/usuarios" })
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//obtengo los valores de los hypervinculos
		String opcion=request.getParameter("opcion");
		
		//redirecciono
		
		if(opcion.equals("crear")) {
			System.out.println("Apretaste crear");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/crear.jsp");
			requestDispatcher.forward(request, response);
			
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion=request.getParameter("opcion");
		if (opcion.equals("guardar")) {
			UsuarioDAO usuarioDAO= new UsuarioDAO();
			Usuario usuario=new Usuario();
			usuario.setIdUsuario(1);
			usuario.setNombreUsuario(request.getParameter("nombreUsuario"));
			usuario.setContrasenia(request.getParameter("contrasenia"));
			usuario.setCorreo(request.getParameter("correo"));
			usuario.setNombre(request.getParameter("nombre"));
			usuario.setApellido(request.getParameter("apellido"));
			
			try {
				usuarioDAO.guardar(usuario);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			
		}
		
		doGet(request, response);
	}

}
