<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script type="text/javascript" language="javascript">
    
    var selectDist=false;
    var mapGG=false;
    
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
            location.reload();
        };
    
    function ActiveForm()
            {
                if ($("#chkVehículo").is(':checked'))
                    {
                       $("#idCar").prop("disabled",false);
                       $("#descCar").prop("disabled",false); 
                       $("#bigCar").prop("disabled",false);
//                       activePopUp();
                        $("#divMap").show()
                        saveGoogleMaps();
                        loadSelects();
                    }
                    else
                    {
                       $("#idCar").prop("disabled",true);
                        $("#descCar").prop("disabled",true);
                        $("#bigCar").prop("dimsabled",true);
                        $("#divMap").hide()
                        
                    }
            }
            
            function updateUserAjax()
            {
                purl = "<c:url value="/usr/updateUser.htm" />";
                
                $.ajax({
                    type: 'post',
                    async: true,
                    url: purl,
                    data:  "name=" + $('#userName').val() +
                            "&app=" + $('#userApp').val() +
                            "&apm=" + $('#userApm').val() +
                            "&idCar=" + $('#idCar').val() +
                            "&descCar=" + $('#descCar').val() +
                            "&fCheckUseCar="+ $("#chkVehículo").is(":checked")+
                            "&fCheckBigCar="+ $("#bigCar").is(":checked")+
                            "&phoneContact=" + $('#userPhoneContact').val() +
                            "&idUserIntoEntity=" + $("#userIdEntity").val() +
                            "&locationMap=" +$("#idPositionMap").val()+
                            "&idDistrit=" +$("#selectDistrito").val()+
                            "&rnd=" + Math.random(),
                    success: function(data) {

                        activePopUp();
                    }
                });                
            }
            
         function checkIdCarStep3()
                    {
                        purl = "<c:url value="/reg/verifyIdCarInRegister.htm" />";
                        $.ajax({
                            type: 'post',
                            async: true,
                            url: purl,
                            data: "idCarInRegister=" + $('#idCar').val() +
                                    "&rnd=" + Math.random(),
                            success: function(data) {
                                if (data == true)
                                {
                                    $("#msgErrorCar").show();
                                    $("#msgAlertaCar").hide();
                                    $("#msgExitoCar").hide();
                                }
                                else
                                {
                                    $("#msgErrorCar").css("display","none");
                                    $("#msgAlertaCar").css("display","none");
                                    updateUserAjax();
                                }
                            }
                        });
                    }
            
     $("#btnEdit").click(function ()
     {
                $("#uniform-btnEdit").hide();
                $("#userName").prop("disabled",false);
                $("#password").prop("disabled",false);
                $("#passwordCopy").prop("disabled",false);
                $("#userApp").prop("disabled",false);
                $("#userApm").prop("disabled",false);
                $("#userPhoneContact").prop("disabled",false);
                $("#userIdEntity").prop("disabled",false);
                $("#chkVehículo").prop("disabled",false);
                $("#uniform-btnSave").show();
                $("#divSave").show();
                
//                if ($("#chkVehículo").is(':checked'))
//                {
//                    $("#idCar").prop("disabled",false);
//                    $("#descCar").prop("disabled",false);
//                    $("#bigCar").prop("disabled",false);
//                    $("#divMap").prop("disabled",false);
//                    
//                }
    })
    
    $("#savePass").click(function ()
    {
        if ($("#passwordCopy").val()==$("#password").val())
            {
        
                    purl = "<c:url value="/jsp/updatePassword.htm" />";
                        $.ajax({
                            type: 'post',
                            async: true,
                            url: purl,
                            data: "password=" + $('#password').val() +
                                    "&rnd=" + Math.random(),
                            success: function(data) {
                                activePopUp();
                            }
                        });
            }
            else
            {
            
                alert("error")
                        
            }
    })
    
    $("#btnSave").click(function ()
    {
        
        if ( ($("#userName").val()!="") && ($("#userApp").val()!="") && ($("#userApm").val()!="") 
             && ($("#userIdEntity").val()!=""))
        {
            
            if ($("#chkVehículo").is(":checked"))
                {
                    if (($("#idCar").val()!="") && ($("#descCar").val()!="") && selectDist && mapGG)
                        checkIdCarStep3();
                    else
                        $("#msgAlertaEmptyUser").show();
                }
            else
                updateUserAjax(); 
        }
        else
            {
             $("#msgAlertaEmptyUser").show();
            }
    })
            
    
    $("#mapGoogle").click(function()
    {
        mapGG=true;
    })
    
    $("#chkVehículo").click(function()
    {
        if( $(this).is(':checked') )
            {
                if (("<%=session.getAttribute("USER_IDCAR")%>")!='null')
                {
                        $(this).prop("checked",false);
                        $("#msgAlertaUserWithCar").show();
                }
                else
                    ActiveForm();
            }
    })
    
    $("#selectDistrito").change(function()
    {
        if ($("#selectDistrito option:selected").html()=="--Elija un distrito--")
            selectDist=false;
        else
            selectDist=true;
    })
    
    function  loadSelects()
        {
            var cont=0;
               <c:forEach items='${listaDistrito}' var="distrito">
                   $("<option value="+cont+">${distrito.nameDistrit}</option>").appendTo("#selectDistrito");  
                       cont++; 
               </c:forEach>
                   $("<option value="+cont+">--Elija un distrito--</option>").appendTo("#selectDistrito");  
            
             $("#selectDistrito").val(cont);
             $.uniform.update();
        }
    $(document).ready(function ()
    {
        $(".itemFormulario").uniform();
        $('#userName').validCampoFranz(' abcdefghijklmnñopqrstuvwxyzáéiou');
        $('#phoneContact').validCampoFranz('0123456789');
        $("#idUserIntoEntity").validCampoFranz('0123456789');
    })
    
    
