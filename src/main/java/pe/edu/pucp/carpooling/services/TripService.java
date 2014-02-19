/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.services;

import java.util.ArrayList;
import java.util.Date;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.pucp.carpooling.bean.TripBean;
import pe.edu.pucp.carpooling.mapper.TripMapper;
import pe.edu.pucp.carpooling.utiles.ConvertUtil;

/**
 *
 * @author Cesar
 */

@Component
public class TripService {
    
    @Autowired
    TripMapper tripMapper;
    
    public ArrayList<TripBean> getListTripByIdDistrit(int idDistrit,String hourTrip,int bigCar)
    {
        String dateTrip= ConvertUtil.convertDateToString(new Date());
        if (bigCar==0)
        {
            System.out.println("busqueda bigcar 0");
            return tripMapper.getListTripByIdDistrit(idDistrit,dateTrip,hourTrip);
        }
        else
        {
            System.out.println("busqueda bigcar 1");
            return tripMapper.getListTripByIdDistritNeedBigCar(idDistrit, dateTrip, hourTrip, bigCar);
        }
    }
    
    public void saveUserToTrip(String idCar, int idTrip,String idUser,int needExtra)
    {
        tripMapper.saveUserToTrip(idCar,idTrip,needExtra);
        System.out.println("ID User:(Service) "+idUser);
        tripMapper.associateUserTrip(idUser, idTrip);
    }
    
    public void saveTripDay(int idDistrit,int idEntity,int numberPersonCapacity,String idCar,String dayTrip,String hourTrip,double pricePerson,String placeParking,String referenceDestiny)
    {
        tripMapper.saveTripDay(idDistrit,idEntity,numberPersonCapacity,idCar,0,dayTrip, hourTrip,pricePerson,placeParking,referenceDestiny);
    }
    
    public TripBean getTripByIDUser(String idUser)
    {
        ArrayList<TripBean> tripBeanList=null;
        tripBeanList=tripMapper.getTripByIDUser(idUser);
        if (tripBeanList.size()!=0) return tripBeanList.get(0);
        return null;
    }
    
    public void removeUserTrip(String idUser,int idTrip,int flagActive)
    {
        tripMapper.removeUserTrip(idUser, idTrip);
        if (flagActive==1)
            tripMapper.updateTripAfterRemoveUser(idTrip);    
    }
    
    public void releaseDriverToTrip(int idTrip)
    {
        tripMapper.releaseDriverToTrip(idTrip);
    }
    
    public ArrayList<String> getUsersInTrip(int idTripDay)
    {
        return tripMapper.getUsersInTrip(idTripDay);
    }
    
    public int getFlagNeedExtraSpace(String idUser,int idTripDay)
    {
        return tripMapper.getFlagNeedExtraSpace(idUser,idTripDay);
    }
    
}
