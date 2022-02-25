<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="modelo.Empleados, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empleados</title>
</head>
<body>
	<table>
		<tr>
			<th>Id Empleado</th>
			<th>Apellidos</th>
			<th>Nombre</th>
			<th>Cargo</th>
			<th>Tratamiento</th>
			<th>Fecha Nacimiento</th>
			<th>Fecha Contratación</th>
			<th>Dirección</th>
			<th>Ciudad</th>
			<th>Región</th>
			<th>Código Postal</th>
			<th>Pais</th>
			<th>Teléfono Domicilio</th>
			<th>Extensión</th>
			<th>Foto</th>
			<th>Notas</th>
			<th>Jefe</th>
		</tr>
		<form method="post" action="InsertaEmpleado">
			<tr>
				<td><input type="number" name="idEmpleado" min="1" /></td>
				<td><input type="text" name="apellidos" size="20" /></td>
				<td><input type="text" name="nombre" size="10" /></td>
				<td><input type="text" name="cargo" size="30" /></td>
				<td><input type="text" name="tratamiento" size="25" /></td>
				<td><input type="datetime-local" name="fechaNacimiento" /></td>
				<td><input type="datetime-local" name="fechaContratacion" /></td>
				<td><input type="text" name="direccion" size="60" /></td>
				<td><input name="ciudad" type="text" size="15" /></td>
				<td><input name="region" type="text" size="15" /></td>
				<td><input name="codPostal" type="text" size="10" /></td>
				<td><input name="pais" type="text" size="15" /></td>
				<td><input name="telDomicilio" type="tel" size="24"
					pattern="\([0-9]{3}\) [0-9]{3}[-][0-9]{3}" /></td>
				<td><input name="extension" type="text" size="24" /></td>
				<td><input name="foto" type="text" /></td>
				<td><input name="notas" type="text" /></td>
				<td><input name="jefe" type="number" min="1" step="1" /></td>
				<td><input type="submit" value="anñadirEmpleado" />Añadir</td>
			</tr>
		</form>
		<%
		ArrayList<Empleados> listaEmpleados = null;
		listaEmpleados = (ArrayList<Empleados>) request.getAttribute("Empleados");
		for (Empleados e : listaEmpleados) {
			//out.println("<td>" + "</td>");
			out.println("<tr><td>");
			out.println(e.getIdEmpleado() + "</td>");
			out.println("<td>" + e.getNombre() + "</td>");
			out.println("<td>" + e.getApellidos() + "</td>");
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
		}
		%><!--
			
		  -->
	</table>
</body>
</html>