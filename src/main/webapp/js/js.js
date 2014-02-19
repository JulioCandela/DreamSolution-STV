var blnPuerto;
var intDenominacion;

//------------------------------------------------------------------------

//modificando
//$(function () {
//	$('#defaultKeypad').keypad();
//});
function fnabreTeclado() {
        alert("abrio");
}

function fnprueba(){
    alert("OK");
}
//fin modificando
//------------------------------------------------------------------------
function enviar_dni(purl)
{
    //alert(purl);    
    $.ajax({
        type            : 'post',
        url             : purl,
        data            : 'cantidad=' + $("#cantidad").val() + "&rnd=" + Math.random(),
        success         : function(data){
            //alert(data);
            $("#formulario_dni").html(data);
        },
        error           : function(req, err){
            $("#formulario_dni").html(req.status);
        }
    })
}
//--------------------------------
function enviar_datos(purl)
{
    //alert(purl);    
    $.ajax({
        type            : 'post',
        url             : purl,
        data            : 'cantidad=' + $("#cantidad").val() + "&rnd=" + Math.random(),
        success         : function(data){
            //alert(data);
            $("#form_compra").html(data);
        },
        error           : function(req, err){
            $("#form_compra").html(req.status);
        }
    })
}
//------------------------------------------------------------------------

//function redirect_ajax(purl, pid_div)
//{
//    alert("redireccionaGet")
//    $.ajax({
//        type                    : 'get',
//        async                   : true,
//        url                     : purl,
//        data                    : "&rnd=" + Math.random(),
//        success                 : function(data){            
//            $("#" + pid_div).html(data);
//        }
//    })
//}


function redirect_ajax(purl, pid_div)
{
//    alert("redireccionaGet")
    $.ajax({
        type                    : 'get',
        async                   : true,
        url                     : purl,
        data                    : "&rnd=" +2,
        success                 : function(data){            
            $("#" + pid_div).html(data);
        }
    })
}
//------------------------------------------------------------------------

//------------------------------------------------------------------------
function redirect_ajax_post(purl, pid_div)
{
    //alert("redirecciona");
   // alert("efectuar pago en " +purl);
    $.ajax({
        type                    : 'post',
        async                   : true,
        url                     : purl,
        data                    : "rnd=" + Math.random(),
        success                 : function(data){            
            $("#" + pid_div).html(data);
        }
    })
}

function registrarPago(purl,rdnTipo,selValor,txtCantidad)
{
    $.ajax({
        type                    : 'get',
        async                   : true,
        url                     : purl,
        data                    : 'rdnTipo='            + rdnTipo + 
                                    '&selValor='        + selValor + 
                                    '&txtCantidad='     + txtCantidad + 
                                    '&rnd='             + Math.random(),
        success                 : function(data){
            $("#acumulado_dinero").html(data);
            //alert($("#totIngresado").val());
            //alert($("#totMonto").val());
            if(Math.abs($("#totIngresado").val()) >= Math.abs($("#totMonto").val())){            
                //alert("entra");
                $("#btnProcesarPago").attr("disabled", false);                 
                procesar();
            }
        }
    })    
}
//------------------------------------------------------------------------
function muestra_opciones()
{
    //alert($("input:radio[name=rdnTipo]:checked").val());
    var valorRdn = $("input:radio[name=rdnTipo]:checked").val();
    var strSel;
    
    if(valorRdn == "billete")
    {   
        strSel = '<option value="100">100</option>' + 
                     '<option value="50">50</option>' + 
                     '<option value="20">20</option>' + 
                     '<option value="10">10</option>';
    }
    else
    {
        strSel = '<option value="5">5</option>' + 
                     '<option value="2">2</option>' + 
                     '<option value="1">1</option>' + 
                     '<option value="0.5">0.5</option>';        
    }
    
    $("#selValor").html(strSel);
}
//------------------------------------------------------------------------
function ingresar_dinero_simulador(purl)
{
    alert("ingreso dinero simulador");
    var rdnTipo         = $("input:radio[name=rdnTipo]:checked").val();
    var selValor        = $("#selValor").val();
    var txtCantidad     = $("#txtCantidad").val();    
    
    $.ajax({
        type                    : 'get',
        async                   : true,
        url                     : purl,
        data                    : 'rdnTipo='            + rdnTipo + 
                                    '&selValor='        + selValor + 
                                    '&txtCantidad='     + txtCantidad + 
                                    '&rnd='             + Math.random(),
        success                 : function(data){
            $("#acumulado_dinero").html(data);
        }
    })
}
//------------------------------------------------------------------------
function ingresar_dinero(purl)
{
    alert("ingreso dinero");
    var rdnTipo         = $("input:radio[name=rdnTipo]:checked").val();
    var selValor        = $("#selValor").val();
    var txtCantidad     = $("#txtCantidad").val();    
    
    $.ajax({
        type                    : 'get',
        async                   : true,
        url                     : purl,
        data                    : 'rdnTipo='            + rdnTipo + 
                                    '&selValor='        + selValor + 
                                    '&txtCantidad='     + txtCantidad + 
                                    '&rnd='             + Math.random(),
        success                 : function(data){
            $("#acumulado_dinero").html(data);
        }
    })
}
////------------------------------------------------------------------------
//function procesar()
//{
//    //alert("procesar");
//    var objApplet = document.getElementById("billeteroMEI");        
//    objApplet.detenerHilo();
//    objApplet.destroy();
//
//    var objMonedero = document.getElementById("monedero");
//    objMonedero.detenerHilo();
//    objMonedero.destroy();
//
//    redirect_ajax_post('<c:url value="/efectuar_pago.htm" />', 'div_cuerpo_ajax');
//}

