/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.services;

import pe.edu.pucp.carpooling.mapper.InitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitService {
    
    @Autowired
    private InitMapper initmapper;
    
    public String getWelcome()
    {
        return initmapper.getWelcome();
    }
    
}
