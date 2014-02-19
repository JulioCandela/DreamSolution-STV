var AvanceOn = false  
var AvanceID = null  
var RetrocesoOn = false  
var RetrocesoID = null 
var yActual=0;
var cursorComienzoY;
var inc_dec;
var main;
var navegador;

function avanzar() {
    
    main.scrollTop+=Math.ceil(inc_dec/100);
    AvanceID = setTimeout("avanzar()", 10);  
    AvanceOn = true;   
}  
  
function retroceder() {  
    
    main.scrollTop-=Math.ceil(inc_dec/100);
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

function comienzoMovimiento(event,id)
{
    main=document.getElementById(id);
   
    if(navigator.userAgent.indexOf("MSIE")>=0) navegador=0;
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
}
 
function enMovimiento(event)
{ 	
    var y_aux;
    y_aux=yActual;
    
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
    
    inc_dec=Math.abs(cursorComienzoY-yActual); 
    if (cursorComienzoY-yActual>0) ComenzarAvance();
    if (cursorComienzoY-yActual<0) ComenzarRetroceso();
        
//    if ((yActual>=main.offsetTop) && (yActual<=main.offsetTop+parseInt(main.style.height)))
//    {   
//        
//        
//    }
//    else finMovimiento();
    
    window.status=yActual+" "+y_aux;
    //if (yActual==y_aux) finMovimiento();    
    evitaEventos(event);
}

function finMovimiento()
{    
    
    if(navegador==0)
    {   
        main.detachEvent("onmousemove", enMovimiento);
        main.detachEvent("onmouseup", finMovimiento);       
    }
    if(navegador==1)
    {
        main.removeEventListener("mousemove", enMovimiento,true);
        main.removeEventListener("mouseup", finMovimiento,true);       
   }
   
   DetenerScroll(); 
}
