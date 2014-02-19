/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.mapper;

import java.util.Date;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import pe.edu.pucp.carpooling.bean.CarBean;
import pe.edu.pucp.carpooling.bean.UserBean;

/**
 *
 * @author Cesar
 */
@Component
public interface UserMapper {
    
    public UserBean verifyUser(@Param ("idUser") String idUser,@Param ("password") String password);
    public String verifyCodeMail(@Param ("idUser") String idUser);
    public void setUserMailVerified(@Param ("idUser") String idUser);
    public Integer getCodeFlag(@Param ("idUser") String idUser);
    public UserBean verifyIdUserInRegister(@Param ("idUser") String idUser);
    public void addUser(@Param ("idUser") String idUser,@Param ("name") String name,
                        @Param ("app") String app,@Param ("apm") String apm,
                        @Param ("password") String password,
                        @Param ("registerDay") Date registerDay,@Param ("idCar") String idCar,
                        @Param ("phoneContact") String phoneContact,@Param("idEntity")int idEntity,
                        @Param("idUserIntoEntity")String idUserIntoEntity,
                        @Param ("destinyPointMap")String destinyPointMap,
                        @Param("idDistrit")int idDistrit,
                        @Param ("codeMail") String codeMail);
    
    public String getCarByUser(@Param ("idUser") String idUser);
    public String verifyIdCarInRegister(@Param ("idCar") String idCar);
    public String getEndPositionMap(@Param("idUser") String idUser);
    public UserBean getUserById(@Param("idUser")String idUser);
    public String getUserByCar(@Param("idCar")String idCar);
    public void updateUserAddCar(@Param ("idUser") String idUser,@Param ("name") String name,@Param ("app")String app,@Param ("apm")String apm,
                            @Param ("idCar") String idCar,
                            @Param ("phoneContact") String phoneContact,
                            @Param ("userIntoEntity") String userIntoEntity,
                            @Param ("destinyPointMap") String destinyPointMap,@Param ("idDistrit") int idDistrit);
    public void updateUser(@Param ("idUser") String idUser,@Param ("name") String name,@Param ("app")String app,@Param ("apm")String apm,
                            @Param ("phoneContact") String phoneContact,
                            @Param ("userIntoEntity") String userIntoEntity);
    public void updateUserPassword(@Param ("idUser") String idUser,@Param ("password")String password);
    public String recoverPassword(@Param ("idUser") String idUser);
    public Integer getFlagVerify(@Param ("idUser") String idUser);
    public CarBean getCar(@Param ("idUser") String idUser);
    
}
