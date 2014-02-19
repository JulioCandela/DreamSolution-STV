/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.services;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pucp.carpooling.bean.CarBean;
import pe.edu.pucp.carpooling.bean.UserBean;
import pe.edu.pucp.carpooling.mapper.EntityMapper;
import pe.edu.pucp.carpooling.mapper.UserMapper;

/**
 *
 * @author Cesar
 */
@Service
public class UserService {
    
    @Autowired
    UserMapper userMapper;
    
    @Autowired
    EntityMapper entityMapper;
    
    public UserBean verifyUser(String idUser, String password)
    {
        UserBean userBean=userMapper.verifyUser(idUser, password);
        return userBean;
    }
    
    public String verifyCodeMail(String idUser)
    {
       return userMapper.verifyCodeMail(idUser);
        
    }
    
    public void setUserMailVerified(String idUser)
    {
        userMapper.setUserMailVerified(idUser);
    }
    
    public int getCodeFlag(String idUser)
    {
        System.out.println("aaaaaaaaa "+userMapper.getCodeFlag(idUser));
       return userMapper.getCodeFlag(idUser);
        
    }
    
    public boolean verifyIdUserInRegister(String idUser,int idEntity)
    {
        String hostName=entityMapper.getHostNameEntity(idEntity);
        System.out.println(idEntity);
        System.out.println("HOSTNAME= "+hostName);
        int hostvalidate=0;
        String[] hostNameArray=hostName.split("/");
        for (int i=0;i<hostNameArray.length;i++)
        {
            if ((idUser.split("@")[1]).equalsIgnoreCase(hostNameArray[i]))            
                break;
                       
            if (hostNameArray.length==i+1) return true;
        }
        
        UserBean userBean=userMapper.verifyIdUserInRegister(idUser);
        if (userBean!=null) return true;
        return false;
    }
    
    public boolean verifyIdCarInRegister(String idCar)
    {
        String cad=userMapper.verifyIdCarInRegister(idCar);
        if (cad!=null) return true;
        return false;
    }
    
    
    public void addUser(String idUser,String name,String app,String apm,String password,
               Date registerDay,String idCar,String phoneContact,int idEntity,String idUserIntoEntity,String destinyPointMap,int idDistrit,String codeMail)
    {
        userMapper.addUser(idUser, name, app, apm, password, registerDay, idCar, phoneContact,idEntity,idUserIntoEntity,destinyPointMap,idDistrit,codeMail);
    }
    
    public String getCarByUser(String idUser)
    {
        return userMapper.getCarByUser(idUser);
    }
    
    public String getEndPositionMap(String idUser)
    {
        return userMapper.getEndPositionMap(idUser);
    }
    
    public UserBean getUserById(String idUser)
    {
        return userMapper.getUserById(idUser);
    }
    
    public String getUserByCar(String idCar)
    {
        return userMapper.getUserByCar(idCar);
    }
    
    public void updateUserAddCar(String idUser,String name,String app,String apm,String idCar,String phoneContact,
                            String userIntoEntity,String destinyPointMap,int idDistrit)
    {
        userMapper.updateUserAddCar(idUser,name,app,apm,idCar,phoneContact,
                            userIntoEntity,destinyPointMap,idDistrit);
        
    }
    public void updateUserPassword(String idUser,String password)
    {
        userMapper.updateUserPassword(idUser, password);
    }
    
    public void updateUser(String idUser,String name,String app,String apm,String phoneContact,String userIntoEntity)
    {
        System.out.println(idUser+" "+name+" "+app+" "+apm+" "+phoneContact+" "+userIntoEntity);
        userMapper.updateUser(idUser, name, app, apm, phoneContact, userIntoEntity);
    }
    
    public String recoverPassword(String idUser)
    {
        return userMapper.recoverPassword(idUser);
    }
    
    public Integer getFlagVerify(String idUser)
    {
        return userMapper.getCodeFlag(idUser);
        
    }
    
    public CarBean getCar(String idUser)
    {
        return userMapper.getCar(idUser);
    }
    
}
