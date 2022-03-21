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
@WebServlet("/InsertaEmpleado")
public class InsertaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public InsertaEmpleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int idEmpleado = Integer.parseInt(req.getParameter("IdEmpleado"));
		String apellidos = req.getParameter("Apellidos");
		String nombre = req.getParameter("Nombre");
		String cargo = req.getParameter("Cargo");
		String tratamiento = req.getParameter("Tratamiento");
		Date fechaNacimiento = Date.valueOf(req.getParameter("FechaNacimiento"));
		Date fechaContratacion = Date.valueOf(req.getParameter("FechaContratacion"));
		String direccion = req.getParameter("Direccion");
		String ciudad = req.getParameter("Ciudad");
		String region = req.getParameter("Region");
		String codPostal = req.getParameter("CodPostal");
		String pais = req.getParameter("Pais");
		String telefono = req.getParameter("Telefono");
		String extension = req.getParameter("Extension");
		String foto = req.getParameter("Foto");
		String notas = req.getParameter("Notas");
		int jefe = Integer.parseInt(req.getParameter("Jefe"));
		AccesoDatos acd = new AccesoDatos();
		try {
			acd.conectar();
			if (acd.insertarEmpleados(null, apellidos, nombre, cargo, tratamiento, fechaNacimiento,
					fechaContratacion, direccion, ciudad, region, codPostal, pais, telefono, extension, foto, notas,
					jefe)) {
				req.getRequestDispatcher("insercionCorrecta.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("insercionIncorrecta.jsp").forward(req, resp);
				acd.desconectar();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
