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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pe.edu.pucp.carpooling.bean.DistritBean;
import pe.edu.pucp.carpooling.services.DistritService;
import pe.edu.pucp.carpooling.services.TripService;

/**
 *
 * @author Cesar
 */
@Controller
public class studentController {
    
     @Autowired
    DistritService distritService;
     @Autowired
     TripService tripService;
    
    @RequestMapping (value="usr/viewStudent.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView viewUser(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model;
        System.out.println("Entro a controller viewStudent");
        
        List<DistritBean> listaDistritos=distritService.getAllDistrit();
        List<String> nombreDistritos = null;
        nombreDistritos=new ArrayList<String>();
        
        
        for (DistritBean dist:listaDistritos)
        {
            nombreDistritos.add(dist.getNameDistrit());
            System.out.println(dist.getNameDistrit());
        }
        
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
        modelmap.addAttribute("listaDistritos", nombreDistritos);
        model=new ModelAndView("viewStudent",modelmap);
        return model;
        
    }
    
    @RequestMapping (value="usr/addStudentToTrip.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView addUserToTrip(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("Entro a addStudentToTip Controller");
        String idCar=request.getParameter("idCar");
        
        int needExtra=0;
        if (request.getParameter("needExtra").equalsIgnoreCase("true")) needExtra=1;
        
        int idTrip=Integer.parseInt(request.getParameter("idTrip"));
        tripService.saveUserToTrip(idCar,idTrip,request.getSession().getAttribute("USER_KEY").toString(),needExtra);
        ModelAndView model=new ModelAndView("viewConfirmStudent");
        return model;
    }
    
    @RequestMapping (value="usr/modifyTripStudent.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView modifyTripUser(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("Entro a modifyTripStudent Controller");
        tripService.removeUserTrip(request.getSession().getAttribute("USER_KEY").toString(),
                                      Integer.parseInt(request.getSession().getAttribute("USER_IDTRIP").toString()),1);
        modelmap.addAttribute("urlDir","../ajax/menuCarPool.jsp");
        ModelAndView model=new ModelAndView("inicio");
        return model;
        
    }
    
    @RequestMapping (value="usr/changeStudentOfTripDrop.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView changeUserOfTripDrop(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("Entro a changeStudentOfTripDrop Controller");
        tripService.removeUserTrip(request.getSession().getAttribute("USER_KEY").toString(),
                                      Integer.parseInt(request.getSession().getAttribute("USER_IDTRIP").toString()),0);
        modelmap.addAttribute("urlDir","../ajax/menuCarPool.jsp");
        ModelAndView model=new ModelAndView("inicio");
        return model;
        
    }
    
}
