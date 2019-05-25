package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Consultas;

public class Autenticacion {
	boolean echo;
	 public boolean verificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
