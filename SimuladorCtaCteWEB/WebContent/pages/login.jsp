<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simulador Cta. Cta.</title>
</head>
<body>
<h1>Inicio de Sesion</h1>
<form method="post">
	<h3>Ingrese sus datos de acceso:</h3>
	<table>
		<tr>
			<td>Rut:</td>
			<td><input type="text"id="rut" name="rut"/></td>
		</tr>
		<tr>
			<td>Contraseña:</td>
			<td><input type="password" id="contrasena" name="contrasena"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Acceder" /></td>
			<td><input type="reset" value="Cancelar" /></td>
		</tr>
	</table>
	<h4><c:out value="${mensajeError}"></c:out></h4>
</form>
</body>
</html>