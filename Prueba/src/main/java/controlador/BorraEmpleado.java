/**
 * 
 */
package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.AccesoDatos;

/**
 * @author David♥
 *
 */
@WebServlet("/BorraEmpleado")
public class BorraEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BorraEmpleado() {
		// TODO Auto-generated constructor stub
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		//
		AccesoDatos ab = new AccesoDatos();
		try {
			ab.conectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ab.borrarEmpleado(id)) {
			request.getRequestDispatcher("borradoCorrecto.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("borradoError.jsp").forward(request, response);
		try {
			ab.desconectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
