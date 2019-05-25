<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu de Opciones</title>
<meta name= "viewport" content="width=devicewith, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/estilo.css">
</head>
<body>
<div class="container well" id="containerTitle">
	<center><h1>Menu de Opciones Usuarios</h1></center>
</div>
	<div class="container well" id="containerIndex">
	<%//creo una tabla %>
	<center><table> 
	<tr><%//creo un hypervinculo %>
		<td id="vinculos"> <a href="usuarios?opcion=crear"> Registrate</a></td>
	</tr>
	<tr>
		<td id="vinculos"> <a href="Inicio?opcion=IniciarSesion">Iniciar Sesion</a></td>
	</tr>
	</table></center></div>
	<script src="bootstrap/js/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>