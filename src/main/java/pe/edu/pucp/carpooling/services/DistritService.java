/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.pucp.carpooling.bean.DistritBean;
import pe.edu.pucp.carpooling.mapper.DistritMapper;

/**
 *
 * @author Cesar
 */

@Component
public class DistritService {
    
    @Autowired
    DistritMapper distritMapper;
    
    public List<DistritBean> getAllDistrit()
    {
        return distritMapper.getAllDistrit();
    }
    
    public String getNameDistritById(int idDistrit)
    {
        return distritMapper.getNameDistritById(idDistrit);
        
    }
    
}
