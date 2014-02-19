/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pe.edu.pucp.carpooling.bean.ConfigurationDriverTripBean;
import pe.edu.pucp.carpooling.bean.DistritBean;
import pe.edu.pucp.carpooling.bean.DriverBean;
import pe.edu.pucp.carpooling.bean.TripBean;
import pe.edu.pucp.carpooling.services.DistritService;
import pe.edu.pucp.carpooling.services.DriverService;
import pe.edu.pucp.carpooling.services.TripService;
import pe.edu.pucp.carpooling.services.UserService;
import pe.edu.pucp.carpooling.utiles.ConvertUtil;

/**
 *
 * @author Cesar
 */

@Controller
public class driverController {
    
    @Autowired
    DriverService driverService;
    @Autowired
    TripService tripService;
     @Autowired
    DistritService distritService;
     @Autowired
    UserService userService;
    List<String> nombreDistritos;
    
     @RequestMapping (value="usr/verifyDriver.htm" ,method={RequestMethod.GET,RequestMethod.POST} )
    public @ResponseBody ConfigurationDriverTripBean verifyDriver(HttpServletRequest request)
    {
        
        System.out.println("Entr a VerifyDriver Controller");
        ConfigurationDriverTripBean configDriverTrip=new ConfigurationDriverTripBean();
        
        TripBean tripBean=null;
        DriverBean driverBean=null;
        int flagError=0;
        int flagNewDriver=0;
        
        String idUser=(String)request.getSession().getAttribute("USER_KEY");
        
        try
        {
         driverBean=driverService.getDataSavedDriver(idUser);
         configDriverTrip.setDescCar(driverBean.getDescCar());
        }
        catch (Exception e)
        {
            System.out.println("Error en sentencia SQL1");
            flagError=1;
        }
        
        
        if (driverBean!=null)
        { 
            try
            {
                tripBean=driverService.getLastConfigurationTripDriver(driverBean.getIdCar());
                
                //Verificamos si el conductor ya ha registrado anteriormente
                //un viaje, para poder mostrar dicha configuración
                //en la vista
                if (tripBean!=null) 
                {
                    String dateTrip=ConvertUtil.convertDateToString(tripBean.getDayTrip());

                    configDriverTrip.setIdCar(tripBean.getIdCar());
                    configDriverTrip.setIdDistrit(tripBean.getIdDistrit());
                    configDriverTrip.setNumPersonCapacity(tripBean.getNumPersonCapacity());
                    configDriverTrip.setDestinyReference(tripBean.getDestinyReference());
                    configDriverTrip.setPricePerson(tripBean.getPricePerson());
                }
//                String endPositionMap=userService.getEndPositionMap(idUser);
//                String []xyPos=new String[2];
//                xyPos=endPositionMap.split("/");
//                
//                configDriverTrip.setEndXPositionMap(Double.parseDouble(xyPos[0]));
//                configDriverTrip.setEndYPositionMap(Double.parseDouble(xyPos[1]));
                
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Error en sentencia SQL2");
                flagError=1;
            }
        }
        else
        {
            System.out.println("Driver no registrado...");
            flagNewDriver=1;
        }
        
        configDriverTrip.setFlagNewDriver(flagNewDriver);
        System.out.println("Antes de return");
        return configDriverTrip;
        
    }
    
     
     @RequestMapping (value="usr/viewDriver.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView viewDriver(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model;
        System.out.println("Entro a controller viewDriver");
        
//        List<DistritBean> listaDistritos=distritService.getAllDistrit();
//        List<String> nombreDistritos = null;
//        nombreDistritos=new ArrayList<String>();
        
        
//        for (DistritBean dist:listaDistritos)
//        {
//            nombreDistritos.add(dist.getNameDistrit());
//            System.out.println(dist.getNameDistrit());
//        }
        
//        this.nombreDistritos=nombreDistritos;
        
        SimpleDateFormat format=new SimpleDateFormat("HH:mm");
        String date=format.format(new Date());
        
        int flagAntes30=1;
        
        String[] hhmm=date.split(":");
        if (Integer.parseInt(hhmm[1])>=30) 
        { 
            if (Integer.parseInt(hhmm[0])==23)
                date=0+"";
            else
                date=(Integer.parseInt(hhmm[0]) +1 )+ "";
        }
        else
        {
            date=Integer.parseInt(hhmm[0])+"";
            flagAntes30=0; //primero se coloca la hora:30
        }
        
        System.out.println(date);
            
        modelmap.addAttribute("flagHora",flagAntes30);
        modelmap.addAttribute("horaServidor",date);
//        modelmap.addAttribute("listaDistritos", nombreDistritos);
//        modelmap.addAttribute("flagError",0);
        model=new ModelAndView("viewDriver",modelmap);
        return model;
    }
     
     @RequestMapping (value="usr/modifyTripDriver.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView modifyTripDriver(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model;
//        System.out.println(request.getSession().getAttribute("USER_IDTRIP").toString());
        tripService.releaseDriverToTrip(Integer.parseInt(request.getSession().getAttribute("USER_IDTRIP").toString()));
        modelmap.addAttribute("urlDir","../ajax/menuCarPool.jsp");
        model=new ModelAndView("inicio");
        return model;
    } 
    
}
