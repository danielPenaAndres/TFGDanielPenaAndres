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

<h1>Lista de Usuarios</h1>
<div>
<table border="1">
    <tr>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>DNI</th>
        <th>Clave</th>
        <th>Tipo</th>
    </tr>
    <c:forEach var="usuarioTemp" items="${usuarios}">
        <c:url var="linkActualizar" value="/paciente/muestraUsuarioActualizar">
            <c:param name="usuarioId" value="${usuarioTemp.id}"/>
        </c:url>
        <c:url var="linkEliminar" value="/paciente/eliminarUsuario">
            <c:param name="usuarioId" value="${usuarioTemp.id}"/>
        </c:url>
        <tr>
            <td>${usuarioTemp.nombre}</td>
            <td>${usuarioTemp.apellidos}</td>
            <td>${usuarioTemp.DNI}</td>
            <td class="hidetext">${usuarioTemp.clave}</td>
            <td>${usuarioTemp.tipo}</td>
            <td><a href="${linkActualizar}" ><input type="button" value="Modificar"/></a> </td>
            <td><a href="${linkEliminar}" ><input type="button" value="Eliminar" onclick="if (!(confirm('¿Estas seguro en elimar el registro?'))) return false"/></a> </td>
        </tr>
    </c:forEach>

</table>

<br>
    <div style="text-align:center;">
<input type="button" value="Agregar nuevo usuario" onclick="window.location.href='muestraFormularioUsuario'; return false; "/>
    </div>
</div>
</body>
</html>