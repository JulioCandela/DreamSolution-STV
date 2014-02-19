var AvanceOn = false  
var AvanceID = null  
var RetrocesoOn = false  
var RetrocesoID = null 
var elComienzoY;
var yActual;
var cursorComienzoY;


function avanzar() {
    var y = 5  	
	window.scrollBy(0, y)  ;			
    AvanceID = setTimeout("avanzar()", 10)  
    AvanceOn = true  
}  
  
function retroceder() {  
    var y = -5          
    window.scrollBy(0, y); 
    RetrocesoID = setTimeout("retroceder()", 10)  
    RetrocesoOn = true  
}  
  
function DetenerScroll() { 
    if(AvanceOn) {  
        clearTimeout(AvanceID)  
        AvanceOn = false  
    }  
    if(RetrocesoOn) {  
        clearTimeout(RetrocesoID)  
        RetrocesoOn = false  
    } 
}  
  
function ComenzarAvance() { 
	if(RetrocesoOn)  
        DetenerScroll()  
    if(!AvanceOn)        
		avanzar()  
}  

  
function ComenzarRetroceso() {  
    if(AvanceOn)  
        DetenerScroll()  
    if(!RetrocesoOn)  
        retroceder()  
}  


function evitaEventos(event)
{    
    if(navegador==0)
    {
        window.event.cancelBubble=true;
        window.event.returnValue=false;
    }
    if(navegador==1) event.preventDefault();
}

function comienzoMovimiento(event)
{
    main=document.getElementById("body_principal");
   
	if(navigator.userAgent.indexOf("MSIE")>=0) navegador=0;
    // Otros
    else navegador=1;
	
    if(navegador==0)
     { 
        //cursorComienzoX=window.event.clientX+document.documentElement.scrollLeft+document.body.scrollLeft;
        cursorComienzoY=window.event.clientY+document.documentElement.scrollTop+document.body.scrollTop;
			
        main.attachEvent("onmousemove", enMovimiento);
        main.attachEvent("onmouseup", finMovimiento);
    }
    if(navegador==1)
    {  
        //var cursorComienzoX=event.clientX+;
        cursorComienzoY=event.clientY +document.body.scrollTop;
       
        main.addEventListener("mousemove", enMovimiento, true);		
        main.addEventListener("mouseup",finMovimiento, true);
    }
   
	evitaEventos(event);
    window.status = elcomienzoy;
}
 
function enMovimiento(event)
{ 	
	if(navegador==0)
    {   
        //xActual=window.event.clientX+document.documentElement.scrollLeft+document.body.scrollLeft;
        yActual=window.event.clientY+document.documentElement.scrollTop+document.body.scrollTop;
    } 
    if(navegador==1)
    {
        //xActual=event.clientX+window.scrollX;
        yActual=event.clientY+window.scrollY;
		
    }
   
	if (cursorComienzoY-yActual>0) ComenzarAvance();
	if (cursorComienzoY-yActual<0) ComenzarRetroceso();
	
	
	window.status="(Xinicial,Xactual)"+cursorComienzoY+" "+yActual;
	evitaEventos(event);
}

function finMovimiento(event)
{
    //alert("fin movimiento");	
	if(navegador==0)
    {   
        main.detachEvent("onmousemove", enMovimiento);
        main.detachEvent("onmouseup", finMovimiento);
    }
    if(navegador==1)
    {
        main.removeEventListener("mousemove", enMovimiento, true);
        main.removeEventListener("mouseup", finMovimiento, true);
    }
	
	DetenerScroll();
}
