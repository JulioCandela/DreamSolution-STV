/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.filter;

/**
 *
 * @author Cesar
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.pucp.carpooling.services.UserService;

public class LoginFilter implements Filter {
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        
        try {
        //Podemos seguir ejecutando los demas filtros si asi lo necesitamos
            HttpServletRequest req=(HttpServletRequest)request;
            
            //Se da pase libre en caso sea un request desde login
            
            if ((req.getRequestURI().indexOf("verificarUsuario")!=-1) ||
                 (req.getRequestURI().indexOf("userIDCodeVerify")!=-1))   
            {
                System.out.println("Filtro - Libre");
                chain.doFilter(request, response);
            }
            else
            {
                if ((req.getSession(false)!=null) )
                {
                    System.out.println("sesion no nula - user key null");
                    System.out.println(req.getSession().getAttribute("codeverify"));
                 if ((req.getSession(false).getAttribute("USER_KEY")!=null) 
                    && (req.getSession(false).getAttribute("codeverify")!=null))
                    {
                        System.out.println("Sesión existente y verificado");
                        chain.doFilter(request, response);
                    }
                }
                else
                {
                    System.out.println("No sesión - Filtro. Redireccionando");
                   ((HttpServletResponse)response).sendRedirect("../welcome.htm");
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        catch (ServletException e) {
            e.printStackTrace();
        }
    }
    
    public void destroy() {
        
    }
    
    
    public void init(FilterConfig arg0) throws ServletException {
    
    }
    
}    
