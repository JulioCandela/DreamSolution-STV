/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.mapper;

import java.util.ArrayList;
import java.util.Date;
import org.apache.ibatis.annotations.Param;
import pe.edu.pucp.carpooling.bean.TripBean;

        
/**
 *
 * @author Cesar
 */
public interface TripMapper {
    
    public ArrayList<TripBean> getListTripByIdDistrit(@Param ("idDistrit")int idDistrit,
                                                      @Param("dateTrip") String dateTrip,
                                                      @Param ("hourTrip")String hourTrip );
    
    public ArrayList<TripBean> getListTripByIdDistritNeedBigCar(@Param ("idDistrit")int idDistrit,
                                                      @Param("dateTrip") String dateTrip,
                                                      @Param ("hourTrip")String hourTrip,
                                                      @Param ("bigCar")int bigCar );
    
    public void saveUserToTrip(@Param("idCar") String idCar,
                               @Param("idTrip") int idTrip,
                               @Param("needExtra") int needExtra);
    
    public void associateUserTrip(@Param("idUser")String idUser,
                                    @Param("idTrip") int idTrip);
    
    public void saveTripDay(@Param ("idDistrit")int idDistrit,@Param ("idEntity")int idEntity,
            @Param ("numPersonCapacity")int numPersonCapacity,@Param ("idCar")String idCar,
            @Param ("numPersonAboard")int numPersonAboard,@Param ("dayTrip") String dayTrip,
            @Param ("hourTrip")String hourTrip,@Param ("pricePerson")double pricePerson,
            @Param ("placeParking")String placeParking,@Param("referenceDestiny")String referenceDestiny);
    
    public ArrayList<TripBean> getTripByIDUser(@Param("idUser") String idUser);
    
    public void removeUserTrip(@Param("idUser") String idUser,@Param("idTrip") int idTrip);
    public void updateTripAfterRemoveUser(@Param("idTripDay") int idTripDay);
    public void releaseDriverToTrip(@Param("idTrip") int idTrip);
    public ArrayList<String> getUsersInTrip(@Param("idTripDay")int idTripDay);
    public Integer getFlagNeedExtraSpace(@Param("idUser")String idUser,@Param("idTripDay")int idTripDay);
    
}
