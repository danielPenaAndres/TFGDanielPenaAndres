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
<form:form action="insertarCitas" modelAttribute="cita" method="POST">
<form:hidden path="codCita"/>

<table>
    <tr>
        <td>Fecha de la Cita: </td>
        <td><form:input path="fechaDeCita"/>  </td>
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
        <td>Servicio: </td>
        <td><form:input path="prestacion"/> </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Insertar/Modificar">
        </td>
    </tr>
</table>
</form:form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
