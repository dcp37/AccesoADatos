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
@WebServlet("/insertaEmpleado")
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
		int idEmpleado = Integer.parseInt(req.getParameter("idEmpleado"));
		String apellidos = req.getParameter("apellidos");
		String nombre = req.getParameter("nombre");
		String cargo = req.getParameter("cargo");
		String tratamiento = req.getParameter("tratamiento");
		Date fechaNacimiento = Date.valueOf(req.getParameter("fechaNacimiento"));
		Date fechaContratacion = Date.valueOf(req.getParameter("fechaContratacion"));
		String direccion = req.getParameter("direccion");
		String ciudad = req.getParameter("ciudad");
		String region = req.getParameter("region");
		String codPostal = req.getParameter("codPostal");
		String pais = req.getParameter("pais");
		String telefono = req.getParameter("telefono");
		String extension = req.getParameter("extension");
		String foto = req.getParameter("foto");
		String notas = req.getParameter("notas");
		int jefe = Integer.parseInt(req.getParameter("jefe"));
		AccesoDatos acd = new AccesoDatos();
		try {
			acd.conectar();
			if (acd.insertarEmpleados(idEmpleado, apellidos, nombre, cargo, tratamiento, fechaNacimiento,
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
