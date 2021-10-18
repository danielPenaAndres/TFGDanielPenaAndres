<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Registro</title>
</head>
<body>
<p>El alumno con nombre <i>${elAlumno.nombre} </i>y apellido <i>${elAlumno.apellido} </i>se ha registrado con exito</p>
<p>El alumno tiene: <i> ${elAlumno.edad}</i> años </p>
<p>El codigo postal es : <i> ${elAlumno.codigoPostal}</i> </p>
<p>Su email es: <i> ${elAlumno.email}</i>  </p>
<p>La asignatura escogida es <i>${elAlumno.optativas}</i> </p>
<p>El centro escogido es <i>${elAlumno.centro}</i> </p>
<p>Los idiomas escogidos por el alumno son: <i> ${elAlumno.idioma}</i> </p>
</body>
</html>