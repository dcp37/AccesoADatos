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
		<form method="post" action="insertaEmpleado">
			<td>
				<input type="number" name = "idEmpleado" min= "1"/>
				<input type="text" size="20"/>
			</td>
		</form>
	</table>
</body>
</html>