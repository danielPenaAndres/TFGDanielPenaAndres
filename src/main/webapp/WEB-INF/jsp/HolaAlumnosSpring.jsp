<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HOME</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/estilos/miEstilo.css">
</head>
<body>
<h1>MVC jsp</h1>
<p>Hola ${param.nombreAlumno}. Bienvenido al curso</p>
<p><br>
<h2>Atencion a todos</h2>
<p>${mensajeClaro}</p>
</p>
<img alt="foto" src="${pageContext.request.contextPath}/resources/imgs/citroen-c5.jpg">
</body>
</html>