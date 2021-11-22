<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HOME</title>
    <link href="${contextPath}/resources/estilos/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/estilos/estilos.css" rel="stylesheet">
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
        <tr>
            <td>${citaTemp.fechaDeCita}</td>
            <td>${citaTemp.observaciones}</td>
            <td>${citaTemp.servicio}</td>
            <td>${citaTemp.prestacion}</td>
        </tr>
    </c:forEach>

</table>

<br>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>