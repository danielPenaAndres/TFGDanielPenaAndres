<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Registro</title>
</head>
<body>
<p><form:form action="procesarFormulario" modelAttribute="elAlumno">
Nombre: <form:input path="nombre"/>
    <form:errors path="nombre" style="color:red" />
        <br><br>
Apellido: <form:input path="apellido"/>
    <br><br>
    Edad: <form:input path="edad"/>
    <form:errors path="edad" style="color:red" />
    <br><br>
    Email: <form:input path="email"/>
    <form:errors path="email" style="color:red" />
    <br><br>
    C. Postal: <form:input path="codigoPostal"/>
    <form:errors path="codigoPostal" style="color:red" />
    <br><br>
    Optativas:<br>
    <form:select path="optativas" multiple="true">
        <form:option value="Lengua" label="Lengua" />
        <form:option value="Ingles" label="Ingles"/>
        <form:option value="Matematicas" label="Matematicas"/>
        <form:option value="Religion" label="Religion"/>
    </form:select>
    <br><br>
    Barcelona<form:radiobutton path="centro" value="Barcelona"/>
    Madrid<form:radiobutton path="centro" value="Madrid"/>
    Valencia<form:radiobutton path="centro" value="Valencia"/>
    Sevilla<form:radiobutton path="centro" value="Sevilla"/>
    <br><br>
    Ingles<form:checkbox path="idioma" value="Ingles"/>
    Frances<form:checkbox path="idioma" value="Frances"/>
    Sueco<form:checkbox path="idioma" value="Sueco"/>
    Chino<form:checkbox path="idioma" value="Chino"/>
    <br><br>
    <input type="submit" value="Enviar">
</form:form></p>

</body>
</html>