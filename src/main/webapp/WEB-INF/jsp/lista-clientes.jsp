<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HOME</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/estilos/estilos.css">
</head>
<body>

<h1>Lista de Clientes</h1>

<table border="1">
    <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Email</th>
        <th>Modificar</th>
        <th>Eliminar</th>
    </tr>
    <c:forEach var="clienteTemp" items="${clientes}">
        <c:url var="linkActualizar" value="/cliente/muestraFormularioActualizar">
            <c:param name="clienteId" value="${clienteTemp.id}"/>
        </c:url>
        <c:url var="linkEliminar" value="/cliente/eliminar">
            <c:param name="clienteId" value="${clienteTemp.id}"/>
        </c:url>
        <tr>
            <td>${clienteTemp.nombre}</td>
            <td>${clienteTemp.apellido}</td>
            <td>${clienteTemp.email}</td>
            <td><a href="${linkActualizar}" ><input type="button" value="Modificar"/></a> </td>
            <td><a href="${linkEliminar}" ><input type="button" value="Eliminar" onclick="if (!(confirm('¿Estas seguro en elimar el registro?'))) return false"/></a> </td>
        </tr>
    </c:forEach>

</table>

<br>
<input type="button" value="Agregar Cliente" onclick="window.location.href='muestraFormularioAgregar'; return false; "/>
</body>
</html>