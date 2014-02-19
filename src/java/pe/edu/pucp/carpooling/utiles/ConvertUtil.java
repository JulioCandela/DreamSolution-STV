/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.utiles;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Cesar
 */
public class ConvertUtil {
    
    public static String convertDateToString(Date date)
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
        
    }
    
}