//function getDenominacion(purl, monto)
//{
//    intDenominacion = monto;
//    
//    //alert('valor : '+response);
//    var rdnTipo         = "Billete";
//    var selValor        = intDenominacion;
//    var txtCantidad     = 1;     
//    registrarPago(purl,rdnTipo,selValor,txtCantidad);   
////    $.ajax({
////        type                    : 'get',
////        async                   : true,
////        //url                     : baseUrl + "ingreso_dinero.htm",
////        url                     : "ingreso_dinero.htm",
////        data                    : 'rdnTipo='            + rdnTipo + 
////                                    '&selValor='        + selValor + 
////                                    '&txtCantidad='     + txtCantidad + 
////                                    '&rnd='             + Math.random(),
////        success                 : function(data){
////            $("#acumulado_dinero").html(data);
////            //alert($("#totIngresado").val());
////            //alert($("#totMonto").val());
////            if(Math.abs($("#totIngresado").val()) >= Math.abs($("#totMonto").val())){            
////                //alert("entra");
////                $("#btnProcesarPago").attr("disabled", false); 
////                
////                procesar();
////            }
////        }
////    })     
//}


        
//function getMoneda(response)
//{
//    intDenominacion = response;
//    
//    //alert('moneda valor : '+response);
//    var rdnTipo         = "Moneda";
//    var selValor        = intDenominacion;
//    var txtCantidad     = 1;     
//    var purl = '<c:url value="/ingreso_dinero.htm" />';
//    registrarPago(purl,rdnTipo,selValor,txtCantidad);     
////    $.ajax({
////        type                    : 'get',
////        async                   : true,
////        //url                     : baseUrl + "ingreso_dinero.htm",
////        url                     : "ingreso_dinero.htm",
////        data                    : 'rdnTipo='            + rdnTipo + 
////                                    '&selValor='        + selValor + 
////                                    '&txtCantidad='     + txtCantidad + 
////                                    '&rnd='             + Math.random(),
////        success                 : function(data){
////            $("#acumulado_dinero").html(data);
////            //alert($("#totIngresado").val());
////            //alert($("#totMonto").val());
////            if(Math.abs($("#totIngresado").val()) >= Math.abs($("#totMonto").val())){            
////                //alert("entra");
////                $("#btnProcesarPago").attr("disabled", false);  
////                
////                procesar();
////                
////            }
////        }
////    })     
//}
//------------------------------------------------------------------------
// -------------------------  PARA BILLETERO MEI--------------------------


//------------------------------------------------------------------------
function getBaseUrl(purl)
{
    baseUrl = url;
}
//------------------------------------------------------------------------


//======================================================

function xmlhttpPost(strURL,formname,responsediv) {

    var xmlHttpReq = false;

    var self = this;

    // Xhr per Mozilla/Safari/Ie7
//alert("alert1");
    if (window.XMLHttpRequest) {

        self.xmlHttpReq = new XMLHttpRequest();
//        alert("alert2"+self.xmlHttpReq.responseText);
    }

    // per tutte le altre versioni di IE

    else if (window.ActiveXObject) {
//alert("alert3"+self.xmlHttpReq.responseText);
        self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");

    }
//alert("alert4"+self.xmlHttpReq.responseText);
    self.xmlHttpReq.open('POST', strURL, true);

    self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    self.xmlHttpReq.onreadystatechange = function() {
//    alert("alert5"+self.xmlHttpReq.responseText);
        if (self.xmlHttpReq.readyState == 4) {

			// Quando pronta, visualizzo la risposta del form
//alert("alert6"+self.xmlHttpReq.responseText);
            updatepage(self.xmlHttpReq.responseText,responsediv);

        }

		else{

			// In attesa della risposta del form visualizzo il msg di attesa

			//updatepage(responsemsg,responsediv);



		}

    }

//    alert("alert3"+self.xmlHttpReq.responseText);
    self.xmlHttpReq.send(getquerystring(formname));

}



function getquerystring(formname) {

    var form = document.forms[formname];

	var qstr = "";



    function GetElemValue(name, value) {

        qstr += (qstr.length > 0 ? "&" : "")

            + escape(name).replace(/\+/g, "%2B") + "="

            + escape(value ? value : "").replace(/\+/g, "%2B");

			//+ escape(value ? value : "").replace(/\n/g, "%0D");

    }

	

	var elemArray = form.elements;

    for (var i = 0; i < elemArray.length; i++) {

        var element = elemArray[i];

        var elemType = element.type.toUpperCase();

        var elemName = element.name;

        if (elemName) {

            if (elemType == "TEXT"

                    || elemType == "TEXTAREA"

                    || elemType == "PASSWORD"

					|| elemType == "BUTTON"

					|| elemType == "RESET"

					|| elemType == "SUBMIT"

					|| elemType == "FILE"

					|| elemType == "IMAGE"

                    || elemType == "HIDDEN")

                GetElemValue(elemName, element.value);

            else if (elemType == "CHECKBOX" && element.checked)

                GetElemValue(elemName, 

                    element.value ? element.value : "On");

            else if (elemType == "RADIO" && element.checked)

                GetElemValue(elemName, element.value);

            else if (elemType.indexOf("SELECT") != -1)

                for (var j = 0; j < element.options.length; j++) {

                    var option = element.options[j];

                    if (option.selected)

                        GetElemValue(elemName,

                            option.value ? option.value : option.text);

                }

        }

    }

    return qstr;

}

function updatepage(str,responsediv){

    document.getElementById(responsediv).innerHTML = str;

}



 function impr(){
                var objImpresora = document.getElementById("impresora");
               
            }
