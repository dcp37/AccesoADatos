/**
 * 
 */
package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.AccesoDatos;
import modelo.Empleados;

/**
 * @author David♥
 *
 */
@WebServlet("/MuestraEmpleados")
public class MuestraEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public MuestraEmpleados() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Empleados> listaEmpleados = new ArrayList<Empleados>();
		AccesoDatos accd = new AccesoDatos();
		try {
			accd.conectar();
			listaEmpleados = accd.consultarTodosEmpleados();
			if (listaEmpleados != null) {
				req.setAttribute("Empleados", listaEmpleados);
				req.getRequestDispatcher("listaEmpleados.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("listaEmpleadosVacia.jsp").forward(req, resp);
				accd.desconectar();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
