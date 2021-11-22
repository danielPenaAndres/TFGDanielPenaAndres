<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Formulario Usuario</title>
    <link href="${contextPath}/resources/estilos/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/estilos/estilos.css" rel="stylesheet">
</head>
<body>
<form:form action="insertarUsuario" modelAttribute="usuario" method="POST">
    <form:hidden path="id"/>
<table>
    <tr>
        <td>DNI: </td>
        <td><form:input path="DNI"/>  </td>
    </tr>
    <tr>
        <td>Clave: </td>
        <td class="hidetext"><form:input path="clave"/></td>
    </tr>
    <tr>
        <td>Tipo: </td>
        <td><form:input path="Tipo"/> </td>
    </tr>
    <tr>
        <td>Nombre: </td>
        <td><form:input path="nombre"/> </td>
    </tr>
    <tr>
        <td>Apellidos: </td>
        <td><form:input path="apellidos"/> </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Insertar">
        </td>
    </tr>
</table>
</form:form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
