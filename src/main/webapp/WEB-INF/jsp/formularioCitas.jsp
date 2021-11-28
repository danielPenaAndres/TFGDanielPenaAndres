<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Formulario Citas</title>
    <link href="${contextPath}/resources/estilos/bootstrap.min.css" rel="stylesheet">
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
            <form:input type="text" path="servicio" class="form-control" placeholder="Servicio"
                        autofocus="true"></form:input>
            <form:errors path="servicio"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="prestacion">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="prestacion" class="form-control" placeholder="Prestacion"
                        autofocus="true"></form:input>
            <form:errors path="prestacion"></form:errors>
        </div>
    </spring:bind>
    </br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
</form:form>
<form class="HOME" action="<c:url value="/paciente/lista" />" method="GET">
    <input type="submit" name="action" value="HOME" />
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
