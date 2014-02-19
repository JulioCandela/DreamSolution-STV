<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script type="text/javascript" >
    
    function efxBtnClickDown(obj)
    {
        $('#'+obj.id).stop().animate({boxShadow: '3px 3px 3px',top:(obj.style.top+5)}, 'fast');
    }
    
    function efxBtnClickUp(obj)
    {
        $('#'+obj.id).stop().animate({boxShadow: '10px 10px 15px',top:(obj.style.top-5)}, 'slow');
        if (obj.id=='Driver')
        {
            var idCar="<%=request.getSession().getAttribute("USER_IDCAR")%>";
            if (idCar!="null")
                setTimeout('redirect_ajax("<c:url value="/usr/viewDriver.htm" />", "contenido")',300);
            else
                alert("Debe inscribir primero su vehículo")
            
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
    
</script>


<div style="height: 60%;position: absolute;margin: 0px 0px 50px 380px" >
    <input id="Driver" class="btn btnDriver" type="button" onmousedown="efxBtnClickDown(this)"
           onmouseup="efxBtnClickUp(this)" 
           style="position: absolute;top: 100px;left:-450px" value="CONDUCTOR">
       <br>
    
    <input id="Student" class="btn btnStudent" type="button" style="position: absolute;top: 100px;left:-50px" 
       onmousedown="efxBtnClickDown(this)"
           onmouseup="efxBtnClickUp(this)" 
       value="ESTUDIANTE"><br>
    
    <input id="MyAccount" class="btn btnStudent" type="button" style="position: absolute;top: 100px;left:360px" 
       onmousedown="efxBtnClickDown(this)"
           onmouseup="efxBtnClickUp(this)" 
       value="MI CUENTA"><br>
</div>


     
