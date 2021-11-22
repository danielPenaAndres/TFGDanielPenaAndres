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
        <th>Modificar</th>
        <th>Eliminar</th>
        <th>Episodios</th>
        <th>Citas</th>
    </tr>
    <c:forEach var="clienteTemp" items="${clientes}">
        <c:url var="linkActualizar" value="/paciente/muestraFormularioActualizar">
            <c:param name="clienteId" value="${clienteTemp.id}"/>
        </c:url>
        <c:url var="linkEliminar" value="/paciente/eliminar">
            <c:param name="clienteId" value="${clienteTemp.id}"/>
        </c:url>
        <c:url var="linkEpisodios" value="/paciente/episodios">
            <c:param name="clienteId" value="${clienteTemp.id}"/>
        </c:url>
        <c:url var="linkCitas" value="/paciente/citas">
            <c:param name="clienteId" value="${clienteTemp.id}"/>
        </c:url>
        <tr>
            <td>${clienteTemp.nombre}</td>
            <td>${clienteTemp.apellidos}</td>
            <td>${clienteTemp.DNI}</td>
            <td>${clienteTemp.fechaDeNacimiento}</td>
            <td>${clienteTemp.sexo}</td>
            <td>${clienteTemp.nacionalidad}</td>
            <td>${clienteTemp.email}</td>
            <td><a href="${linkActualizar}" ><input type="button" value="Modificar"/></a> </td>
            <td><a href="${linkEliminar}" ><input type="button" value="Eliminar" onclick="if (!(confirm('¿Estas seguro en elimar el registro?'))) return false"/></a> </td>
            <td><a href="${linkEpisodios}" ><input type="button" value="Episodios"/></a> </td>
            <td><a href="${linkCitas}" ><input type="button" value="Citas"/></a> </td>
        </tr>
    </c:forEach>

</table>

<br>
    <div style="text-align:center;">
<input type="button" value="Agregar nuevo paciente" onclick="window.location.href='muestraFormularioAgregar'; return false; "/>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>