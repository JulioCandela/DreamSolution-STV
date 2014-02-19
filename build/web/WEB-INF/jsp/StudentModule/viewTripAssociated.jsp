<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<script type="text/javascript" language="javascript">
    
    function modifyStudent_ajax(purl, pid_div)
        {
            $.ajax({
                
                type                    : 'get',
                async                   : true,
                url                     : purl,
                data                    : "rnd=" +Math.random(),
                success                 : function(data){            
                    
//                    $("#" + pid_div).html(data);
                    location.reload(true);
                }
            });
        }
      
     function closeBox(){  
        $('#boxModify').animate({'top':'-400px'},500,function(){
                $('#overlay').fadeOut('fast');
            });
     };  
       
     function activePopUp()
        {
            $('#overlay').fadeIn('fast',function(){
                $('#box').animate({'top':'160px'},500);
            });
        }
        
        function activePopUpModify()
        {
            $('#overlay').fadeIn('fast',function(){
                $('#boxModify').animate({'top':'160px'},500);
            });
        }
        
    $(document).ready(function()
    {
        $(".itemFormulario").uniform();
        <c:if  test="${flagActive==0}">
            activePopUp();
        </c:if>
    });
        
    
    
</script>

<div id='infoViewTripAssociated' class="containerInfoTripStudent" style="margin-top: 50px">
    
    <div style='width: 700px; height: 550px ;float:left'>
        <div id="mapPUCP" class="itemFormulario"  
             style=
             "width:700px;height: 500px;margin: 0 30px 50px 0;position: absolute; 
             background-image: url('../images/campusPUCPTransp.png');
             background-repeat: no-repeat;background-size: 700px; ">
            
            <div id="pointLocation" style="position:relative;width:200px;height: 200px;top:${placeParkingY}px;left:${placeParkingX}px;
                 background-image: url('../images/signalCarTransp.png');
                 display: block;background-repeat: no-repeat; background-size: 50%">
            </div>
        </div>
    </div>
    <div style="float:left;width: 350px" >
            <table id='tblResultSearch' class="bordered" >
                <tbody>
                    <tr>
                        <td>Placa Vehículo</td>
                        <td>${idCar}</td>
                    </tr>
                    <tr>
                        <td>Descripción de vehículo</td>
                        <td>${descCar}</td>
                    </tr>
                    <tr>
                        <td>Número Contacto</td>
                        <td>${phoneDriver}</td>
                    </tr>
                    <tr>
                        <td>Distrito</td>
                        <td>${nameDistrit}</td>
                    </tr>
                    <tr>
                        <td>Hora salida</td>
                        <td>${hourTrip}</td>
                    </tr>
                    <tr>
                        <td>Costo(S/.)</td>
                        <td>${pricePerson}</td>
                    </tr>
                </tbody>
            </table>
    </div>
</div>
                    
<input type="button" style="top:50%;left:78%;width: 11%" class="btnCustom" value="Retirarme de Salida" onclick="activePopUpModify()"  >                    
    
<div class="overlay" id="overlay" style="display:none;"></div>
<div class="box" id="box">
    <h1>Aviso</h1>
        <div id="divInfoTrip" style="float: left">
            <p>Oops, su viaje ha sido eliminado. Le recomendamos seleccionar uno nuevo </p>
       </div>
    <input onclick='modifyStudent_ajax("<c:url value="/usr/changeStudentOfTripDrop.htm" />", "contenido");' 
           type="button" value="Modificar Salida"   >
</div>

           
<div class="box" id="boxModify" >
    <a class="boxclose" id="boxclose" onclick="closeBox()"></a>
    <h1>Aviso</h1>
        <div id="divInfoTrip" style="float: left">
            <p>Está a punto de retirarse de este viaje. ¿Está seguro de hacerlo?</p>
       </div>
    <input onclick='modifyStudent_ajax("<c:url value="/usr/modifyTripStudent.htm" />", "contenido");' 
           type="button" value="Confirmar Retiro">
</div>
           
           