<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listado de episodios</title>
    <link rel="icon"  href="${contextPath}/resources/imgs/favico.ico" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/estilos/estilos.css" rel="stylesheet">
</head>
<body>
<h1 class="display-1"><i class="fas fa-file-medical"></i>  Lista de mis episodios</h1>
<div>
    <table class="table table-striped table-hover table-bordered border border-dark table-light" >
        <c:choose>
            <c:when test="${episodios.size() > 0 }">
                <tr>
                    <th>Fecha de inicio del episodio</th>
                    <th>Fecha de fin del episodio</th>
                    <th>Observaciones</th>
                    <th>Servicio</th>
                    <th>Tipo</th>
                    <th>Diagnostico</th>
                </tr>
            </c:when>

            <c:otherwise>
                <tr align="center">
                    <td colspan="5">No hay episodios disponibles</td>
                </tr>
            </c:otherwise>
        </c:choose>
    <c:forEach var="episodioTemp" items="${episodios}">
        <tr>
            <td>${episodioTemp.fechaInicioDelEpisodio}</td>
            <td>${episodioTemp.fechaFinDelEpisodio}</td>
            <td>${episodioTemp.observaciones}</td>
            <td>${episodioTemp.servicio}</td>
            <td>${episodioTemp.tipo}</td>
            <td>${episodioTemp.diagnostico}</td>
      </tr>
    </c:forEach>

</table>

<br>
    <div style="text-align:center;">
 </div>
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