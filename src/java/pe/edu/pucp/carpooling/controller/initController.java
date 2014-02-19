
package pe.edu.pucp.carpooling.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.catalina.Session;
import pe.edu.pucp.carpooling.services.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pe.edu.pucp.carpooling.bean.CarBean;
import pe.edu.pucp.carpooling.bean.ConfigurationDriverTripBean;
import pe.edu.pucp.carpooling.bean.DistritBean;
import pe.edu.pucp.carpooling.bean.DriverBean;
import pe.edu.pucp.carpooling.bean.EntityBean;
import pe.edu.pucp.carpooling.bean.TripBean;
import pe.edu.pucp.carpooling.bean.UserBean;
import pe.edu.pucp.carpooling.services.DistritService;
import pe.edu.pucp.carpooling.services.DriverService;
import pe.edu.pucp.carpooling.services.EntityService;
import pe.edu.pucp.carpooling.services.TripService;
import pe.edu.pucp.carpooling.services.UserService;
import pe.edu.pucp.carpooling.utiles.ConvertUtil;
import pe.edu.pucp.carpooling.utiles.MantenimientoUtil;
import pe.edu.pucp.carpooling.utiles.encryptUtil;
import pe.edu.pucp.carpooling.utiles.sendMail;

@Controller
public class initController {
    
    @Autowired
    private DistritService distritService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private TripService tripService;
    @Autowired
    private EntityService entityService;
    @Autowired
    private UserService userService;
    
    
    
    @RequestMapping (value="usr/viewMyAccount.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView viewMyAccount(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        UserBean user=userService.getUserById(request.getSession().getAttribute("USER_KEY").toString());
        List<DistritBean> listaDistrito=distritService.getAllDistrit();
        modelmap.addAttribute("userName",user.getName());
        modelmap.addAttribute("userApp",user.getApp());
        modelmap.addAttribute("userApm",user.getApm());
        modelmap.addAttribute("userPhoneContact",user.getPhoneContact()!=null? user.getPhoneContact() : "");
        modelmap.addAttribute("userIdEntity",user.getIdUserIntoEntity()!=null? user.getIdUserIntoEntity() : "");
        modelmap.addAttribute("listaDistrito",listaDistrito);
        
        //Si el usuario tiene carro, se carga la data del vehiculo
//        modelmap.addAttribute("fcheckvehiculo",false);
//        if (user.getIdCar()!=null)
//        {
//            modelmap.addAttribute("placa",user.getIdCar());
//            modelmap.addAttribute("fcheckvehiculo",true);
//            CarBean carbean=userService.getCar(user.getIdUser());
//            modelmap.addAttribute("desc",carbean.getDescCar());
//            modelmap.addAttribute("fbigcar",carbean.isBigCar());
//            
//            
//        }
        
        ModelAndView model=new ModelAndView("viewAccount", modelmap);
        return model;
    }
    
