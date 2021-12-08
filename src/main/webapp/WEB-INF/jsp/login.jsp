<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Pantalla de acceso</title>
  <link rel="icon"  href="${contextPath}/resources/imgs/favico.ico" >
  <link href="${contextPath}/resources/estilos/estiloLogin.css" rel="stylesheet">
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <form method="POST" action="${contextPath}/login" class="form-signin">
    <div class="fadeIn first">
      <img src="${contextPath}/resources/imgs/clinica.png"  id="icon" alt="User Icon" />
      <h2 class="form-heading">Bienvenido a la clinica Sagrado Corazón</h2>
    </div>
    <div class="form-group ${error != null ? 'has-error' : ''}">
      <span>${message}</span>
    <!-- Login Form -->

      <input type="text" id="login" class="fadeIn second" name="username" placeholder="DNI">
      <input type="password" id="password" class="fadeIn third" name="password" placeholder="Clave">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      </br>
      <span style="color:red">${error}</span>
      <input type="submit" class="fadeIn fourth" value="Acceder">

    </div>
    </form>


  </div>
</div>
</form>
</div>
</body>
</html>