<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="modelo.Empleados, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>Gestión Empleados</title>
</head>
<body>
	<table>
		<tr>
			<th>Id del Empleado</th>
			<th>Apellidos</th>
			<th>Nombre</th>
			<th>Cargo</th>
			<th>Tratamiento</th>
			<th>Fecha de Nacimiento</th>
			<th>Fecha de Contratación</th>
			<th>Dirección</th>
			<th>Ciudad</th>
			<th>Región</th>
			<th>Código Postal</th>
			<th>País</th>
			<th>Teléfono del Domicilio</th>
			<th>Extensión</th>
			<th>Foto</th>
			<th>Notas</th>
			<th>Su Jefe</th>
		</tr>
		<form method="post" action=InsertaEmpleado>
			<tr>
				<td><input type="text" name="IdEmpleado" size="5"></td>
				<td><input type="text" name="Apellidos" /></td>
				<td><input type="text" name="Nombre" size="30"></td>
				<td><input type="text" name="Cargo" /></td>
				<td><input type="text" name="Tratamiento" /></td>
				<td><input type="datetime-local" name="FechaNacimiento" /></td>
				<td><input type="datetime-local" name="FechaContratacion" /></td>
				<td><input type="text" name="Direccion" /></td>
				<td><input type="text" name="Ciudad" /></td>
				<td><input type="text" name="Region" /></td>
				<td><input type="text" name="CodPostal" /></td>
				<td><input type="text" name="Pais" /></td>
				<td><input type="text" name="TelDomicilio" /></td>
				<td><input type="text" name="Extension" /></td>
				<td><input type="text" name="Foto" /></td>
				<td><input type="text" name="Notas" /></td>
				<td><input type="text" name="Jefe" /></td>
				<td><button type="submit" value="Añadir">Añadir</button></td>
			</tr>
		</form>
		<%
		ArrayList<Empleados> empleados = null;
		empleados = (ArrayList<Empleados>) request.getAttribute("Empleados");

		for (Empleados e : empleados) {

			out.println("<tr>");
			out.println("<td>" + e.getIdEmpleado() + "</td>");
			out.println("<td>" + e.getApellidos() + "</td>");
			out.println("<td>" + e.getNombre() + "</td>");
			out.println("<td>" + e.getCargo() + "</td>");
			out.println("<td>" + e.getTratamiento() + "</td>");
 			out.println("<td>" + e.getFechaNacimiento() + "</td>");
			out.println("<td>" + e.getFechaContratacion() + "</td>");
			out.println("<td>" + e.getDireccion() + "</td>");
			out.println("<td>" + e.getCiudad() + "</td>");
			out.println("<td>" + e.getRegion() + "</td>");
			out.println("<td>" + e.getCodPostal() + "</td>");
			out.println("<td>" + e.getPais() + "</td>");
			out.println("<td>" + e.getTelDomicilio() + "</td>");
			out.println("<td>" + e.getExtension() + "</td>");
			out.println("<td>" + e.getFoto() + "</td>");
			out.println("<td>" + e.getNotas() + "</td>");
			out.println("<td>" + e.getJefe() + "</td>");
		%>
		<td>
			<form method="post" action="modificaProfesor.jsp">
				<input type="hidden" name="id" value="<%=e.getIdEmpleado()%>" /> <input
					type="hidden" name="apellidos" value="<%=e.getApellidos()%>" /> <input
					type="hidden" name="nombre" value="<%=e.getNombre()%>" /> <input
					type="hidden" name="cargo" value="<%=e.getCargo()%>" /><input
					type="hidden" name="tratamiento" value="<%=e.getTratamiento()%>" /><input
					type="hidden" name="fechaNacimiento"
					value="<%=e.getFechaNacimiento()%>" /><input type="hidden"
					name="fechaContratacion" value="<%=e.getFechaContratacion()%>" /><input
					type="hidden" name="direccion" value="<%=e.getDireccion()%>" /><input
					type="hidden" name="ciudad" value="<%=e.getCiudad()%>" /><input
					type="hidden" name="region" value="<%=e.getRegion()%>" /><input
					type="hidden" name="codPostal" value="<%=e.getCodPostal()%>" /><input
					type="hidden" name="pais" value="<%=e.getPais()%>" /><input
					type="hidden" name="telDomicilio" value="<%=e.getTelDomicilio()%>" /><input
					type="hidden" name="extension" value="<%=e.getExtension()%>" /><input
					type="hidden" name="foto" value="<%=e.getFoto()%>" /><input
					type="hidden" name="notas" value="<%=e.getNotas()%>" /><input
					type="hidden" name="jefe" value="<%=e.getJefe()%>" />
				<button type="submit">Modificar</button>
			</form>
		</td>
		<td>
			<form method="post" action="BorraEmpleado">
				<input type="hidden" name="id" value="<%=e.getIdEmpleado()%>" />
				<button type="submit">Eliminar</button>
			</form>
		</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
