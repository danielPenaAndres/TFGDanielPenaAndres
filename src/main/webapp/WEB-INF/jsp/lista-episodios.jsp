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

<h1>Lista de Episodios</h1>
<div>
<table border="1">
    <tr>
        <th>Fecha del episodio</th>
        <th>Observaciones</th>
        <th>Servicio</th>
    </tr>
    <c:forEach var="episodioTemp" items="${episodios}">
        <c:url var="linkActualizar" value="/paciente/muestraEpisodioActualizar">
            <c:param name="episodioId" value="${episodioTemp.codEpisodio}"/>
        </c:url>
        <c:url var="linkEliminar" value="/paciente/eliminarEpisodio">
            <c:param name="episodioId" value="${episodioTemp.codEpisodio}"/>
        </c:url>
        <tr>
            <td>${episodioTemp.fechaDelEpisodio}</td>
            <td>${episodioTemp.observaciones}</td>
            <td>${episodioTemp.servicio}</td>
            <td><a href="${linkActualizar}" ><input type="button" value="Modificar"/></a> </td>
            <td><a href="${linkEliminar}" ><input type="button" value="Eliminar" onclick="if (!(confirm('¿Estas seguro en elimar el registro?'))) return false"/></a> </td>
        </tr>
    </c:forEach>

</table>

<br>
    <div style="text-align:center;">
<input type="button" value="Agregar nuevo episodio" onclick="window.location.href='muestraFormularioEpisodio'; return false; "/>
    </div>
</div>
</body>
</html>