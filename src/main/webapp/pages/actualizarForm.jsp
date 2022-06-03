<%-- 
    Autor:Floriceli Gonzalez Ruiz                                         
    Fecha creación: 25 de abril del 2022.                                     
    Fecha actualización: 1 de mayo del 2022.                                
    Descripción: actualizarForm        
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style rel="stylesheet" >
            <%@include file="../resources/css/actualizarForm.css" %>

        </style>
    </head>
    <body>


        <link href='//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css' rel='stylesheet'/>
        <div class="menuicon">
            <a href="/proyectoFloreria/pages">
                <div class="fa fa-gift"></div>

            </a>
        </div>





        <div class="container">
            <div class="welcome">
                <div class="pinkbox">

                    <div class="signin">
                        <h1>LOGIN</h1>

                        <form action="UsuarioServletController?action=actualizar" method="post">
                            <input type='hidden' name='id' value="<c:out value="${usuario.id}"></c:out>"><br>    






                                <input type='text' name='nombreusuario'  value="<c:out value="${usuario.nombreusuario}" ></c:out>"><br>
                            <input type='password' name='contrasena' value="<c:out value="${usuario.contrasena}"></c:out>"><br>
                            <input type='text' name='nombre' value="<c:out value="${usuario.nombre}"></c:out>"><br>
                            <input type='text' name='sexo'  value="<c:out value="${usuario.sexo}"></c:out>"><br>
                            <input type="text" name='edad' onkeypress="return event.charCode >= 48 && event.charCode <= 57" value="<c:out value="${usuario.edad}"></c:out>"><br>
                            <button class="button submit" type='submit' value='Guardar'>Guardar </button>



                        </form>
                    </div>
                </div>

                <div class="rightbox">
                    <h2 class="title"><span>Floreria</span><br>GIRASOLES</h2>
                    <p class="desc">La mejor<span>experiencia</span></p>
                    <img class="flower" src="https://www.kindpng.com/picc/m/68-686516_drawn-red-rose-aesthetic-rose-gold-floral-png.png"/>
                    <p class="account">No te arrepentiras</p>


                </div>
            </div>
        </div>

    </div>
</body>
</html>