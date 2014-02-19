<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="../css/Generic.css" rel="stylesheet" type="text/css" media="screen">
        <link href="../css/confirmBoxes.css" rel="stylesheet" type="text/css" media="screen">
        <link href="../css/WelcomePageStyle.css" rel="stylesheet" type="text/css" media="screen">
        <title>Súbete.com! - Bienvenido</title>
        <script language="javascript" src="<c:url value="/js/jquery-1.7.1.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-ui-1.8.21.custom.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery.uniform.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/shadow-jquery.js"/>"></script>
        <link rel="stylesheet" href="../css/uniform.aristo.css" type="text/css" media="screen" charset="utf-8" /> 
        <link href="../css/RegisterUserStyle.css" rel="stylesheet" type="text/css" media="screen">
         <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&amp;language=es"></script>
        <script type="text/javascript" src="<c:url value="/js/Maps.js"/>"></script>
        <script language="javascript" src="<c:url value="/js/ValidateInput.js"/>"></script>
        <link rel="stylesheet" type="text/css" href="../css/zoomStyleLogin.css" />
        <script type="text/javascript">
        
        $(function(){
            $("textarea, select, button").uniform();
        });
        
        function redirect_ajax(purl, pid_div)
        {
            
            $("#divLoading").show();
            $.ajax({
                
                type                    : 'get',
                async                   : true,
                url                     : purl,
                data                    : "rnd=" +Math.random(),
                success                 : function(data){            
                    $("#" + pid_div).html(data);
                    $("#divLoading").hide();
                }
            });
        }
        
        function checkPage()
        {
            <c:if test="${urlDir!='login'}">
                    $("#btnLogOut").css("display","inline");
            </c:if>
            <c:if test="${urlDir=='logout'}">
                    $("#btnLogOut").css("display","none");
            </c:if>
        }
        
        function updateScreen()
        {
            var viewport = document.querySelector("meta[name=viewport]");
            
            var res=screen.width;
            var init_sc=0;
            if (res>=240 && res<=319) init_sc=0.17; 
            if (res>=320 && res<=479) init_sc=0.22;
            if (res>=480 && res<=767) init_sc=0.1;
            if (res>=768 && res<=1023)init_sc=0.75;
            if (res>=1024 && res<=1279) init_sc=0.77;
            if (res>=1280) init_sc=0.4;
            
            viewport.setAttribute
            ('content', 'width=device-width,initial-scale='+init_sc+',user-scalable=yes');
        }
        
      
    
    function efxBtnClickDown(obj)
    {
//        $('#'+obj.id).stop().animate({boxShadow: '3px 3px 3px',top:(obj.style.top+5)}, 'fast');
    }
    
    function efxBtnClickUp(obj)
    {
//        $('#'+obj.id).stop().animate({boxShadow: '10px 10px 15px',top:(obj.style.top-5)}, 'slow');
        
        if (obj.id=='Driver')
        {
            var idCar="<%=request.getSession().getAttribute("USER_IDCAR")%>";
            if (idCar!="null")
                setTimeout('redirect_ajax("<c:url value="/usr/viewDriver.htm" />", "contenido")',300);
            else
                alert("Aún no tiene un vehículo inscrito.Puede hacerlo a través de 'Mi Cuenta'");
            
        }
        
        if (obj.id=='Student')
        {
            setTimeout('redirect_ajax("<c:url value="/usr/viewStudent.htm" />", "contenido")',300);
          
        }
        
        if (obj.id=='MyAccount')
        {
            setTimeout('redirect_ajax("<c:url value="/usr/viewMyAccount.htm" />", "contenido")',300);
          
        }
    }
        
        
//        window.onload=checkPage();
        window.onload=updateScreen()
    </script>
        
    </head>
    
    <body>
        <div id="divLoading" style="top:1%;left:1%;display:none;width:98%;height:98%;position:absolute;background-color: #4e5b6c;z-index:999999;filter:alpha(opacity=30); opacity:0.3;">
            <img style="top:30%;left:40%;position:absolute" src="../images/loading.gif"/>
        </div>
       <div id="headsection">
                    <div id='containerimg' style="padding-top: 3%">
                        <img src='../images/subete.png' width="100%" />
                    </div>
                    <div style="margin-left:  70%;padding-top:1%">
                        <h4>Bienvenido(a),  <%=request.getSession().getAttribute("USER_NAME")%></h4>
                        <input class="btnCustom" id="btnLogOut" type="button" value="Cerrar Sesión" 
                                onclick="location.href='../usr/logout.htm'">
                    </div>
       </div> 
        
       <div id='maincontainer'>
            <c:choose>
                <c:when test="${not empty urlDir}">

                      <jsp:include page="${urlDir}"/>
                    
                </c:when>
                <c:when test="${empty urlDir}">

                     <div id="menu-column">

                         <ul >
                             <li id='Driver' class="btn btnDriver" value="CONDUCTOR" onmousedown="efxBtnClickDown(this)"
                        onmouseup="efxBtnClickUp(this)">
                                 CONDUCTOR
                             </li>

                             <li id='Student' class="btn btnStudent" value="ESTUDIANTE" onmousedown="efxBtnClickDown(this)"
                        onmouseup="efxBtnClickUp(this)">
                                 ESTUDIANTE
                             </li>

                             <li id='MyAccount' class="btn btnStudent" value="MI CUENTA" onmousedown="efxBtnClickDown(this)"
                        onmouseup="efxBtnClickUp(this)">
                                 MI CUENTA
                             </li>

                         </ul>
                     </div>

                     <div id="contenido" >
                     </div>    
              </c:when>
            </c:choose>
      </div>
    </body>
</html>

