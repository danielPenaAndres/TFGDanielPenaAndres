<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Logeate con tu DNI</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


  <link href="${contextPath}/resources/estilos/estilos.css" rel="stylesheet">
</head>

<body>

<div class="container">
  <form method="POST" action="${contextPath}/login" class="form-signin">
    <h2 class="form-heading">Pantalla de acceso</h2>

    <div class="form-group ${error != null ? 'has-error' : ''}">
      <span>${message}</span>
      <input name="username" type="text" class="form-control" placeholder="DNI"
             autofocus="true"/>
      <input name="password" type="password" class="form-control" placeholder="Clave"/>
      <span>${error}</span>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

      <button class="btn btn-lg btn-primary" type="submit">Logear</button>
    </div>
  </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>