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
public class TripBean {
    
    int idTripDay;
    int idDistrit;
    int idUniversity;
    String idCar;
    int numPersonAboard;
    Date dayTrip;
    String hourTrip;
    Double pricePerson;
    String placeParking;
    int numPersonCapacity;
    String destinyReference;
    int bigCar;
    int flagActive;

    public int getBigCar() {
        return bigCar;
    }

    public void setBigCar(int bigCar) {
        this.bigCar = bigCar;
    }

    
    
    public int getFlagActive() {
        return flagActive;
    }

    public void setFlagActive(int flagActive) {
        this.flagActive = flagActive;
    }
    
    

    public int getIdTripDay() {
        return idTripDay;
    }

    public void setIdTripDay(int idTripDay) {
        this.idTripDay = idTripDay;
    }

    public String getDestinyReference() {
        return destinyReference;
    }

    public void setDestinyReference(String destinyReference) {
        this.destinyReference = destinyReference;
    }
    
    

    public int getNumPersonCapacity() {
        return numPersonCapacity;
    }

    public void setNumPersonCapacity(int numPersonCapacity) {
        this.numPersonCapacity = numPersonCapacity;
    }


    public int getIdDistrit() {
        return idDistrit;
    }

    public void setIdDistrit(int idDistrit) {
        this.idDistrit = idDistrit;
    }

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public int getNumPersonAboard() {
        return numPersonAboard;
    }

    public void setNumPersonAboard(int numPersonAboard) {
        this.numPersonAboard = numPersonAboard;
    }

    public Date getDayTrip() {
        return dayTrip;
    }

    public void setDayTrip(Date dayTrip) {
        this.dayTrip = dayTrip;
    }

    public String getHourTrip() {
        return hourTrip;
    }

    public void setHourTrip(String hourTrip) {
        this.hourTrip = hourTrip;
    }

    public Double getPricePerson() {
        return pricePerson;
    }

    public void setPricePerson(Double pricePerson) {
        this.pricePerson = pricePerson;
    }

    public String getPlaceParking() {
        return placeParking;
    }

    public void setPlaceParking(String placeParking) {
        this.placeParking = placeParking;
    }
    
}