</script>

<div style="position: absolute;top:150px;left:300px;display: none;" id="msgAlertaEmptyUser" class="alerta">Oops!. Uno de los campos parece estar vacío o inválido</div>
<div style="position: absolute;top:150px;left:300px;display: none;" id="msgAlertaUserWithCar" class="alerta">Oops!. Actualmente ya tienes un vehículo inscrito</div>

<div style="" id="divNotPass">
    
    <div style="margin:0 0px 0 0px;float:left">
        <table style="margin-bottom: 30px">
            <tbody >
                <tr height="50px"><td>Nombres:</td><td><input id="userName" disabled="true" type="text" value="${userName}" maxlength="40"></td><tr>
                <tr height="50px"><td>Ap. Paterno:</td><td><input id="userApp" disabled="true" type="text" value="${userApp}" maxlength="40"></td></tr>
                <tr height="50px"><td>Ap. Materno:</td><td><input id="userApm" disabled="true" type="text" value="${userApm}" maxlength="40"> </td></tr>
                <tr height="50px"><td>Número de contacto:</td><td><input id="userPhoneContact" disabled="true" type="text" maxlength="9" value="${userPhoneContact}"></td></tr>
                <tr height="50px"><td>Código en institución:</td><td><input id="userIdEntity" disabled="true" type="text" value="${userIdEntity}" maxlength="8"></td></tr>
                
            </tbody>
        </table>
            <a href="#"onclick="$('#divPassword').show();$('#divNotPass').hide();$(this).hide()">Cambiar mi contraseña</a>
            <div style="margin-left:100px"><input style="margin-left:100px" class='btnCustom' id="btnEdit" type="button" class="itemFormulario" value="Editar"></div>
            <div id="divSave" style="margin-left:100px;display:none"><input clas='btnCustom' style="margin-left:100px;" id="btnSave" type="button" class="itemFormulario" value="Guardar cambios"></div>
    </div>
    
    <div style="margin-left:40%">
            <div style="position: absolute;top:150px;left:900px;display: none;" id="msgErrorCar" class="error">Este número de placa ya está <br>siendo utlizado.</div>
            <div style="position: absolute;top:150px;left:900px;display: none;" id="msgAlertaCar" class="alerta">Este número de placa<br> parece no válido</div>
            <!--<div style="position: absolute;top:150px;left:900px;display: none;" id="msgExitoCar" class="alerta">Correcto.</div>-->
    <table style="margin-bottom: 30px">
        <tbody>
            <tr height="50px">
                <td><input id="chkVehículo" class="itemFormulario" type="checkbox" disabled="true" >
            Poseo un vehículo y deseo inscribirlo.</td>
            </tr>
            <tr height="50px">
                <td>Ingrese la placa de su vehículo(*):</td>
                <td><input maxlength="6" disabled="true" class="itemFormulario" type="text" id="idCar" ></td>
                <!--<td><code>Por ejm: ABC123</code></td>-->
            </tr>
            <tr height="50px">
                <td>Ingrese alguna descripción de su vehículo:</td>
                <td><textarea disabled="true" maxlength="500" style="resize: none;width: 155px"
                     class="itemFormulario" id="descCar"></textarea></td>
            </tr>
            <tr height="50px">
                <td>Posee una amplia maletera?:</td>
                <td><input id="bigCar" disabled="true" type="checkbox" value="Sí" ></td>
            </tr>
        </tbody>
    </table>
    
                <div id="divMap" hidden="true">
                    <div ><h3>Distrito:</h3><select  class='itemFormulario' id="selectDistrito"></select> </div>
                    <div id="mapGoogle" style=" width: 500px;height: 300px;"></div>
                </div>
                <input type="text" hidden="true" id="idPositionMap">
    </div>
    
    
    
</div>
<div id="divPassword" style="display: none">
    <div style="margin:0 80px 0 130px;float:left">  
    <table style="margin-bottom: 30px">
        <tbody>
                         
                <tr id="trPass" height="50px"><td>Ingrese su nueva contraseña:</td><td><input id="password" type="password" value=""></td><tr>
                <tr id="trPassCopy" height="50px"><td>Ingrese nuevamente su nueva contraseña:</td><td><input id="passwordCopy" type="password" value=""></td></tr>             
        </tbody>
       </table>
        <input id="savePass" class='btnCustom' type="button" class="itemFormulario" value="Guardar">
    </div>               
</div>
                
<div class="overlay" id="overlay" style="display:none;"></div>
 
<div class="box" id="box">
    <a class="boxclose" id="boxclose" onclick="closeBox()"></a>
    <h1>Confirmación de Eliminación</h1>
  
        <div id="divInfoTrip" style="float: left">
            <p>Sus datos han sido guardados satisfactoriamente</p>
       </div>
</div>
                    
