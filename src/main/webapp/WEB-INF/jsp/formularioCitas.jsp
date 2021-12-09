<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Formulario Citas</title>
    <link rel="icon"  href="${contextPath}/resources/imgs/favico.ico" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/estilos/estilos.css" rel="stylesheet">
</head>
<body>
<form:form method="POST" modelAttribute="cita" action="insertarCitas" class="form-signin">

    <c:if test="${cita.codCita == null}">
        <h1>Nueva Cita</h1>
    </c:if>

    <c:if test="${cita.codCita != null}">
        <h1>Cita: ${cita.codCita}</h1>
    </c:if>

    <form:hidden path="codCita"/>
    <spring:bind path="fechaDeCita">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="date" path="fechaDeCita" class="form-control" placeholder="Fecha de la Cita"
                        autofocus="true"></form:input>
            <form:errors path="fechaDeCita"></form:errors>
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

    <spring:bind path="prestacion">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select id="prestacion" name="prestacion" type="text" path="prestacion" class="form-control" placeholder="Prestacion"
                         autofocus="true">
                <form:option value="NONE" label="--- Seleccione una prestacion ---"/>
                <form:options items="${prestacion}" />
            </form:select>
            <form:errors path="prestacion"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="medico">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select id="medico" name="medico" type="text" path="medico" class="form-control" placeholder="Medico"
                         autofocus="true">
                <form:option value="NONE" label="--- Selecciona un medico ---"/>
                <form:options items="${medico}" />
            </form:select>
            <form:errors path="prestacion"></form:errors>
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
