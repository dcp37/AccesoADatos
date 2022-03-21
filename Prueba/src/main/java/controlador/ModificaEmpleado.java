/**
 * 
 */
package controlador;

import java.io.IOException;
import java.sql.Date;
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
@WebServlet("/ModificaEmpleado")
public class ModificaEmpleado extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ModificaEmpleado() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idEmpleado = Integer.parseInt(request.getParameter("IdEmpleado"));
		String apellidos = request.getParameter("Apellidos");
		String nombre = request.getParameter("Nombre");
		String cargo = request.getParameter("Cargo");
		String tratamiento = request.getParameter("Tratamiento");
		Date fechaNac = Date.valueOf(request.getParameter("FechaNacimiento"));
		Date fechaContr = Date.valueOf(request.getParameter("FechaContratacion"));
		String direccion = request.getParameter("Direccion");
		String ciudad = request.getParameter("Ciudad");
		String region = request.getParameter("Region");
		String CodPostal = request.getParameter("CodPostal");
		String pais = request.getParameter("Pais");
		String telefono = request.getParameter("TelDomicilio");
		String extension = request.getParameter("Extension");
		String foto = request.getParameter("Foto");
		String notas = request.getParameter("Notas");
		int jefe = Integer.parseInt(request.getParameter("Jefe"));
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
		if (ab.modificarEmpleado(idEmpleado, apellidos, nombre, cargo, tratamiento, fechaNac, fechaContr, direccion,
				ciudad, region, CodPostal, pais, telefono, extension, foto, notas, jefe)) {
			request.getRequestDispatcher("modificaCorrecto.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("modificaError.jsp").forward(request, response);
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
