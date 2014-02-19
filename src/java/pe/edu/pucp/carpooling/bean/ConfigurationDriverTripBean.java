/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.bean;

/**
 *
 * @author Cesar
 */
public class ConfigurationDriverTripBean {
    
    String idCar;
    int bigCar;
    int numPersonCapacity;
    String destinyReference;
    Double pricePerson;
    int idDistrit;
    String phoneContact;
    String descCar;
    int flagNewDriver;
    double endXPositionMap;
    double endYPositionMap;

    public double getEndXPositionMap() {
        return endXPositionMap;
    }

    public void setEndXPositionMap(double endXPositionMap) {
        this.endXPositionMap = endXPositionMap;
    }

    public double getEndYPositionMap() {
        return endYPositionMap;
    }

    public void setEndYPositionMap(double endYPositionMap) {
        this.endYPositionMap = endYPositionMap;
    }

    

    public String getDescCar() {
        return descCar;
    }

    public void setDescCar(String descCar) {
        this.descCar = descCar;
    }
    
    

    public int getFlagNewDriver() {
        return flagNewDriver;
    }

    public void setFlagNewDriver(int flagNewDriver) {
        this.flagNewDriver = flagNewDriver;
    }
    
    

    public int getBigCar() {
        return bigCar;
    }

    public void setBigCar(int bigCar) {
        this.bigCar = bigCar;
    }

    public int getNumPersonCapacity() {
        return numPersonCapacity;
    }

    public void setNumPersonCapacity(int numPersonCapacity) {
        this.numPersonCapacity = numPersonCapacity;
    }

    public String getDestinyReference() {
        return destinyReference;
    }

    public void setDestinyReference(String destinyReference) {
        this.destinyReference = destinyReference;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public Double getPricePerson() {
        return pricePerson;
    }

    public void setPricePerson(Double pricePerson) {
        this.pricePerson = pricePerson;
    }

    public int getIdDistrit() {
        return idDistrit;
    }

    public void setIdDistrit(int idDistrit) {
        this.idDistrit = idDistrit;
    }

    public String getPhoneContact() {
        return phoneContact;
    }

    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }
    
}
