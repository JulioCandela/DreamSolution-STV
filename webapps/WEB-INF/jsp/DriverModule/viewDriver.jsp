<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script src="../js/mask.js" type="text/javascript"></script>
<script src="../js/sheetengine.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript">        
        
        var newDriver;
        var selectedMap=0;
        var posX;
        var posY;
        
        $(function(){
            $(".itemFormulario").uniform();
        });
        
        
        function redirect_ajax_student(purl, pid_div)
        {
            if ((posX!=null)&&(posY!=null)
                    &&$("#priceTrip").val()!=""
                    &&$("#selectCantidad option:selected").attr('id')!=-1
                    &&$("#selectHora option:selected").attr('id')!=-1)
            {    
            
                $.ajax({

                    type                    : 'post',
                    async                   : true,
                    url                     : purl,
                    data                    : "&numPersonCapacity="+$("#selectCantidad option:selected").html()+
    //                                          "&idDistrit="+$("#selectDistrito").val()+
    //                                          "&idUniversity="+$("#idUniversity")+
                                              "&hourTrip="+$("#selectHora option:selected").html()+
                                              "&pricePerson="+$("#priceTrip").val()+
                                              "&placeParkingX="+posX+
                                              "&placeParkingY="+posY+
                                              "&referenceDestiny="+$("#refDestino").val()+
                                              "&rnd=" +Math.random(),
                    success                 : function(data){
                        location.reload();
                    }
                });
            }
            else
            {
                alert("Faltan algunos datos!")
            }
        }
        
        function verify_ajax(purl, pid_div)
        {
            $.ajax({

                type                    : 'post',
                async                   : true,
                
                url                     : purl,
                data                    : "rnd=" +Math.random(),
                success                 : function(data){            
                   loadLasConfigurationTripDriver(data);
                }
            }) ;
        }
        
        function loadLasConfigurationTripDriver(data)
        {  
            $("#idCar").val(data.idCar);
            $("#idCar").attr("disabled",true);
            $("#bigCar").attr("checked",Boolean(data.bigCar));
            $("#selectCantidad").val(data.numPersonCapacity);
            $("#priceTrip").val(data.pricePerson);
            $("#selectDistrito").val(data.idDistrit-1);
            $("#phoneContact").val(data.phoneContact);
            $("#refDestino").val(data.destinyReference);
            $("#idDescVehiculo").val(data.descCar);
            $.uniform.update();
            loadGoogleMaps(data.endXPositionMap,data.endYPositionMap);
        }
        
        
        function  loadSelects()
        {  
            cont=0; 
            var primerDato=0;
            $("<option id='-1' value=''>--Elija la hora--</option>").appendTo("#selectHora");  
            
            <c:forEach begin="${horaServidor}" end="24" step="1" var="hora" varStatus="status">
                 
                <c:choose>
                    
                    <c:when test="${flagHora=='1'}">
                        $("<option id="+cont+" value="+cont+">${hora}:00</option>").appendTo("#selectHora");  
                        cont++; 
                        if (${hora}!=24)
                        {$("<option id="+cont+" value="+cont+">${hora}:30</option>").appendTo("#selectHora");  }
                        cont++; 
                    </c:when>

                    <c:otherwise>
                        
                        if (primerDato!=0)
                        {
                            $("<option id="+cont+" value="+cont+">${hora}:00</option>").appendTo("#selectHora");  
                            cont++; 
                        }
                        primerDato=1;
                        
                        if (${hora}!=24)
                           { $("<option id="+cont+" value="+cont+">${hora}:30</option>").appendTo("#selectHora");  }
                        cont++;
                    </c:otherwise>
                        
                </c:choose>
            </c:forEach>
            checkFlagError();
            
        }
        
        function checkFlagError()
        {
            <c:if test="${flagError=='1'}">
                    $("#msgError").css("display","block");
                    window.scrollTo(0,0);
            </c:if>
        }
        
        
        $(document).ready(function ()
        {
            checkFlagError();
            loadSelects();
            verify_ajax("<c:url value="/usr/verifyDriver.htm" />", "contenido");
        })
        
        
        $(document).ready(function()
        {
//            $("#priceTrip").validCampoFranz('.,0123456789');
            $("#priceTrip").mask('9.99');
            
            $("#mapPUCP").click(function(e)
            {
                selectedMap=1;
                var offset = $(this).offset();
                 posX=(e.pageX - offset.left)
                 posY=(e.pageY - offset.top )
                $("#pointLocation").css("position","absolute");
                $("#pointLocation").css("top",posY+'px');
                $("#pointLocation").css("left",posX+'px');
                $("#pointLocation").css("display","inline");
//                alert(screen.width+" "+screen.height);
            })

        })
            

</script>



<div id="formularioDriver" style="margin-top: 5px">
     
    
    <div style="display: none" id="msgError" >${strMsg}</div>
    <!--<div style='height: 450px'>-->
        
    <!--</div>-->
    <!--<div style='width:1000px; overflow: auto;'>-->
        <!--<div id="mapGoogle" style="border:2px dotted;width: 500px;height: 500px;position:relative;float:left;margin:38px 30px 0 30px"/>-->
        <!--</div>-->
        <div style="float:left;width:20%;" class='boxOpacityData'> 
                    <!--<div ><h3>Distrito:(*) </h3><select  class='itemFormulario' id="selectDistrito"></select> </div>-->
                    <div style="width: 135%;margin-bottom: 10%">
                        <img width="10%"  src="../images/Home.png" title="¿A dónde vas...?"/> 
                        <select  class='itemFormulario' id="selectHora" ></select>
                    </div>
                    <div style="width: 135%;margin-bottom: 10%">
                        <img width="10%"  src="../images/reloj.png" title="¿A qué hora...?"/> 
                        <select id="selectCantidad"  class='itemFormulario' >
                            <option id="-1">--Cant. pasajeros--</option>
                            <option id="1">1</option>
                            <option id="2">2</option>
                            <option id="3">3</option>
                            <option id="4">4</option>
                            <option id="5">5</option>
                        </select>
                    </div>
                    
                    <div >
<!--                        <img width="10%"  src="../images/reloj.png" title="¿A qué hora...?"/> -->
                        <span style="font-weight: bold;font-size: 150%; margin-left: 4%;margin-right: 2%">S/.</span>
                        <input placeholder="Precio de pasaje S/." class='itemFormulario' id="priceTrip" type="text">
                    </div>
    <!--            <div ><h3>Referencia del destino:</h3>
                    <textarea class='itemFormulario' id="refDestino" style="height:300px;resize: none" maxlength="200"></textarea></div>-->
                <input id="btnAgregar" style="margin-top: 20%;margin-left: 10%" class='btnCustom' type='button' value="Agregar"
                 onclick='redirect_ajax_student("<c:url value="/usr/processDriver.htm" />", "contenido");' >
        </div>
        
        <div id="mapPUCP" class="itemFormulario" 
             style= 
             "width:75%;height: 400px;margin: 0 10px 20px 0px;position: relative;float: left; 
             background-image: url('../images/campusPUCPTransp.png');
             background-repeat: no-repeat;background-size: 700px ">
            
            <div id="pointLocation" 
                 style="width:200px;height: 200px;background-image: url('../images/signalCarTransp.png');
                 display: none;background-repeat: no-repeat; background-size: 50%;position:relative">
            </div>
        </div>
        
</div>