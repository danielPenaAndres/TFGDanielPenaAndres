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

<h1>Lista de Citas</h1>
<div>
<table border="1">
    <tr>
        <th>Fecha de la cita</th>
        <th>Observaciones</th>
        <th>Servicio</th>
        <th>Prestacion</th>
    </tr>
    <c:forEach var="citaTemp" items="${citas}">
        <c:url var="linkActualizar" value="/paciente/muestraCitaActualizar">
            <c:param name="citaId" value="${citaTemp.codCita}"/>
        </c:url>
        <c:url var="linkEliminar" value="/paciente/eliminarCita">
            <c:param name="citaId" value="${citaTemp.codCita}"/>
        </c:url>
        <tr>
            <td>${citaTemp.fechaDeCita}</td>
            <td>${citaTemp.observaciones}</td>
            <td>${citaTemp.servicio}</td>
            <td>${citaTemp.prestacion}</td>
            <td><a href="${linkActualizar}" ><input type="button" value="Modificar"/></a> </td>
            <td><a href="${linkEliminar}" ><input type="button" value="Eliminar" onclick="if (!(confirm('¿Estas seguro en elimar el registro?'))) return false"/></a> </td>
        </tr>
    </c:forEach>

</table>

<br>
    <div style="text-align:center;">
<input type="button" value="Agregar nueva Cita" onclick="window.location.href='muestraFormularioCita'; return false; "/>
    </div>
</div>
</body>
</html>