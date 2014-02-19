/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.services;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.pucp.carpooling.bean.DriverBean;
import pe.edu.pucp.carpooling.bean.TripBean;
import pe.edu.pucp.carpooling.mapper.DriverMapper;

/**
 *
 * @author Cesar
 */

@Component
public class DriverService {
    
    @Autowired
    DriverMapper driverMapper;
    
    public void saveDriver(String idCar,String idUser,String descCar,int bigCar)
    {
        driverMapper.saveDriver(idCar,idUser,descCar,bigCar);
    }
    
    public DriverBean getDataSavedDriver(String idUser)
    {
        System.out.println("IDUser en Service: "+idUser);
        return driverMapper.getDataSavedDriver(idUser);
    }
    
    public TripBean getLastConfigurationTripDriver(String idCar)
    {
        //Devolvemos la última configuración conocida
        List<TripBean> tripBean=driverMapper.getLastConfigurationTripDriver(idCar);
        if (tripBean.size()!=0)
            return tripBean.get(0);
        else
            return null;
    }
    
    public DriverBean getDriverByIDCar(String idCar)
    {
        return driverMapper.getDriverByIDCar(idCar);
        
    }
}
