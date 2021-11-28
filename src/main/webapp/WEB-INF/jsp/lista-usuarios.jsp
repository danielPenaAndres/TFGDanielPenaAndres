<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Usuarios</title>
    <link href="${contextPath}/resources/estilos/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/estilos/estilos.css" rel="stylesheet">
</head>
<body>

<h1>Lista de Usuarios</h1>
<div>
    <table class="table table-striped">
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
    <div class="container-logout">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

            <h2><input type="button" value="Salir" onclick="document.forms['logoutForm'].submit()"/> </h2>
        </c:if>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>