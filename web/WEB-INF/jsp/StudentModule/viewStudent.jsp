<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="text/javascript" language="javascript">
    
    var thisTemp,fCheck=0;
    
    $(function(){
            $(".itemFormulario").uniform();
        });
    
    
     function addStudentToTrip_ajax(purl, pid_div)
        {
                    $.ajax({

                        type                    : 'post',
                        async                   : true,
                        url                     : purl,
                        data                    : "idCar="+$("#lblIdCar").text()+
                                                  "&idTrip="+$("#lblidTrip").text()+
                                                  "&rnd=" +Math.random(),
                        success                 : function(data){            
        //                    $("#" + pid_div).html(data);
                                location.reload(true);
                        }
                    });
                
        }
    
    function getPositionGoogleMap(idCar)
    {
        purl="<c:url value="/usr/getPositionGoogleMaps.htm" />";
        $.ajax({

                type                    : 'post',
                async                   : true,
                
                url                     : purl,
                data                    : "idCar="+idCar+
                                          "&rnd=" +Math.random(),
                success                 : function(data){   
                    loadGoogleMaps(data[0],data[1]);
                }
        })
    }
    
    
    function searchResultTable_ajax(purl, pid_div)
        {
            $.ajax({

                type                    : 'post',
                async                   : true,
                
                url                     : purl,
                data                    : "idDistrit="+$("#selectDistrito").val()+
                                          "&hourTrip="+$("#selectHora option:selected").text()+
                                          "&needBigCar="+$("#checkBigCar:checked").val()+
                                          "&rnd=" +Math.random(),
                success                 : function(data){   
                    
                    loadTableResult(data);
                   var idCar,hourTrip,pricePerson;
                   $("#tblResultSearch tr").click(function()
                        {
                            $(this).children('td').each(function (i)
                            {
                                switch(i)
                                {
                                    case 0: idCar=$(this).text();break;
                                    case 1: pricePerson=$(this).text();break;
                                }
                            });

                            if (idCar!=null)
                            {
                                completeLabelInfo(idCar,hourTrip,pricePerson,data);
                                getPositionGoogleMap(idCar);
                                if (thisTemp!=null)
                                    thisTemp.removeClass('highlight');
                                else
                                    fCheck=1;
                                    
                                
                                $(this).addClass('highlight');
                                thisTemp=$(this);
//                                activePopUp();
                            }
                        });
                }
            }) ;
        }
        
        
    function completeLabelInfo(idCar,hourTrip,pricePerson,data)
    {
        $("#lblIdCar").text(idCar);
        $("#lblHourTrip").text(hourTrip);
        $("#lblPrecio").text(pricePerson);
        $("#lblIdDistrito").text($("#selectDistrito option:selected").text());
        
        for (i=0;i<data.length;i++)
            {
                if (data[i].idCar==idCar)
                    {
                        $("#lblRefDestino").text(data[i].destinyReference);
                        $("#lblidTrip").text(data[i].idTripDay);
                        return;
                    }
            }
    }
    
    $("#selectDistrito,#selectHora,#checkBigCar ").change(function()
    {
        searchResultTable_ajax("<c:url value="/usr/searchTrips.htm" />", "contenido");
    });
    
    function  loadSelects()
        {
            var cont=0;
               <c:forEach items='${listaDistritos}' var="distrito">
                   $("<option value="+cont+">${distrito}</option>").appendTo("#selectDistrito");  
                       cont++; 
               </c:forEach>
                   $("<option value="+cont+">--Elija un distrito--</option>").appendTo("#selectDistrito");  
            
             $("#selectDistrito").val(cont);
            cont=0; 
            var primerDato=0;
            
            
            $("<option value=''>--Elija la hora--</option>").appendTo("#selectHora");  
            <c:forEach begin="${horaServidor}" end="24" step="1" var="hora" varStatus="status">
                 
                <c:choose>
                    
                    <c:when test="${flagHora=='1'}">
                        $("<option value="+cont+">${hora}:00</option>").appendTo("#selectHora");  
                        cont++; 
                        if (${hora}!=24)
                        {$("<option value="+cont+">${hora}:30</option>").appendTo("#selectHora");  }
                        cont++; 
                    </c:when>

                    <c:otherwise>
                        
                        if (primerDato!=0)
                        {
                            $("<option value="+cont+">${hora}:00</option>").appendTo("#selectHora");  
                            cont++; 
                        }
                        primerDato=1;
                        
                        if (${hora}!=24)
                           { $("<option value="+cont+">${hora}:30</option>").appendTo("#selectHora");  }
                        cont++;
                    </c:otherwise>
                        
                </c:choose>
            </c:forEach>
                $.uniform.update();
        }
        
        function loadTableResult(data)
        {
            $("#tblResultSearch tbody").remove();
            
            for (i=0;i<data.length;i++)
            {
                var dataT="";
                dataT="<tr>";
                dataT+="<td>"+data[i].idCar+"</td>";
//                dataT+="<td>"+data[i].hourTrip+"</td>";
                dataT+="<td>"+data[i].pricePerson+"</td>";
//                dataT+="<td><img src='../images/iconoMapa.jpg' width=40 height=40></td>";
                dataT+="</tr>";
                $("#tblResultSearch").append(dataT);
            }
        }
        
        $('.bordered tr').mouseover(function(){
            $(this).addClass('highlight');
                 }).mouseout(function(){
            $(this).removeClass('highlight');
        });
        
        function activePopUp()
        {
            if (fCheck==1)
                $('#overlay').fadeIn('fast',function(){
                    $('#box').animate({'top':'160px'},500);
                });
            else
                alert("Faltan algunos datos!")    
        }
        
         $('#boxclose').click(function(){
            $('#box').animate({'top':'-400px'},500,function(){
                $('#overlay').fadeOut('fast');
            });
         });
    
    loadSelects();
    
