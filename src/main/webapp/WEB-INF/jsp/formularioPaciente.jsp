<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Formulario Paciente</title>
    <link href="${contextPath}/resources/estilos/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/estilos/estilos.css" rel="stylesheet">
</head>
<body>
<form:form method="POST" modelAttribute="paciente" action="insertarPaciente" class="form-signin">
    <c:if test="${paciente.DNI == null}">
        <h1>Nuevo Paciente</h1>
    </c:if>

    <c:if test="${paciente.DNI != null}">
        <h1>Paciente: ${paciente.DNI}</h1>
    </c:if>
    <form:hidden path="id"/>
    <spring:bind path="DNI">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="DNI" class="form-control" placeholder="DNI"
                        autofocus="true"></form:input>
            <form:errors path="DNI"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="nombre">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="nombre" class="form-control" placeholder="Nombre"
                        autofocus="true"></form:input>
            <form:errors path="nombre"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="apellidos">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="apellidos" class="form-control" placeholder="Apellidos"
                        autofocus="true"></form:input>
            <form:errors path="apellidos"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="email">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="email" path="email" class="form-control" placeholder="Email"></form:input>
            <form:errors path="email"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="fechaDeNacimiento">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="date" path="fechaDeNacimiento" class="form-control" placeholder="Fecha de Nacimiento"
                        autofocus="true"></form:input>
            <form:errors path="fechaDeNacimiento"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="pais">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select id="pais" name="pais" type="text" path="pais" class="form-control" placeholder="Pais"
                         autofocus="true">
                <form:option value="NONE" label="--- Seleccione un pais ---"/>
                <form:options items="${pais}" />
            </form:select>
            <form:errors path="pais"></form:errors>
        </div>
    </spring:bind>

    <spring:bind path="sexo">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select id="sexo" name="sexo" type="text" path="sexo" class="form-control" placeholder="Sexo"
                         autofocus="true">
                <option value="NONE">--- Seleccionar el sexo del paciente ---</option>
                <option value="Hombre">Hombre</option>
                <option value="Mujer">Mujer</option></form:select>
            <form:errors path="sexo"></form:errors>
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
