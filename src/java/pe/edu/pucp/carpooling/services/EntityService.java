/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.pucp.carpooling.bean.EntityBean;
import pe.edu.pucp.carpooling.mapper.EntityMapper;

/**
 *
 * @author Cesar
 */

@Component
public class EntityService {
    
    @Autowired
    EntityMapper entityMapper;
    
    public List<EntityBean> getAllEntities()
    {
        return entityMapper.getAllEntities();
    }
    
    public String getHostNameEntity(int idEntity)
    {
        return entityMapper.getHostNameEntity(idEntity);
    }
    
}
