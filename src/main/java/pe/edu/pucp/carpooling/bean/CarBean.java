/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.bean;

/**
 *
 * @author Cesar
 */
public class CarBean {
    
    String idCar;
    String idUser;
    String descCar;
    boolean bigCar;

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getDescCar() {
        return descCar;
    }

    public void setDescCar(String descCar) {
        this.descCar = descCar;
    }

    public boolean isBigCar() {
        return bigCar;
    }

    public void setBigCar(boolean bigCar) {
        this.bigCar = bigCar;
    }
    
}
