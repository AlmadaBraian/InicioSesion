package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Consultas;
import dao.UsuarioDAO;

/**
 * Servlet implementation class InicioSesion
 */
@WebServlet("/Inicio")
public class InicioSesion extends HttpServlet {
	boolean echo=false;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioSesion() {
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
		String nextPage = request.getParameter("nextPage");
		
		//redirecciono
		if (opcion.equals("IniciarSesion")) {
			System.out.println("Apretaste Inicio de sesion");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/IniciarSesion.jsp");
			requestDispatcher.forward(request, response);
		}if(nextPage.equals("iniciar")) {
			
			System.out.println("entraste aca");
			
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			echo=Consultas.autenticacion((request.getParameter("nombreUsuario")),(request.getParameter("contrasenia")));
			System.out.println(echo);
			if(echo) {
				response.sendRedirect("/primeraWe/view/menu.jsp");
			}else {
				response.sendRedirect("/primeraWe/view/IniciarSesion.jsp");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
