<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>No se ha podido insertar correctamente</title>
</head>
<body>

	<%
	String id = request.getParameter("IdEmpleado");
	String apellidos = request.getParameter("Apellidos");
	String nombre = request.getParameter("Nombre");
	String cargo = request.getParameter("Cargo");
	String tratamiento = request.getParameter("Tratamiento");
	Date fechaNacimiento = Date.valueOf(request.getParameter("FechaNacimiento"));
	Date fechaContratacion = Date.valueOf(request.getParameter("FechaContratacion"));
	String direccion = request.getParameter("Direccion");
	String ciudad = request.getParameter("Ciudad");
	String region = request.getParameter("Region");
	String codPostal = request.getParameter("CodPostal");
	String pais = request.getParameter("Pais");
	String telDomicilio = request.getParameter("TelDomicilio");
	String extension = request.getParameter("Extension");
	String foto = request.getParameter("Foto");
	String notas = request.getParameter("Notas");
	String jefe = request.getParameter("Jefe");
	%>
	<p>No se ha podido guardar la siguiente información:</p>
	<p>
		Id:
		<%=id%>
	</p>
	<p>
		Apellidos:
		<%=apellidos%>
	</p>
	<p>
		Nombre:
		<%=nombre%>
	</p>
	<p>
		Cargo:
		<%=cargo%>
	</p>
	<p>
		Tratamiento:
		<%=tratamiento%>
	</p>
	<p>
		Fecha de Nacimiento:
		<%=fechaNacimiento%>
	</p>
	<p>
		Fecha de Contratación:
		<%=fechaContratacion%>
	</p>
	<p>
		Dirección:
		<%=direccion%>
	</p>
	<p>
		Ciudad:
		<%=ciudad%>
	</p>
	<p>
		Región:
		<%=region%>
	</p>
	<p>
		Código Postal:
		<%=codPostal%>
	</p>
	<p>
		País:
		<%=pais%>
	</p>
	<p>
		Teléfono Domicilio:
		<%=telDomicilio%>
	</p>
	<p>
		Extensión:
		<%=extension%>
	</p>
	<p>
		Foto:
		<%=foto%>
	</p>
	<p>
		Notas:
		<%=notas%>
	</p>
	<p>
		Jefe:
		<%=jefe%>
	</p>

	<form action="muestraProfesores" method="post">
		<input type="submit" value="Volver">
	</form>

</body>
</html>