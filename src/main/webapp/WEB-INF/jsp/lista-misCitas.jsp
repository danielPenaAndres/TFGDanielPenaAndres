<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listado de citas</title>
    <link rel="icon"  href="${contextPath}/resources/imgs/favico.ico" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/estilos/estilos.css" rel="stylesheet">
</head>
<body>

<h1 class="display-1"><i class="fas fa-calendar-check"></i>  Mis Citas</h1>
<div>
    <table class="table table-striped table-hover table-bordered border border-dark table-light" >

        <c:choose>
            <c:when test="${citas.size() > 0 }">
                <tr>
                    <th>Paciente</th>
                    <th>Fecha de la cita</th>
                    <th>Observaciones</th>
                    <th>Servicio</th>
                    <th>Prestacion</th>
                    <th>Medico</th>
                <tr>
            </c:when>

            <c:otherwise>
                <tr align="center">
                    <td colspan="5">No hay citas disponibles</td>
                </tr>
            </c:otherwise>
        </c:choose>

    <c:forEach var="citaTemp" items="${citas}">
        <c:url var="linkActualizar" value="/paciente/muestraCitaActualizar">
            <c:param name="citaId" value="${citaTemp.codCita}"/>
        </c:url>
        <c:url var="linkEliminar" value="/paciente/eliminarCita">
            <c:param name="citaId" value="${citaTemp.codCita}"/>
        </c:url>
        <tr>
            <td>${citaTemp.id}</td>
            <td>${citaTemp.fechaDeCita}</td>
            <td>${citaTemp.observaciones}</td>
            <td>${citaTemp.servicio}</td>
            <td>${citaTemp.prestacion}</td>
            <td>${citaTemp.medico}</td>
            <td><a href="${linkActualizar}" ><input type="button" class="btn btn-primary" value="Modificar"/></a> </td>
            <td><a href="${linkEliminar}" ><input type="button" class="btn btn-primary" value="Eliminar" onclick="if (!(confirm('¿Estas seguro en elimar el registro?'))) return false"/></a> </td>
        </tr>
    </c:forEach>

</table>

<br>
    <div class="container-logout">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

            <h2><input type="button" value="Salir" class="btn btn-danger" onclick="document.forms['logoutForm'].submit()"/> </h2>
        </c:if>
    </div>
</div>
<form class="HOME2" action="<c:url value="/paciente/lista" />" method="GET">
    <input type="submit" name="action" class="btn btn-success" value="HOME" />
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/f082ed78dd.js" crossorigin="anonymous"></script>
</body>
</html>