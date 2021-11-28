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
<form:form action="insertarPaciente" modelAttribute="paciente" method="POST">
    <form:hidden path="id"/>

    <c:if test="${paciente.DNI == null}">
        <h1>Nuevo Paciente</h1>
    </c:if>

    <c:if test="${paciente.DNI != null}">
        <h1>Paciente: ${paciente.DNI}</h1>
    </c:if>
<table>
    <tr>
        <td>Nombre: </td>
        <td><form:input path="nombre"/>  </td>
    </tr>
    <tr>
        <td>Apellido: </td>
        <td><form:input path="apellidos"/> </td>
    </tr>
    <tr>
        <td>DNI: </td>
        <td><form:input path="DNI"/> </td>
    </tr>
    <tr>
        <td>Fecha De Nacimiento: </td>
        <td><form:input type="date" path="fechaDeNacimiento"/> </td>
    </tr>
    <tr>
        <td>Sexo: </td>
        <td><form:input path="sexo"/> </td>
    </tr>
    <tr>
        <td>Nacionalidad: </td>
        <td><form:input path="nacionalidad"/> </td>
    </tr>
    <tr>
        <td>Email: </td>
        <td><form:input path="email"/>  </td>
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
