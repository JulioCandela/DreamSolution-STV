<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">

        <title>Súbete!</title>
        <link href="css/RegisterUserStyle.css" rel="stylesheet" type="text/css" media="screen">
        <script language="javascript" src="<c:url value="/js/jquery-1.7.1.min.js"/>"></script>
        <script language="javascript" src="<c:url value="/js/ValidateInput.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-ui-1.8.21.custom.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery.uniform.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/shadow-jquery.js"/>"></script>
        <link rel="stylesheet" href="css/uniform.aristo.css" type="text/css" media="screen" charset="utf-8" /> 
        <link href="css/smart_wizard.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="<c:url value="/js/jquery.smartWizard-2.0.js"/>"></script>
         <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&amp;language=es"></script>
        <script type="text/javascript" src="<c:url value="/js/Maps.js"/>"></script>
        <link href="css/confirmBoxes.css" rel="stylesheet" type="text/css" media="screen">
        <script language="javascript" type="text/javascript">

            var fSelectMap=false;
            var fSelectDistrito=false;
            
            $(function() {
                $(".itemFormulario").uniform();
            });

            function validateEMail()
            {
                if ($("#idUser").val().indexOf('@', 0) == -1 || $("#idUser").val().indexOf('.', 0) == -1)
                    return false;
                //if (($("#idUser").val().indexOf('pucp.pe',0)==-1) || ($("#idUser").val().indexOf('pucp.edu.pe',0)==-1)) return false;
                return true;
            }
            
             function closeBox(){
                 
                $("#chkVehículo").prop("checked",false);
                ActiveForm();
                $('#box').animate({'top':'-700px'},500,function(){
                    $('#overlay').fadeOut('fast');
                });
            };

            $(function(){
                $('#phoneContact').validCampoFranz('0123456789')
            });

            function VerifyStep2()
            {
                if ($("#name").val() == '' || $("#app").val() == '' || $("#apm").val() == '')
                {   
                        $("#msgAlertaStep2").show();
                        $('#divLoading').hide();
                        return false;
                }
                
                if ($("#phoneContact").val()!='')
                    {
                        if ($("#phoneContact").val().length<9){
                            $("#msgAlertaStep2Phone").show();
                            $('#divLoading').hide();
                            return false;
                        }           
                        else return true;
                    }
                
                return true;
            }

            function redirect_ajax(purl, pid_div)
            {
                $('#divLoading').show();
                $.ajax({
                    type: 'post',
                    async: true,
                    url: purl,
                    data: "idUser=" + $('#idUser').val() +
                            "&name=" + $('#name').val() +
                            "&app=" + $('#app').val() +
                            "&apm=" + $('#apm').val() +
                            "&password=" + $('#password').val() +
                            "&idCar=" + $('#idCar').val() +
                            "&descCar=" + $('#descCar').val() +
                            "&fCheckUseCar="+ $("#chkVehículo").is(":checked")+
                            "&phoneContact=" + $('#phoneContact').val() +
                            "&idEntity=" + $("#selectEntity").val() +
                            "&idUserIntoEntity=" + $("#idUserIntoEntity").val() +
                            "&locationMap=" +$("#idPositionMap").val()+
                            "&idDistrit=" +$("#selectDistrito").val()+
                            "&chkBigCar=" +$("#chkBigCar").is(":checked")+
                            "&rnd=" + Math.random(),
                    success: function(data) {
                        $('#divLoading').hide();
                        location.href="welcome.htm"
                    }
                });
            }
            function registerUser()
            {
                redirect_ajax("<c:url value="/reg/registerCompleted.htm" />", "contenido");
            }
            
           
            
            function VerifyStep1()
                    {
                        $('#divLoading').show();
                        var resp=false;
                        if ($("#idUser").val()=='')
                        {
                            $("#msgErrorUser").hide();
                            $("#msgAlertaUser").show();
                            $('#divLoading').hide();
                            return false;
                        }
                        
                        if ($("#idUserIntoEntity").val()=='')
                            {
                                $("#msgAlertaCod").show();
                                $('#divLoading').hide();
                                return false;
                            }

                        if (!validateEMail())
                        {
                            $("#msgAlertaUser").show();
                            $('#divLoading').hide();
                            return false;
                        }
                        
                        if ($("#password").val()=='')
                            {
                                $("#msgAlertaPass").show();
                                $('#divLoading').hide();
                                return false;
                            }
                            else
                            {
                                if (($("#password").val() != $("#passwordCopy").val()))
                                {
                                    $("#msgAlertaPass").show();
                                    $('#divLoading').hide();
                                    return false;
                                }
                            }
                                    
                        
                        purl = "<c:url value="/reg/verifyIdUserInRegister.htm" />"
                        $.ajax({
                            type: 'post',
                            async: false,
                            url: purl,
                            data: "idUserInRegister=" + $('#idUser').val() +
                                    "&idEntity=" +$("#selectEntity").val()+
                                    "&rnd=" + Math.random(),
                            
                            success: function(data) {
                                
                                $('#divLoading').hide();
                                if (data == true)
                                {
                                    $("#msgErrorUser").show();
                                    $("#msgExitoUser").css("display", "none")
                                    $("#msgAlertaUser").css("display", "none");
                                    resp= false;
                                    
                                    
                                }
                                else
                                {
//                                    $("#msgExitoUser").css("display", "block")
//                                    $("#msgErrorUser").css("display", "none")
//                                    $("#msgAlertaUser").css("display", "none");
                                    resp= true;
                                }
                            }
                            
                        });
                        return resp;
            }
                    
             function VerifyStep3()
                    {
                        $('#divLoading').show();
                        if ($("#chkVehículo").is(":checked") && ($("#idCar").val()=="" || $("#descCar").val()==""))
                            {
                                $("#msgAlertaCarDatos").show();
                                $('#divLoading').hide();
                                return false;
                            }
                        
                        purl = "<c:url value="/reg/verifyIdCarInRegister.htm" />";
                        
                        $.ajax({
                            type: 'post',
                            async: false,
                            url: purl,
                            data: "idCarInRegister=" + $('#idCar').val() +
                                    "&rnd=" + Math.random(),
                            success: function(data) {
                                $('#divLoading').hide();
                                if (data == true)
                                {
                                    $("#msgErrorCar").css("display","block");
                                    $("#msgAlertaCar").css("display","none");
                                    $("#msgExitoCar").css("display","none");
                                    return false;
                                }
                                else
                                {
//                                    $("#msgExitoCar").css("display","block");
//                                    $("#msgErrorCar").css("display","none");
//                                    $("#msgAlertaCar").css("display","none");
                                    registerUser();
                                     return true;
                                }

                            }
                        });
                    }

            function loadSelect()
            {
                var cont = 0;
                <c:forEach items='${listaDistritos}' var="distrito">
                    $("<option value="+cont+">${distrito}</option>").appendTo("#selectDistrito");  
                       cont++; 
                </c:forEach>
                $("<option value="+cont+">--Elija un distrito--</option>").appendTo("#selectDistrito");  
                 $("#selectDistrito").val(cont);
                 
                var cont=0;
                <c:forEach items='${listaEntity}' var="entity">
                    $("<option value=" + cont + ">${entity}</option>").appendTo("#selectEntity");
                    cont++;
                </c:forEach>

                    $("#selectEntity").val(cont);
                    cont = 0;
                    $.uniform.update();
            }

            function activePopUp()
            {
                $('#overlay').fadeIn('fast',function(){
                    $('#box').animate({'top':'50px'},500);
                });
            }
            
            function boxCompleted()
            {
                ActiveForm();
                $('#box').animate({'top':'-700px'},500,function(){
                    $('#overlay').fadeOut('fast');
                });
            }
        
            function ActiveForm()
            {
                if ($("#chkVehículo").is(':checked'))
                    {
                       $("#idCar").prop("disabled",false);
                       $("#descCar").prop("disabled",false); 
                       $("#chkBigCar").prop("disabled",false);
                       $("#stepMap").prop("disabled",true);
                       activePopUp();
                    }
                    else
                    {
                       $("#idCar").prop("disabled",true);
                        $("#descCar").prop("disabled",true);
                        $("#chkBigCar").prop("disabled",true);
                        
                    }
            }

                $(document).ready(function()
                {
                    loadSelect();
                    $('#wizard').smartWizard();
                    $('#idUserIntoEntity').validCampoFranz('0123456789')
                    $("#idUser").keydown(function()
                    {
                        sectionIntroGainedNull = 0;
                        $("#msgErrorUser").css("display", "none");
                    })

                    $("#password,#passwordCopy").keydown(function()
                    {
                        $("#msgAlertaPass").css("display", "none");
                    })
                    
                     $("#selectDistrito").change(function()
                    {
                        if ($("#selectDistrito option:selected").html()!="--Elija un distrito--")
                            {fSelectDistrito=true;
                             if (fSelectMap==true) $("#stepMap").prop("disabled",false);   
                            }
                            else $("#stepMap").prop("disabled",true);

                    })
                    
                    $("#mapGoogle").click(function()
                    {
                        fSelectMap=true;
                        if (fSelectDistrito==true) $("#stepMap").prop("disabled",false);
                    })
                    
                    
                    
                    $("#iconMaleta").mouseover(function()
                    {
                        $("#msgInfoMaletera").show();
                    })
                    
                    $("#iconMaleta").mouseleave(function()
                    {
                        $("#msgInfoMaletera").hide();
                    })
                })

        </script>


    </head>

    
    <body id="bodyRegister">
        <div id="divLoading" style="display:none;width:98%;height:98%;position:absolute;background-color: #4e5b6c;z-index:999999;filter:alpha(opacity=30); opacity:0.3;">
            <img style="top:30%;left:40%;position:absolute" src="images/loading.gif"/>
        </div>
        <div style="padding-top: 80px">
        <table align="center" border="0" cellpadding="0" cellspacing="0">
            <tr><td> 
                    <div id="wizard" class="swMain">
                        <ul>
                            <li><a href="#step-1">
                                    <span class="stepNumber">1</span>
                                    <span class="stepDesc">
                                        Datos de Cuenta<br />
                                        <small></small>
                                    </span>
                                </a></li>
                            <li><a href="#step-2">
                                    <span class="stepNumber">2</span>
                                    <span class="stepDesc">
                                        Datos Personales<br />
                                        <small></small>
                                    </span>
                                </a></li>
                            <li><a href="#step-3">
                                    <span class="stepNumber">3</span>
                                    <span class="stepDesc">
                                        Datos Vehiculares<br />
                                        <small></small>
                                    </span>                   
                                </a></li>
                        </ul>

                        <div id="step-1">	
                            <h2 class="StepTitle">Acerca de tu nueva cuenta</h2>
                            <div style="position:relative;top:20px;left :200px">
                                <table>
                                    <tr>
                                        <td>Ingrese su correo eléctronico(*):</td>
                                        <td><input class="itemFormulario" type="text" id="idUser" ></td>
                                    </tr>

                                    <div style="position: absolute;top:-10px;left:500px;display: none;" id="msgErrorUser" class="error">Esta dirección de correo<br> ya está siendo usada.</div>
                                    <div style="position: absolute;top:-10px;left:500px;display: none;" id="msgExitoUser" class="exito">Correcto.</div>
                                    <div style="position: absolute;top:-10px;left:500px;display: none;" id="msgAlertaUser" class="alerta">Esta dirección parece<br>no válida.<br><br>Solo está permitido el correo <br>pucp.pe o pucp.edu.pe</div>

                                    <tr>
                                        <td>Ingrese su código de universidad</td>
                                        <td><input onpaste="return false" class="itemFormulario" type="text" id="idUserIntoEntity" maxlength="8"></td>
                                    </tr>

                                    <tr>
                                        <td>Ingrese un password(*):</td>
                                        <td><input class="itemFormulario" type="password" id="password" ></td>
                                    </tr>
                                    <div style="position: absolute;top:100px;left:500px;display: none;" id="msgAlertaPass" class="alerta">Passwords no coinciden.</div>
                                    <tr>
                                        <td>Reingrese su password(*):</td>
                                        <td><input class="itemFormulario" type="password" id="passwordCopy" ></td>
                                    </tr>

                                    <tr>
                                        <td>Seleccione su universidad(*):</td>
                                        <td><select class="itemFormulario" id="selectEntity"></select></td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                        <div id="step-2" >
                            <h2 class="StepTitle">Acerca de ti.</h2>	
                            <div style="position:relative;top:20px;left :200px">
                                <div style="position: absolute;top:-10px;left:500px;display: none;" id="msgAlertaStep2" 
                                     class="alerta">Asegúrese que todos los<br> campos(*) estén llenos</div>
                                <div style="position: absolute;top:90px;left:500px;display: none;" id="msgAlertaStep2Phone" 
                                     class="alerta">Asegúrese que el número telefónico<br> ingresado tenga 9 dígitos</div>
                                     
                                <table>
                                    <tr>
                                        <td>Ingrese su nombre(*):</td>
                                        <td><input class="itemFormulario" type="text" id="name" ></td>
                                    </tr>
                                    <tr>    
                                        <td>Ingrese sus apellido paterno(*):</td>
                                        <td><input class="itemFormulario" type="text" id="app" ></td>
                                    </tr>
                                    <tr>
                                        <td>Ingrese sus apellido materno(*):</td>
                                        <td><input class="itemFormulario" type="text" id="apm" ></td>
                                    </tr>
                                    <tr>
                                        <td>Ingrese algún número de contacto</td>
                                        <td><input maxlength="9" class="itemFormulario"  type="text" id="phoneContact" ></td>
                                    </tr>
                                </table>
                            </div>
                        </div>                      

                        <div id="step-3" >
                                              
                            <h2 class="StepTitle">Acerca de tu vehículo.</h2>	
                            <div style="position:relative;top:20px;left :200px">
                                
                                <input id="chkVehículo"type="checkbox" onclick="ActiveForm()">Poseo un vehículo y deseo inscribirlo.
                                <table>
                                    <tr>
                                        <td>Ingrese la placa de su vehículo(*):</td>
                                        <td><input maxlength="6" disabled="true" class="itemFormulario" type="text" id="idCar" ></td>
                                        <td><code>Por ejm: ABC123</code></td>
                                    </tr>
                                    <div style="position: absolute;top:-10px;left:500px;display: none;" id="msgErrorCar" class="error">Este número de placa ya está <br>siendo utlizado.</div>
                                    <div style="position: absolute;top:-10px;left:500px;display: none;" id="msgAlertaCar" class="alerta">Este número de placa<br> parece no válido</div>
                                    <div style="position: absolute;top:-10px;left:500px;display: none;" id="msgExitoCar" class="alerta">Correcto.</div>
                                    
                                    <div style="position: absolute;top:10px;left:500px;display: none;" id="msgAlertaCarDatos" class="alerta">Complete los datos del vehículo</div>
                                    <tr>
                                        <td>Ingrese alguna descripción de su vehículo:</td>
                                        <td><textarea disabled="true" maxlength="500" style="resize: none;width: 155px"
                                             class="itemFormulario" id="descCar"></textarea></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Posee una amplia maletera?: 
                                            <img src="images/info_icon.png" height="8%" id="iconMaleta"/>
                                        </td>
                                        <div style="position:absolute;z-index: 10;display: block;" id="msgInfoMaletera" class="alerta">
                                                Algunos compañeros necesitarán<br>
                                                transportar algún tipo de trabajo.<br>
                                                El precio del pasaje se incrementará<br>
                                                por este servicio extra.
                                        </div>
                                        <td><input id="chkBigCar" disabled="true" type="checkbox" value="Sí">Sí</td>
                                    </tr>
                                </table>
                        </div>
                            <br>
                    </div>
                </td></tr>
        </table>  
        </div>
                    
                    
        <div class="overlay" id="overlay" style="display:none"></div>
        <div class="box" id="box" style="width: 600px; ">
            <a class="boxclose" id="boxclose" onclick="closeBox()"></a>
            <h1>Selecciona tu lugar de destino</h1>
            <h6>Solo es necesario un click para marcar tu destino.</h6>
                <div>
                    <div id="mapGoogle" style="width: 600px;height: 400px;z-index:9999999;"></div>
                    <div ><h3>Distrito:</h3><select  class='itemFormulario' id="selectDistrito"></select> </div>
                </div>
            
            <input id="stepMap" type="button" value="Hecho" onclick='boxCompleted()'>

        </div>
        
        <input type="text" hidden="true" id="idPositionMap">
    </body>

</html>