</script>

<div id='formularioStudent' style="margin: 0 auto 0 auto">
    <div style="float:left">
        <div style="width:100%;margin:5px 0 100px 0;">
            <div  id='divSelectDistrit' style="width: 80%;margin-right: 20px;margin-bottom: 5%">
                <img width="10%"  src="../images/Home.png" title="¿A dónde vas...?"/> 
                <select class="itemFormulario" id="selectDistrito" ></select>
            </div>
            
            <div  id='divHora' style="width: 80%;margin-right:  20px;margin-bottom: 10%">
                <img width="10%"  src="../images/reloj.png" title="¿A qué hora...?"/> 
                <select class="itemFormulario"  id="selectHora" ></select>
            </div>    

            <div id='divBigCar' style="width: 60%">
                Espacio extra <input id="checkBigCar" class="itemFormulario" type="checkbox" >Sí
            </div>  
            <!--<div style="clear:both"></div>-->
        </div>
        <div style="width:300px;float:left">
            <table id='tblResultSearch' class="bordered" >
                <thead>
                        <tr>
    <!--                            <th>Placa</th>-->
                                <th>Placa</th>
                                <th>Costo Pasaje(S/.) </th>
                        </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
    <div id="mapGoogle" style="float:left;margin-left:30px; border:2px dotted;width: 500px;height: 500px;">
    </div>
    <input id="btnElegir" class='btnCustom' type="button" value="Elegir" onclick="activePopUp()" class="itemFormulario"> 
</div>



<div class="overlay" id="overlay" style="display:none;"></div>
 
<div class="box" id="box">
    <a class="boxclose" id="boxclose"></a>
    <h1>Confirmación de Selección</h1>
  
        <div id="divInfoTrip" style="float: left">
            <p> Placa Vehículo: 
            <label class="itemFormulario"  id="lblIdCar"> </label></p>
            <p> Distrito: 
            <label  class="itemFormulario" id="lblIdDistrito"> </label></p>
            <p> Referencia Destino: 
            <label class="itemFormulario" id="lblRefDestino"> </label></p>
            <p> Precio: 
            <label class="itemFormulario" id="lblPrecio"> </label></p>
            <p> Hora Salida:
            <label class="itemFormulario" id="lblHourTrip"> </label> </p>
            <label class="itemFormulario" id="lblidTrip" style="display: none"></label>
       </div>
        <div style="margin: 50px 0 0 300px">
            <img src="../images/check.png" width="100px" style=""
            onclick='addStudentToTrip_ajax("<c:url value="/usr/addStudentToTrip.htm" />", "contenido");' >
        </div>

</div>

