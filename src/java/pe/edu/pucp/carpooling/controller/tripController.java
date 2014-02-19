/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Param;
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
import pe.edu.pucp.carpooling.utiles.MantenimientoUtil;

/**
 *
 * @author Cesar
 */

@Controller
public class tripController {
    
    @Autowired
    TripService tripService;
    @Autowired
    DistritService distritService;
    @Autowired
    DriverService driverService;
    @Autowired
    UserService userService;
    List<String> nombreDistritos;
    
    
    @RequestMapping (value="usr/chooseTrip.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView chooseTrip(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model;
        System.out.println("Entro a controller chooseTrip");
        model=new ModelAndView("chooseTrip",modelmap);
        
        return model;
        
    }
    
    @RequestMapping (value="usr/searchTrips.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody ArrayList<TripBean> searchTrips(@RequestParam String idDistrit,
                                                         @RequestParam String hourTrip,
                                                         @RequestParam String needBigCar)
    {
        System.out.println("Entro a controller searchTrips");
        ArrayList<TripBean> listaDetalleTrip=null;
        int needBigCarFlag=0;
        if (needBigCar.equalsIgnoreCase("on")) needBigCarFlag=1;
        try
        {
            listaDetalleTrip=tripService.getListTripByIdDistrit(Integer.parseInt(idDistrit)+1,hourTrip,needBigCarFlag);
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return listaDetalleTrip;
        
    }
    
    @RequestMapping (value="usr/getPositionGoogleMaps.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody ArrayList<Double> getPositionGoogleMaps(@RequestParam String idCar)
    {
        System.out.println("Entro a controller searchTrips");
        ArrayList<Double> positionGoogle=new ArrayList<Double>();
        String idUser,posGoogle = null;
        try
        {
            idUser=userService.getUserByCar(idCar);
            posGoogle=userService.getEndPositionMap(idUser);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        String []pos=posGoogle.split("/");
        positionGoogle.add(Double.parseDouble(pos[0]));
        positionGoogle.add(Double.parseDouble(pos[1]));
        return positionGoogle;
        
    }
    
    @RequestMapping (value="usr/processDriver.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView processDriver(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        
        ModelAndView model;
        String hourTrip=request.getParameter("hourTrip");
        System.out.println("Hora Trip: "+hourTrip);
        
        //Seguridad: Verificamos la hora de salida y la hora actual
        if (MantenimientoUtil.getHourNow().compareToIgnoreCase(hourTrip)>0)
        {
            System.out.println("Error en horas");
            return null;
        }
        
        System.out.println("****PROCESSDRIVER CONTROLLER*****");
        System.out.println("");
        
//        String idCar=request.getParameter("idCar");
//        String descCar=request.getParameter("descCar");
        int numPersonCapacity=Integer.parseInt(request.getParameter("numPersonCapacity"));
//        String phoneContact=request.getParameter("phoneContact");
//        String flagBicCar= (request.getParameter("bigCar"));
        int flagBigCarInt=0;
//        int newDriver= Integer.parseInt(request.getParameter("newDriver"));
//        System.out.println("NEW DRIVER: " + newDriver);
//        if (flagBicCar.equalsIgnoreCase("on")) flagBigCarInt=1;
        
        
//        System.out.println("IDCAR: "+idCar);
        System.out.println("NUMPERSONCAPACITY: "+ numPersonCapacity);
        System.out.println("ES BIG CAR?: "+flagBigCarInt);
//        System.out.println("PHONE CONTACT: "+phoneContact);
//        System.out.println("MODEL CAR: "+descCar);
        
        int idDistrit=Integer.parseInt(request.getSession().getAttribute("USER_IDDISTRIT")+"");
        System.out.println("IDDISTRIT: "+idDistrit);
        String currentDate= ConvertUtil.convertDateToString(new Date());
        System.out.println("Fecha: "+currentDate);
        
        double pricePerson= Double.parseDouble(request.getParameter("pricePerson"));
        System.out.println("PRICE PERSON: "+pricePerson);
        String placeParkingX=request.getParameter("placeParkingX");
        String placeParkingY=request.getParameter("placeParkingY");
        String placeParking=placeParkingX+"/"+placeParkingY;
        System.out.println("PLACE PARKING: "+placeParking);
        String referenceDestiny=request.getParameter("referenceDestiny");
        System.out.println("REFERENCE DESTINY: "+referenceDestiny);
        String strView="viewConfirm";
        int flagError=0;
        try
        {
//            if (newDriver!=0)
//            {
//                
//                DriverBean driverBean=driverService.getDriverByIDCar(idCar);
//                //Placa de Vehiculo ya inscrito
//                    if (driverBean!=null)
//                    {
//                       strView="viewDriver";
//                       String strMsg="Este número de placa ya ha sido inscrito.Verifique nuevamente." ;
//                       modelmap.addAttribute("flagError",1);
//                       modelmap.addAttribute("strMsg",strMsg);
//                       model=new ModelAndView(strView,modelmap);
//                       return model;
//                    }
//                    
//                driverService.saveDriver(
//                        idCar,phoneContact,flagBigCarInt,
//                        request.getSession().getAttribute("USER_KEY").toString(),descCar);
//            }
            
            tripService.saveTripDay(idDistrit, 1,numPersonCapacity, request.getSession().getAttribute("USER_IDCAR")+"", 
                    currentDate,hourTrip, pricePerson, placeParking,referenceDestiny);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            String strMsg="Hubo un problema en el proceso. Intente nuevamente.";
            modelmap.addAttribute("strMsg",strMsg);
            strView="viewDriver";
            flagError=1;
            modelmap.addAttribute("listaDistritos",this.nombreDistritos);
        }
        
        modelmap.addAttribute("flagError",flagError);
        model=new ModelAndView(strView,modelmap);
        return model;
    }
}
