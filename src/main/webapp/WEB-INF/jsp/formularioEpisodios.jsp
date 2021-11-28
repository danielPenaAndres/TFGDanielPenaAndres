<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Formulario Episodios</title>
    <link href="${contextPath}/resources/estilos/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/estilos/estilos.css" rel="stylesheet">
</head>
<body>
<form:form action="insertarEpisodio" modelAttribute="episodio" method="POST">
<form:hidden path="codEpisodio"/>

    <c:if test="${episodio.codEpisodio == null}">
        <h1>Nuevo Episodio</h1>
    </c:if>

    <c:if test="${episodio.codEpisodio != null}">
        <h1>Episodio: ${episodio.codEpisodio}</h1>
    </c:if>

<table>
    <tr>
        <td>Fecha del Episodio: </td>
        <td><form:input type="date" path="fechaDelEpisodio"/>  </td>
    </tr>
    <tr>
        <td>Observaciones: </td>
        <td><form:input path="observaciones"/> </td>
    </tr>
    <tr>
        <td>Servicio: </td>
        <td><form:input path="servicio"/> </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Insertar/Modificar">
        </td>
    </tr>
</table>
</form:form>
<form class="HOME" action="<c:url value="/paciente/lista" />" method="GET">
    <input type="submit" name="action" value="HOME" />
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
