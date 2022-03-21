<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Gestión de Empleados</title>
</head>

<body>
	<h2>Empleados</h2>

	<form method="post" action="MuestraEmpleados" name="FormInsertaEmpleados">
		<button type="submit" value="Comienzo">Lista Empleados</button>
	</form>

	<form method="post" action="InsertaEmpleado">
		<!-- 		<input type="number" name="IdEmpleado"/> -->
		<label for="fApellidos">Apellidos:</label><br>
		<input type="text" id="fApellidos" name="Apellidos" /><br>
		<label for="fNombre">Nombre:</label><br>
		<input type="text" id="fNombre" name="Nombre" size="30"><br>
		<label for=fCargo>Cargo:</label><br>
		<input type="text" id="fCargo"name="Cargo" /><br>
		<label for=fTratamiento>Tratamiento:</label><br>
		<input type="text" id="fTratamiento"name="Tratamiento" /><br>
		<label for="fFechaNacimiento">Fecha de Nacimiento:</label><br>
		<input type="date" id="fFechaNacimiento" name="FechaNacimiento" /><br>
		<label for="fFechaContratacion">Fecha de Contratación:</label><br>
		<input type="date" id="fFechaContratacion" name="FechaContratacion" /><br>
		<label for="fDireccion">Dirección</label><br>
		<input type="text" id="fDireccion"name="Direccion" /><br>
		<label for="fCiudad">Ciudad:</label><br>
		<input type="text" id="fCiudad"name="Ciudad" /><br>
		<label for="fRegion">Región:</label><br>
		<input type="text" id="fRegion"name="Region" /><br>
		<label for="fCodPostal">Código Postal:</label><br>
		<input type="text" id="fCodPostal"name="CodPostal" /><br>
		<label for="fPais">País:</label><br>
		<input type="text" id="fPais" name="Pais" /><br>
		<label for="fTelDomicilio">Teléfono de Domicilio:</label><br>
		<input type="text" id="fTelDomicilio" name="TelDomicilio" /><br>
		<label for="fExtension">Extensión:</label><br>
		<input type="text" id="fExtension" name="Extension" /><br>
		<label for="fFoto">Foto:</label><br>
		<input type="text" id="fFoto" name="Foto" /><br>
		<label for="fNotas">Notas:</label><br>
		<input type="text" id="fNotas" name="Notas" /><br>
		<label for="fJefe">Jefe:</label><br>
		<input type="text" id="fJefe" name="Jefe" /><br>
		<button type="submit" value="Inserta">Crea Empleado</button>
	</form>
</body>
</html>