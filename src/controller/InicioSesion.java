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
		
		//redirecciono
		if (opcion.equals("IniciarSesion")) {
			System.out.println("Apretaste Inicio de sesion");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/SingIn.jsp");
			requestDispatcher.forward(request, response);
		}if(opcion.equals("iniciar")) {
			
			System.out.println("entraste aca");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(verificar(request, response)) {
			response.sendRedirect("/primeraWe/menu.jsp");
		}else {
			//response.sendError(1);
			response.reset();
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/SingIn.jsp");
			requestDispatcher.forward(request, response);
			response.sendRedirect("/primeraWe/view/SingIn.jsp");
		}
		
		doGet(request, response);
	}
	
	protected boolean verificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			echo=Consultas.autenticacion((request.getParameter("nombreUsuario")),(request.getParameter("password")));
			System.out.println(echo);

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return echo;
	}

}
