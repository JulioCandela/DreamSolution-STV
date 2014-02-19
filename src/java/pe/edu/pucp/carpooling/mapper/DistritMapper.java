/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pe.edu.pucp.carpooling.bean.DistritBean;

/**
 *
 * @author Cesar
 */
public interface DistritMapper {
    
    public List<DistritBean> getAllDistrit();
    public String getNameDistritById(@Param ("idDistrit")int idDistrit);
}
