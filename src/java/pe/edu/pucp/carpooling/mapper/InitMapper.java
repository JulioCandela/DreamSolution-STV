/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.mapper;

import pe.edu.pucp.carpooling.services.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public interface InitMapper {
    
    public String getWelcome();
    
}
