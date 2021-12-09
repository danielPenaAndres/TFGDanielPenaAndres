<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Formulario Episodios</title>
    <link rel="icon"  href="${contextPath}/resources/imgs/favico.ico" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/estilos/estilos.css" rel="stylesheet">
</head>
<body>
<form:form method="POST" modelAttribute="episodio" action="insertarEpisodio" class="form-signin">
    <c:if test="${episodio.codEpisodio == null}">
        <h1>Nuevo Episodio</h1>
    </c:if>

    <c:if test="${episodio.codEpisodio != null}">
        <h1>Episodio: ${episodio.codEpisodio}</h1>
    </c:if>
    <form:hidden path="codEpisodio"/>
    <spring:bind path="fechaInicioDelEpisodio">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="date" path="fechaInicioDelEpisodio" class="form-control" placeholder="Fecha de inicio del episodio"
                        autofocus="true"></form:input>
            <form:errors path="fechaInicioDelEpisodio"></form:errors>
        </div>
    </spring:bind>

    <spring:bind path="fechaFinDelEpisodio">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="date" path="fechaFinDelEpisodio" class="form-control" placeholder="Fecha de fin del episodio"
                        autofocus="true"></form:input>
            <form:errors path="fechaFinDelEpisodio"></form:errors>
        </div>
    </spring:bind>

    <spring:bind path="observaciones">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="observaciones" class="form-control" placeholder="Observaciones"
                        autofocus="true"></form:input>
            <form:errors path="observaciones"></form:errors>
        </div>
    </spring:bind>

    <spring:bind path="servicio">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select id="servicio" name="servicio" type="text" path="servicio" class="form-control" placeholder="Servicio"
                         autofocus="true">
                <form:option value="NONE" label="--- Seleccione un servicio ---"/>
                <form:options items="${servicio}" />
            </form:select>
            <form:errors path="servicio"></form:errors>
        </div>
    </spring:bind>

    <spring:bind path="tipo">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select id="tipo" name="tipo" type="text" path="tipo" class="form-control" placeholder="Tipo"
                         autofocus="true">
                <option value="NONE">--- Seleccionar el tipo del episodio ---</option>
                <option value="AMB">Ambulatorio</option>
                <option value="URG">Urgencias</option>
                <option value="HOSP">Hospitalización</option></form:select>
            <form:errors path="tipo"></form:errors>
        </div>
    </spring:bind>


    </br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
</form:form>
<form class="HOME" action="<c:url value="/paciente/lista" />" method="GET">
    <input type="submit" class="btn btn-success" name="action" value="HOME" />
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
