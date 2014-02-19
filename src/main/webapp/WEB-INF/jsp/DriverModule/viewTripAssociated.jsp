<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<script type="text/javascript" language="javascript">
    
    function modifyDriverTrip_ajax(purl, pid_div)
        {
            $.ajax({
                
                type                    : 'get',
                async                   : true,
                url                     : purl,
                data                    : "rnd=" +Math.random(),
                success                 : function(data){     
                    location.reload(true);
                }
            });
        }
        
        function activePopUp()
        {
            $('#overlay').fadeIn('fast',function(){
                $('#box').animate({'top':'160px'},500);
            });
        }
        
         function closeBox(){
            $('#box').animate({'top':'-400px'},500,function(){
                $('#overlay').fadeOut('fast');
            });
         };
         
         function loadUsersResult()
        {
            $("#tblUsers tbody").remove();
            <c:forEach items='${listaUsersBeanInTrip}' var="user">
            
                var data="";
                data="<tr>";
                data+="<td>"+"${user.idUserIntoEntity}"+"</td>";
                data+="<td>"+"${user.name}"+" ${user.app}"+"</td>";
                
                <c:if test="${fNeedSpace[user.idUser] == 0}">
                    data+="<td></td>";
                </c:if>
                <c:if test="${fNeedSpace[user.idUser] == 1}">
                    data+="<td align='center'><img src='../images/checkicon.png' width=30></td>";
                </c:if>
                
                data+="</tr>";
                $("#divCount").append('<img src="../images/asientoUsado.png" width=40 height=40>');
                $("#tblUsers").append(data);
            </c:forEach>
             
            for (var i=0;i<${countFree};i++) 
                $("#divCount").append('<img src="../images/asientoLibre.png" width=40 height=40>');
    
        }
        
        $(document).ready(function()
        {
            loadUsersResult();
            
        })
        
        
        
    
</script>
    
        <div id='infoViewTripAssociated' class="containerInfoTrip">
            <div class="titleInfoTrip" style="margin-top:-5%;margin-left: 35%">Descripción de salida</div><br><br>
            <div style="float:left;">
                <img width="20%"  src="../images/reloj.png" title="Hora de salida?" style="margin-right: 10%"/>${hourTrip}<br><br>
                <span style="font-weight: bold;font-size: 150%; margin-left: 4%;margin-right: 8%">S/.</span> ${pricePerson}<br><br>
                <div id="divCount">
                </div>
            </div>
            
            <div style="width: 70%;float:left;margin-left: 5%">
                Compañeros de viaje<br><br>
                <table id='tblUsers' class="bordered" >

                    <thead>
                            <tr>
                                    <th width="150">Código</th>
                                    <th width="250">Nombres</th>
                                    <th width="100">Espacio extra</th>
                            </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
        <input  class="btnCustom" style="position:absolute;top:82%;left:65%" type="button" value="Eliminar Salida" onclick="activePopUp()">
           
<div class="overlay" id="overlay" style="display:none;"></div>
 
<div class="box" id="box">
    <a class="boxclose" id="boxclose" onclick="closeBox()"></a>
    <h1>Confirmación de Eliminación</h1>
  
        <div id="divInfoTrip" style="float: left">
            <p>Está a punto de eliminar este viaje. ¿Está seguro de hacerlo? </p>
       </div>
        <div>
            <input type="button" value="Confirmar Eliminación" onclick='modifyDriverTrip_ajax("<c:url value="/usr/modifyTripDriver.htm" />", "contenido");'/>
        </div>

</div>