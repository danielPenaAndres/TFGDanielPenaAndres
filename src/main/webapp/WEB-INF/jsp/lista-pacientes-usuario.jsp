<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clinica Sagrado Corazon</title>
    <link rel="icon"  href="${contextPath}/resources/imgs/favico.ico" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/estilos/estilos.css" rel="stylesheet">
</head>
<body>

<h1 class="display-1"><i class="fas fa-heartbeat"></i>  Mis datos</h1>
<div>
    <table class="table table-striped table-hover table-bordered border border-dark table-light" >
        <c:choose>
            <c:when test="${pacientes.size() > 0 }">
                <tr>
                    <th><a>Nombre</a></th>
                    <th><a>Apellidos</a></th>
                    <th><a>DNI</a></th>
                    <th><a>Fecha de Nacimiento</a></th>
                    <th><a>Sexo</a></th>
                    <th><a>Pais</a></th>
                    <th><a>Email</a></th>
                    <th>Modificar</th>
                    <th>Eliminar</th>
                    <th>Episodios</th>
                    <th>Citas</th>
                </tr>
            </c:when>
            <c:otherwise>
                <tr align="center">
                    <td colspan="5">No hay pacientes disponibles</td>
                </tr>
            </c:otherwise>
        </c:choose>
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
            <td>${pacienteTemp.pais}</td>
            <td>${pacienteTemp.email}</td>
            <td><a href="${linkEpisodios}" ><input type="button" class="btn btn-outline-dark" value="Episodios"/></a> </td>
            <td><a href="${linkCitas}" ><input type="button" class="btn btn-outline-dark" value="Citas"/></a> </td>
        </tr>
    </c:forEach>

</table>

<br>
    <div class="container-logout">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

            <h2><input type="button" value="Salir" class="btn btn-danger"  onclick="document.forms['logoutForm'].submit()"/> </h2>
        </c:if>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/f082ed78dd.js" crossorigin="anonymous"></script>
</body>
</html>