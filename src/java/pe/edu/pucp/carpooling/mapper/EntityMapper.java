/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import pe.edu.pucp.carpooling.bean.EntityBean;

/**
 *
 * @author Cesar
 */

@Component
public interface EntityMapper {
    
    public List<EntityBean> getAllEntities();
    public String getHostNameEntity(@Param ("idEntity")int idEntity);
    
}
