/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function soloLetrasNumeros(e){
                var tecla=(document.all) ? e.keyCode: e.which;
//                alert("tecla: "+tecla);
                if((tecla>47&&tecla<58) || (tecla>=97 && tecla<=122) || (tecla>=65 && tecla<=90))
                    return true;
                else
                    return false;
                
}