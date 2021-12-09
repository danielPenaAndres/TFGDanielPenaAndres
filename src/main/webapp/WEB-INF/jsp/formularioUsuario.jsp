<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Formulario Usuario</title>
    <link rel="icon"  href="${contextPath}/resources/imgs/favico.ico" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/estilos/estilos.css" rel="stylesheet">
</head>
<body>



<form:form method="POST" modelAttribute="usuario" action="insertarUsuario" class="form-signin">
        <c:if test="${usuario.DNI == null}">
            <h1>Nuevo Usuario</h1>
        </c:if>

        <c:if test="${usuario.DNI != null}">
            <h1>Usuario: ${usuario.DNI}</h1>
        </c:if>
        <form:hidden path="id"/>
        <spring:bind path="DNI">
            <div class="form-group ${status.error ? 'has-error' : ''}">
               <form:input type="text" path="DNI" class="form-control" placeholder="DNI"
                            autofocus="true"></form:input>
                <form:errors path="DNI"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="clave">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="clave" class="form-control" placeholder="Clave"></form:input>
                <form:errors path="clave"></form:errors>
            </div>
        </spring:bind>
    <spring:bind path="Tipo">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select id="Tipo" name="Tipo" type="text" path="Tipo" class="form-control" placeholder="Tipo"
                         autofocus="true">
                <option value="NONE">--- Seleccionar el tipo de usuario ---</option>
                <option value="MEDICO">MEDICO</option>
                <option value="ADMIN">ADMIN</option>
                <option value="USUARIO">USUARIO</option></form:select>
            <form:errors path="Tipo"></form:errors>
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

</br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
    </form:form>
<form class="HOME" action="<c:url value="/paciente/lista" />" method="GET">
    <input type="submit" class="btn btn-success"  name="action" value="HOME" />
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
