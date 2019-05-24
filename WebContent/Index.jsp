<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu de Opciones</title>
<meta name= "viewport" content="width=devicewith, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
	<center><h1>Menu de Opciones Usuarios</h1></center>
	<%//creo una tabla %>
	<center><table border="1"> 
	<tr><%//creo un hypervinculo %>
		<td> <a href="usuarios?opcion=crear"> Registrate</a></td>
	</tr>
	<tr>
		<td> <a href="Inicio?opcion=IniciarSesion">Iniciar Sesion</a></td>
	</tr>
	</table></center>
	<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>