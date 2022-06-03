<%-- 
    Autor:Floriceli Gonzalez Ruiz                                         
    Fecha creación: 25 de abril del 2022.                                     
    Fecha actualización: 1 de mayo del 2022.                                
    Descripción: list        
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style rel="stylesheet" >
        <%@include file="../resources/css/tabla.css" %>
      
        </style>
      
    </head>
    <body>
         <link href='//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css' rel='stylesheet'/>
        <div class="menuicon">
            <a href="/proyectoFloreria/pages">
                <div class="fa fa-gift"></div>
               
            </a>
        </div>
        
        
        
        <h1></h1>
        
        <table border="1" width="100%">
            <tr>
                <th>Id</th>   
                <th>Usuario</th>  
                <th>Contraseña</th>
                <th>Nombre</th>
                <th>Sexo</th>
                <th>Edad</th>
                <th>Editar</th>
                <th>Eliminar</th>
                
              
                
                
            </tr> 
            <c:forEach var="usuario" items="${ListaUsuario}">
                <tr>
                    <td><c:out value="${usuario.id}"/></td> 
                    <td><c:out value="${usuario.nombreusuario}"/></td>
                    <td><c:out value="${usuario.contrasena}"/></td>
                    <td><c:out value="${usuario.nombre}"/></td>
                    <td><c:out value="${usuario.sexo}"/></td>
                    <td><c:out value="${usuario.edad}"/></td>
                    <td><a href="UsuarioServletController?action=actualizarForm&id=<c:out value="${usuario.id}"/>">Editar</a></td>
                    <td><a href="UsuarioServletController?action=eliminar&id=<c:out value="${usuario.id}"/>">Eliminar</a></td>
                </tr> 
            </c:forEach>
        </table> 
    </body>
</html>
