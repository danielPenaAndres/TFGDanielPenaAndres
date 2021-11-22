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
    <title>Formulario Usuario</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/estilos/estilos.css">
</head>
<body>
<form:form action="insertarUsuario" modelAttribute="usuario" method="POST">
    <form:hidden path="id"/>
<table>
    <tr>
        <td>DNI: </td>
        <td><form:input path="DNI"/>  </td>
    </tr>
    <tr>
        <td>Clave: </td>
        <td><form:input path="clave"/> </td>
    </tr>
    <tr>
        <td>Tipo: </td>
        <td class="hidetext"><form:input path="Tipo"/> </td>
    </tr>
    <tr>
        <td>Nombre: </td>
        <td><form:input path="nombre"/> </td>
    </tr>
    <tr>
        <td>Apellidos: </td>
        <td><form:input path="apellidos"/> </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Insertar">
        </td>
    </tr>
</table>


</form:form>
</body>
</html>
