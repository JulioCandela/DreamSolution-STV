/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.utiles;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeff
 */
public class MantenimientoUtil {
    
    public static boolean isSessionLogged(HttpSession session){
       
        if(session != null){
            if (session.getAttribute("USER_KEY")!=null)
                return true;
            else
                return false;
        } else {
            return false;
        }
    }
    
    public static boolean tripGoOutSuccess(String hour)
    {
        String []_hour=hour.split(":");
        int hourInt=Integer.parseInt(_hour[0])*100+Integer.parseInt(_hour[1]);
        
        SimpleDateFormat spf=new SimpleDateFormat("HH:mm");
        String hourNow=spf.format(new Date());
        String []_hourNow=hourNow.split(":");
        int hourNowInt=Integer.parseInt(_hourNow[0])*100+Integer.parseInt(_hourNow[1]);
        
        if (hourNowInt>=hourInt) return true;
        else return false;
    }
    
    public static String getHourNow()
    {
        SimpleDateFormat spf=new SimpleDateFormat("HH:mm");
        return spf.format(new Date());
    }
    
}
