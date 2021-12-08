<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clinica Sagrado Corazon</title>
    <link rel="icon"  href="${contextPath}/resources/imgs/favico.ico" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${contextPath}/resources/estilos/estilos.css" rel="stylesheet">

</head>
<body>
<div>
    <h1 class="display-1"><i class="fas fa-head-side-mask"></i>  Lista de Pacientes</h1>
</div>
<div>
    <div>
    <form th:action="@{/paginaPaciente=1}" >
        <i class="fas fa-search"></i>  Buscar por DNI: <input type="text" class="btn btn-outline-dark" name="DNI" />
        &nbsp;
        <input type="submit" class= "btn btn-primary btn-rounded" value="Busqueda"/>
        &nbsp;
        <input type="button" class= "btn btn-secondary btn-rounded" value="Mostrar todos los pacientes" onclick="limpiarFiltro()"/>
        &nbsp;
    </form>
        <form action="paciente">
            <c:forEach var="paciente" items="${paciente}">
                ${paciente}
            </c:forEach>
        </form>
    </div>
    <br/>
<table class="table table-striped table-hover table-bordered border border-dark table-light" >
    <c:choose>
        <c:when test="${pacientes.size() > 0 }">
            <tr>
                <th></th>
            <th><a>Nombre</a></th>
            <th><a>Apellidos</a></th>
            <th><a>DNI</a></th>
            <th><a>Fecha de Nacimiento</a></th>
            <th><a>Sexo</a></th>
            <th><a>Pais</a></th>
            <th><a>Email</a></th>
            <th>Modificar</th>
            <th>Eliminar</th>
            <th>Episodios</th>
            <th>Citas</th>
            </tr>
        </c:when>
        <c:otherwise>
            <tr align="center">
                <td colspan="5">No hay pacientes disponibles</td>
            </tr>
        </c:otherwise>
    </c:choose>

    <c:forEach var="pacienteTemp" items="${pacientes}">
        <c:url var="linkActualizar" value="/paciente/muestraFormularioActualizar">
            <c:param name="pacienteId" value="${pacienteTemp.id}"/>
        </c:url>
        <c:url var="linkEliminar" value="/paciente/eliminar">
            <c:param name="pacienteId" value="${pacienteTemp.id}"/>
        </c:url>
        <c:url var="linkEpisodios" value="/paciente/episodios">
            <c:param name="pacienteId" value="${pacienteTemp.id}"/>
        </c:url>
        <c:url var="linkCitas" value="/paciente/citas">
            <c:param name="pacienteId" value="${pacienteTemp.id}"/>
        </c:url>
        <tr>
            <c:choose>
                <c:when test="${pacienteTemp.sexo == 'Hombre'}">
                    <td><span style="color: #2596be;"><i class="fas fa-male"></i></span></td>
                </c:when>
                <c:otherwise>
                    <td><span style="color: #f783ac;"><i class="fas fa-female"></i></span></td>
                </c:otherwise>
            </c:choose>
            <td>${pacienteTemp.nombre}</td>
            <td>${pacienteTemp.apellidos}</td>
            <td>${pacienteTemp.DNI}</td>
            <td>${pacienteTemp.fechaDeNacimiento}</td>
            <td>${pacienteTemp.sexo}</td>
            <td>${pacienteTemp.pais}</td>
            <td>${pacienteTemp.email}</td>
            <td><a href="${linkActualizar}" ><input type="button" class="btn btn-outline-dark" value="Modificar"/></a> </td>
            <td><a href="${linkEliminar}" ><input type="button" class="btn btn-outline-dark" value="Eliminar" onclick="if (!(confirm('¿Estas seguro en elimar el registro?'))) return false"/></a> </td>
            <td><a href="${linkEpisodios}" ><input type="button" class="btn btn-outline-dark" value="Episodios"/></a> </td>
            <td><a href="${linkCitas}" ><input type="button" class="btn btn-outline-dark" value="Citas"/></a> </td>
        </tr>
    </c:forEach>

</table>
    <c:if test="${pacientes.size() > 0 }">
        <div class="panel-footer" >
            Mostrando ${number+1} de ${size+1} de ${totalElements}<br/>
            <ul class="pagination">
                <c:forEach begin="0" end="${totalPages-1}" var="page">
                    <li class="page-item" >
                        <a href="paginaPaciente=${page+1}" class="page-link">${page+1}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
</br>
    <div style="text-align:center;">
<input type="button" value="Agregar nuevo paciente" class="btn btn-primary" onclick="window.location.href='muestraFormularioAgregar'; return false; "/>
<input type="button" value="Mis Citas"  class="btn btn-secondary" onclick="window.location.href='misCitas'; return false; "/>

    </div>
    <div class="container-logout">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            <div class="d-grid gap-2 d-md-block">

            <h2><input type="button" value="Salir" class="btn btn-danger" onclick="document.forms['logoutForm'].submit()"/> </h2>
            </div>
        </c:if>
    </div>
</div>
<script type="text/javascript">
    function limpiarFiltro(){
        window.location='/paciente/lista';
    }
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/f082ed78dd.js" crossorigin="anonymous"></script>

</body>
</html>