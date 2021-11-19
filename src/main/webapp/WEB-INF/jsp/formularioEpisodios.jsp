<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 13/10/2021
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Formulario Episodios</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/estilos/estilos.css">
</head>
<body>
<form:form action="insertarEpisodio" modelAttribute="episodio" method="POST">
<form:hidden path="codEpisodio"/>

<table>
    <tr>
        <td>Fecha del Episodio: </td>
        <td><form:input path="fechaDelEpisodio"/>  </td>
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
</body>
</html>
