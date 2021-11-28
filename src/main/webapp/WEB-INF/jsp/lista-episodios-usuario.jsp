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
<h1>Lista de Episodios</h1>
<div>
<table border="1">
    <tr>
        <th>Fecha del episodio</th>
        <th>Observaciones</th>
        <th>Servicio</th>
    </tr>
    <c:forEach var="episodioTemp" items="${episodios}">
        <tr>
            <td>${episodioTemp.fechaDelEpisodio}</td>
            <td>${episodioTemp.observaciones}</td>
            <td>${episodioTemp.servicio}</td>
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

            <h2><input type="button" value="Salir" onclick="document.forms['logoutForm'].submit()"/> </h2>
        </c:if>
    </div>
</div>
<form class="HOME2" action="<c:url value="/paciente/lista" />" method="GET">
    <input type="submit" name="action" value="HOME" />
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>