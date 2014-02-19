
package pe.edu.pucp.carpooling.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pe.edu.pucp.carpooling.bean.UserBean;
import pe.edu.pucp.carpooling.services.UserService;

@Controller
public class seguridadController {
    
    @Autowired
    UserService userService;        
            
    HttpSession sesion;
    
    
    @RequestMapping(value="usr/userIDCodeVerify.htm", method={RequestMethod.GET,RequestMethod.POST} )
    public ModelAndView userIDCodeVerify(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        String idUser=request.getSession().getAttribute("USER_KEY").toString();
        String codeSend=userService.verifyCodeMail(idUser);
        ModelAndView model;
        System.out.println("Código de verificación: "+codeSend);
        System.out.println("Codigo enviado: "+request.getParameter("cverify"));
        String strRedirect;
        if (request.getParameter("cverify").toString().equals(codeSend))
        {
            System.out.println("Exito en validación");
            userService.setUserMailVerified(idUser);
            modelmap.addAttribute("url", "../usr/login.htm");
            strRedirect="jspReload";
            request.getSession().setAttribute("codeverify", 1);
        }
        else
        {
            System.out.println("Error en validación");
            strRedirect="userMailVerify";
        }
        
        model=new ModelAndView(strRedirect,modelmap);
        return model;
        
        
    }
    
    //Url atado a LoginFilter
    @RequestMapping(value="usr/verificarUsuario.htm", method={RequestMethod.GET,RequestMethod.POST} )
    public ModelAndView verificarUsuario(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model;
        System.out.println("Entro a VerificarUsuario Controller");
        String id_usuario=request.getParameter("user");
        String pass=request.getParameter("pass");
        
        System.out.println("Usuario: "+id_usuario);
        System.out.println("Password: "+pass);
        
        UserBean userBean=userService.verifyUser(id_usuario, pass);
        String redireccion;
        
        if (userBean!=null)
        {
            System.out.println("Login exitoso");
            String idCar=userService.getCarByUser(request.getParameter("user"));
            HttpSession sesion=request.getSession();
            sesion.setAttribute("USER_KEY", request.getParameter("user"));
            sesion.setAttribute("USER_IDCAR", idCar);
            sesion.setAttribute("USER_NAME", userBean.getName()+" "+userBean.getApp());
            sesion.setAttribute("USER_IDDISTRIT", userBean.getIdDistrit());
            redireccion="jspRedireccion";
            
            if (userService.getCodeFlag(request.getParameter("user"))==0) redireccion="userMailVerify";
            else request.getSession().setAttribute("codeverify", 1);
        }
        else
        {
            redireccion="welcomeInit";
            modelmap.addAttribute("flag_error",1);
            System.out.println("Error en login");
        }
        
        model=new ModelAndView(redireccion,modelmap);
        return model;
    }
    
    @RequestMapping(value="usr/logout.htm", method={RequestMethod.GET,RequestMethod.POST} )
    public ModelAndView logout(ModelMap modelmap, HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView model;
        System.out.println("Entro a LogOut Controller");
        HttpSession sesion=request.getSession();
        System.out.println("Sesion con ID: "+sesion.getAttribute("USER_KEY"));
        sesion.invalidate();
        model=new ModelAndView("jspRedireccionLogOut",modelmap);
        return model;
    }
    
    
}