    @RequestMapping (value="usr/recoverPassword.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView recoverPassword(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        String user=request.getParameter("idUserRecover");
        String newPass=encryptUtil.generarCadenaAleatoria();
        userService.updateUserPassword(user, newPass);
        sendMail.sendMailRecoverPassword(user,newPass);
        return null;
    }
    
    
    @RequestMapping (value="usr/updatePassword.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView updatePassword(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            String pass=request.getParameter("password").toString();
            userService.updateUserPassword(request.getSession().getAttribute("USER_KEY").toString(),pass);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    @RequestMapping (value="usr/updateUser.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView updateUser(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(initController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String name=request.getParameter("name");
        String app=request.getParameter("app");
        String apm=request.getParameter("apm");
        String phoneContact=request.getParameter("phoneContact");
        int fcheckUseCarInt=0;
        String fCheckUseCar=request.getParameter("fCheckUseCar");
        
        
        int bigCar=0;
        String fcheckBigCar;
        if (fCheckUseCar.equalsIgnoreCase("true"))
        {
            fcheckUseCarInt=1;
            fcheckBigCar=request.getParameter("fCheckBigCar");
            if (fcheckBigCar.equalsIgnoreCase("true")) bigCar=1;
        }
        
        
        String idUserIntoEntity=request.getParameter("idUserIntoEntity");
        
        try
        {
            if (fcheckUseCarInt==1)
            {
                String positionMap=request.getParameter("locationMap");
                positionMap=positionMap.replace("(","");
                positionMap=positionMap.replace(")","");
                positionMap=positionMap.replace(",", "/");
                String idCar=request.getParameter("idCar");
                String descCar=request.getParameter("descCar");
                int idDistrit=Integer.parseInt(request.getParameter("idDistrit"))+1;
                
                userService.updateUserAddCar(request.getSession().getAttribute("USER_KEY").toString(),name, app, apm, idCar, phoneContact, 
                                idUserIntoEntity, positionMap, idDistrit);
                driverService.saveDriver(idCar, request.getSession().getAttribute("USER_KEY").toString(), descCar,bigCar);
                request.getSession().setAttribute("USER_IDCAR", idCar);
                request.getSession().setAttribute("USER_IDDISTRIT", idDistrit);
                
            }
            else
            {
                System.out.println("Update Solo User");
                userService.updateUser(request.getSession().getAttribute("USER_KEY").toString(), name, app, apm, phoneContact, idUserIntoEntity);
                
            }
            
            request.getSession().setAttribute("USER_NAME", name+" "+app);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    @RequestMapping (value="usr/login.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView init_page(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("Entro a controller initPage ");
        String strView="";
        
        
        HttpSession sesion=request.getSession(true);
        //Si existe sesion, ingresar... 
        
//        if (MantenimientoUtil.isSessionLogged(sesion))
//        {
            System.out.println("Sesion no nula");
            System.out.println(sesion.getAttribute("USER_KEY"));
//            strView="inicio";
            
            DriverBean driverBean=driverService.getDataSavedDriver(sesion.getAttribute("USER_KEY").toString());
            TripBean tripBean=null;
            if (driverBean!=null)
                tripBean=driverService.getLastConfigurationTripDriver(driverBean.getIdCar());
            
            //Para verificar si existe ya un trip asociado al conductor
            if (tripBean!=null && tripBean.getFlagActive()!=0)
            {
                    if ((ConvertUtil.convertDateToString(tripBean.getDayTrip())).equalsIgnoreCase(ConvertUtil.convertDateToString(new Date())))
                    {
                        if (MantenimientoUtil.tripGoOutSuccess(tripBean.getHourTrip())) strView="";
                        else
                        {
                            System.out.println("Existe TripDriver ya definido...");
                            sesion.setAttribute("USER_IDTRIP", tripBean.getIdTripDay());
                            modelmap.addAttribute("hourTrip",tripBean.getHourTrip());
                            modelmap.addAttribute("pricePerson",tripBean.getPricePerson());
                            modelmap.addAttribute("numPersonAboard",tripBean.getNumPersonAboard());

                            List<String> listaIdUserInTrip=tripService.getUsersInTrip(tripBean.getIdTripDay());
                            List<UserBean> listaUsersBeanInTrip=new ArrayList<UserBean>();
                            
                            HashMap<String,Integer> fNeedSpace=new HashMap<String, Integer>();
                                    
                            for (String idUserInTrip : listaIdUserInTrip)
                            {
                                UserBean user=userService.getUserById(idUserInTrip);
                                listaUsersBeanInTrip.add(user);
                                System.out.println(user.getName()+" "+user.getApp());
                                fNeedSpace.put(user.getIdUser(), tripService.getFlagNeedExtraSpace(user.getIdUser(), tripBean.getIdTripDay()));
                            }

                            modelmap.addAttribute("countFree",tripBean.getNumPersonCapacity()-tripBean.getNumPersonAboard());
                            modelmap.addAttribute("listaUsersBeanInTrip",listaUsersBeanInTrip);
                            modelmap.addAttribute("fNeedSpace",fNeedSpace);
                            strView="../DriverModule/viewTripAssociated.jsp";
                        }
                    }
            }
            
            //Para verificar si existe ya un trip asociado al estudiante
            tripBean=tripService.getTripByIDUser(sesion.getAttribute("USER_KEY").toString());
            if(tripBean!=null)
            {
                if (ConvertUtil.convertDateToString(tripBean.getDayTrip()).equalsIgnoreCase(ConvertUtil.convertDateToString(new Date())))
                {
                    sesion.setAttribute("USER_IDTRIP", tripBean.getIdTripDay());
                    System.out.println("Existe TripStudent ya definido...");
                    modelmap.addAttribute("idCar",tripBean.getIdCar());
                    modelmap.addAttribute("destinyReference",tripBean.getDestinyReference());
                    modelmap.addAttribute("hourTrip",tripBean.getHourTrip());
                    String[] placePark=tripBean.getPlaceParking().split("/");
                    modelmap.addAttribute("placeParkingX",placePark[0]);
                    modelmap.addAttribute("placeParkingY",placePark[1]);
                    modelmap.addAttribute("pricePerson",tripBean.getPricePerson());
                    modelmap.addAttribute("flagActive", tripBean.getFlagActive());
                    
                    String nameDistrit=distritService.getNameDistritById(tripBean.getIdDistrit());
                    modelmap.addAttribute("nameDistrit",nameDistrit);
                    
                    driverBean=driverService.getDriverByIDCar(tripBean.getIdCar());
                    modelmap.addAttribute("descCar",driverBean.getDescCar());
//                    modelmap.addAttribute("phoneDriver",driverBean.getPhoneContact());
                    
                    strView="../StudentModule/viewTripAssociated.jsp";
                }
            }
//        }
        
        ModelAndView model;
        modelmap.addAttribute("urlDir",strView);
        model=new ModelAndView("inicio",modelmap);
        
        return model;
    }
    
    @RequestMapping (value="welcome.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView welcome(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        String red="";
        if ((request.getSession(false)!=null))
        {
            if (request.getSession(false).getAttribute("USER_KEY")!=null)
            {
                System.out.println("Entro a welcome con sesión ya creada");
                red="jspReload";
                modelmap.addAttribute("url","usr/login.htm");
            }
            else
                red="welcomeInit";
        }
        else
            red="welcomeInit";
        
        ModelAndView model=new ModelAndView(red,modelmap);
        return model;
    }
    
    @RequestMapping (value="registerUser.htm" ,method={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView registerUser(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model;
        List<EntityBean> listaEntity=entityService.getAllEntities();
        List<String> listaNameEntity =new ArrayList<String>();
        for (EntityBean b:listaEntity)
        {
            listaNameEntity.add(b.getNameEntity());
        }
        
        List<DistritBean> listaDistritos=distritService.getAllDistrit();
        List<String> nombreDistritos = null;
        nombreDistritos=new ArrayList<String>();
        
        
        for (DistritBean dist:listaDistritos)
        {
            nombreDistritos.add(dist.getNameDistrit());
            System.out.println(dist.getNameDistrit());
        }
        
        modelmap.addAttribute("listaEntity",listaNameEntity);
        modelmap.addAttribute("listaDistritos", nombreDistritos);
        model=new ModelAndView("RegisterUser",modelmap);
        return model;
    }
    
     @RequestMapping (value="reg/verifyIdUserInRegister.htm" ,method={RequestMethod.GET,RequestMethod.POST} )
    public @ResponseBody boolean verifyIdUserInRegister(@RequestParam String idUserInRegister,
                                                        @RequestParam int idEntity)
    {
        //Devuelve TRUE si usuario ya existe, FALSE si es que no existe restricciones
        System.out.println("Entro a VerifyIdUserInRegister Controller");
        boolean existeIDUser=userService.verifyIdUserInRegister(idUserInRegister,idEntity+1);
        System.out.println("IDUSER: "+idUserInRegister);
        System.out.println("EXISTE: "+existeIDUser);
        return existeIDUser;
    }
     
      @RequestMapping (value="reg/verifyIdCarInRegister.htm" ,method={RequestMethod.GET,RequestMethod.POST} )
    public @ResponseBody boolean verifyIdCarInRegister(@RequestParam String idCarInRegister)
    {
        //Devuelve TRUE si usuario ya existe, FALSE si es que no existe restricciones
        System.out.println("Entro a VerifyIdCarInRegister Controller");
        boolean existeIDCar=userService.verifyIdCarInRegister(idCarInRegister);
        return existeIDCar;
    }
    
    
    @RequestMapping(value="reg/registerCompleted.htm", method={RequestMethod.GET,RequestMethod.POST} )
    public ModelAndView registerEnd(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model;
        System.out.println("Entro Register Completed");
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(initController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String idUser=null,name=null,app=null,apm=null,password=null,descCar=null;
        
            idUser = request.getParameter("idUser");
            name=request.getParameter("name");
            app=request.getParameter("app");
            apm=request.getParameter("apm");
            password=request.getParameter("password");
            descCar=request.getParameter("descCar");
            
        String codeMail=encryptUtil.generarCadenaAleatoria();
        boolean rmail=sendMail.sendMailCodeSecurity(idUser, codeMail);
            
        System.out.println("IDUSER: "+idUser);
        System.out.println("Name: "+name);
        System.out.println("App: "+app);
        System.out.println("Apm: "+apm);
        System.out.println("Password: "+password);
        Date registerDay=new Date();
        System.out.println("RegisterDay: "+registerDay);
        
        String idCar=request.getParameter("idCar");
        System.out.println("IDCar: "+idCar);
        
        System.out.println("Descripcion Car: "+descCar);
        String phoneContact=request.getParameter("phoneContact");
        System.out.println("PhoneContact: "+phoneContact);
        int fcheckUseCarInt=0;
        String fCheckUseCar=request.getParameter("fCheckUseCar");
        System.out.println("FCHECK: "+fCheckUseCar);
                if (fCheckUseCar.equalsIgnoreCase("true")) fcheckUseCarInt=1;
                
        int fcheckBigCarInt=0;
        String fCheckBigCar=request.getParameter("chkBigCar");
                if (fCheckBigCar.equalsIgnoreCase("true")) fcheckBigCarInt=1;
                
        int idEntity=Integer.parseInt(request.getParameter("idEntity"))+1;
        System.out.println("IDEntity: "+idEntity);
        String idUserIntoEntity=request.getParameter("idUserIntoEntity");
        System.out.println("IDUSERINTOENTEITY: "+idUserIntoEntity);
        String positionMap=request.getParameter("locationMap");
        System.out.println("POSITION: "+positionMap);
        int idDistrit=Integer.parseInt(request.getParameter("idDistrit"))+1;
        System.out.println("IDDISTRIT: "+idDistrit);
        
        positionMap=positionMap.replace("(","");
        positionMap=positionMap.replace(")","");
        positionMap=positionMap.replace(",", "/");
        
//        password= encryptUtil.getStringMessageDigest(password);
        
        if (fcheckUseCarInt==1)
        {
            System.out.println("Con carro");
            userService.addUser(idUser, name, app, apm, password, registerDay,
                        idCar, phoneContact,idEntity,idUserIntoEntity,positionMap,idDistrit,codeMail);
            driverService.saveDriver(idCar, idUser, descCar,fcheckBigCarInt);
        }
        else
        {
            userService.addUser(idUser, name, app, apm, password, registerDay,
                        null, phoneContact,idEntity,idUserIntoEntity,null,1,codeMail);
        }
        
        
        
        model=new ModelAndView("RegisterUserCompleted",modelmap);
        return model;
    }
    
}
