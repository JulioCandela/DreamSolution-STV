/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import pe.edu.pucp.carpooling.bean.DriverBean;
import pe.edu.pucp.carpooling.bean.TripBean;

/**
 *
 * @author Cesar
 */


@Component
public interface DriverMapper {
    
    public void saveDriver( @Param ("idCar")String idCar,
                            @Param("idUser") String idUser,@Param("descCar") String descCar,
                            @Param("bigCar") int bigCar );
 
    public DriverBean getDataSavedDriver(@Param ("idUser")String idCar);
    public List<TripBean> getLastConfigurationTripDriver(@Param ("idCar")String idCar);
    public DriverBean getDriverByIDCar(@Param ("idCar")String idCar);
    
}
