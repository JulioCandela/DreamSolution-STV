/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.bean;

import java.util.Date;

/**
 *
 * @author Cesar
 */
public class UserBean {
    
    String idUser;
    String name;
    String app;
    String apm;
    String password;
    Date birthday;
    Date registerDay;
    String idCar;
    String phoneContact;
    int idDistrit;
    String idUserIntoEntity;

    public String getIdUserIntoEntity() {
        return idUserIntoEntity;
    }

    public void setIdUserIntoEntity(String idUserIntoEntity) {
        this.idUserIntoEntity = idUserIntoEntity;
    }

    public int getIdDistrit() {
        return idDistrit;
    }

    public void setIdDistrit(int idDistrit) {
        this.idDistrit = idDistrit;
    }
    
    

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegisterDay() {
        return registerDay;
    }

    public void setRegisterDay(Date registerDay) {
        this.registerDay = registerDay;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public String getPhoneContact() {
        return phoneContact;
    }

    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }
}
