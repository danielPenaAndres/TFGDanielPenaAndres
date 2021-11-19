<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 13/10/2021
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Formulario Paciente</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/estilos/estilos.css">
</head>
<body>
<form:form action="insertarCliente" modelAttribute="cliente" method="POST">
    <form:hidden path="id"/>
<table>
    <tr>
        <td>Nombre: </td>
        <td><form:input path="nombre"/>  </td>
    </tr>
    <tr>
        <td>Apellido: </td>
        <td><form:input path="apellidos"/> </td>
    </tr>
    <tr>
        <td>DNI: </td>
        <td><form:input path="DNI"/> </td>
    </tr>
    <tr>
        <td>Fecha De Nacimiento: </td>
        <td><form:input path="fechaDeNacimiento"/> </td>
    </tr>
    <tr>
        <td>Sexo: </td>
        <td><form:input path="sexo"/> </td>
    </tr>
    <tr>
        <td>Nacionalidad: </td>
        <td><form:input path="nacionalidad"/> </td>
    </tr>
    <tr>
        <td>Email: </td>
        <td><form:input path="email"/>  </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Insertar/Modificar">
        </td>
    </tr>
</table>


</form:form>
</body>
</html>
