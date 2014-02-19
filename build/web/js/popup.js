var isIE = navigator.appName.indexOf("Explorer") != -1;

var clickedPopup;

if(!document.getElementsByClassName) {
    //alert('creando');
    createGetElementsByClassNameFunction();
}

function createGetElementsByClassNameFunction(){
    document.getElementsByClassName = function(clase) {
        //alert("---> "+clase);
        var elms = document.getElementsByTagName('*');
        var ei = new Array();
        for (i=0;i<elms.length;i++) {
            if (elms[i].getAttribute('class')) {
                ecl = elms[i].getAttribute('class').split(' ');
                for (j=0;j<ecl.length;j++) {
                    if (ecl[j].toLowerCase() == clase.toLowerCase()) {
                        ei.push(elms[i]);
                    }
                }
            } else if (elms[i].className) {
                ecl = elms[i].className.split(' ');
                for (j=0;j<ecl.length;j++) {
                    if (ecl[j].toLowerCase() == clase.toLowerCase()) {
                        ei.push(elms[i]);
                    }
                }
            }
        }
        return ei;
    }
}

//window.onclick = closeOpenPopups;
document.onclick = closeOpenPopups;


function closeOpenPopups(){
    var popups = document.getElementsByClassName("popup_div_container");
    for(var i=0; i < popups.length; i++){
        var popup = popups[i];
        if(!clickedPopup || (popup.id != clickedPopup.id && popup.style.display != "none")){
            popup.style.display = "none";
        }
    }
}

/*function showPopup(div){
    activePopup = div;
    activePopup.style.display = "";
}*/

function clickInPopup(event, popup){
    clickedPopup = popup;
    closeOpenPopups();
    clickedPopup = null;
    
    if(isIE){
        window.event.cancelBubble = true;
    } else {
        event.stopPropagation();
    }
}

function showInputValidationPopup(input, popup, message){
    var messageDiv = getChildElementById(popup, "message");
    if(messageDiv)messageDiv.innerHTML = message;
    
    
    var pos = getPosicion(input);
    var top = pos.y + input.offsetHeight + 1 + "px";
    var left = (pos.x + input.offsetWidth) + "px";
    
    popup.setAttribute("style", "position:absolute; top:"+top+";left:"+left+";");
    popup.className = "popup_div_container popup_visible";
}

function getPosicion(obj) {
    var curleft = obj.offsetLeft || 0;
    var curtop = obj.offsetTop || 0;
    while (obj = obj.offsetParent) {
            curleft += obj.offsetLeft
            curtop += obj.offsetTop
    }
    return {x:curleft,y:curtop};
}

function getChildElementById(element, childElementId){
    var childNodeArray = element.childNodes;
    for(var i=0; i < childNodeArray.length; i++){
        if(childNodeArray[i].id == childElementId)
            return childNodeArray[i];
    }
    return null;
}