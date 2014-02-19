
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/loginStyle.css" />
<script type="text/javascript">

        function redirect_ajax(purl, pid_div)
        {
            $.ajax({
                
                type                    : 'get',
                async                   : true,
                url                     : purl,
                data                    : "user=" + $('#user').val() + "&pass=" + $('#pass').val() + "&rnd=" +Math.random(),
                success                 : function(data){
                    
                    $("#" + pid_div).html(data);
                }
            });
        }
</script>

<div id="container">
       <form id="formulario_login" >
           <h1>Bienvenido</h1>
           <input id="user" placeholder="Usuario" type="text" required=""><br>
            <input placeholder="Password" id="pass" type="password" required=""><br>
            <input id="btnSubmit" onclick='redirect_ajax("<c:url value="/usr/verificarUsuario.htm" />", "contenido");' type="button" value="Ingresar">
            <div id="msg_carga" style="display:none;margin-left: 50px;color: #ffd52d;"> <h3>Procesando...</h3> </div>
            <div id="msg_error" style="display:none;margin-left: 50px;color: orangered;"> <h3>Datos incorrectos...</h3> </div>
        </form>
</div>
