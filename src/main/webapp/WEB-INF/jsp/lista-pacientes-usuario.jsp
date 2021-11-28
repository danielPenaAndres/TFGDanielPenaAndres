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

<h1>Lista de Pacientes</h1>
<div>
<table border="1">
    <tr>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>DNI</th>
        <th>Fecha de Nacimiento</th>
        <th>Sexo</th>
        <th>Nacionalidad</th>
        <th>Email</th>
        <th>Episodios</th>
        <th>Citas</th>
    </tr>
    <c:forEach var="pacienteTemp" items="${pacientes}">
        <c:url var="linkEpisodios" value="/paciente/episodiosUsuario">
            <c:param name="pacienteId" value="${pacienteTemp.id}"/>
        </c:url>
        <c:url var="linkCitas" value="/paciente/citasUsuario">
            <c:param name="pacienteId" value="${pacienteTemp.id}"/>
        </c:url>
        <tr>
            <td>${pacienteTemp.nombre}</td>
            <td>${pacienteTemp.apellidos}</td>
            <td>${pacienteTemp.DNI}</td>
            <td>${pacienteTemp.fechaDeNacimiento}</td>
            <td>${pacienteTemp.sexo}</td>
            <td>${pacienteTemp.nacionalidad}</td>
            <td>${pacienteTemp.email}</td>
            <td><a href="${linkEpisodios}" ><input type="button" value="Episodios"/></a> </td>
            <td><a href="${linkCitas}" ><input type="button" value="Citas"/></a> </td>
        </tr>
    </c:forEach>

</table>

<br>
    <div class="container-logout">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

            <h2><input type="button" value="Salir" onclick="document.forms['logoutForm'].submit()"/> </h2>
        </c:if>
    </div>
</div>
<form class="HOME" action="<c:url value="/paciente/lista" />" method="GET">
    <input type="submit" name="action" value="HOME" />
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>