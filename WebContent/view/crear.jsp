<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Usuario</title>
<meta name= "viewport" content="width=devicewith, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<h1>Crear Usuario</h1>
	
	<form action="usuarios" method="post">
	<input type="hidden" name="opcion" value="guardar">
		<table border="1">
			<tr>
				<td>Nombre Usuario:</td>
				<td><input type="text" name="nombreUsuario" size="50"></td>
			</tr>
			<tr>
				<td>Contraseņa:</td>
				<td><input type="text" name="contrasenia" size="50"></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><input type="text" name="correo" size="50"></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="50"></td>
			</tr>
						<tr>
				<td>Apellido:</td>
				<td><input type="text" name="apellido" size="50"></td>
			</tr>
			
		</table>
		<button class ="btn btn-primary"> Guardar </button>
	</form>

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>