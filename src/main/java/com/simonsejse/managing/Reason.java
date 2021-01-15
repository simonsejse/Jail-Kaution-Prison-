package com.simonsejse.managing;

public class Reason {

    public Reason(int priceToBail, String name, double timeInMinutes) {
        this.priceToBail = priceToBail;
        this.name = name;
        this.timeInMinutes = timeInMinutes;
    }

    public Reason(){}

    /* Properties */
    private int priceToBail;
    private String name;
    private double timeInMinutes;


    /* Getter and Setters */

    /**
     *
     * @return name of reason
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return time in minutes
     */
    public double getTimeInMinutes(){
        return this.timeInMinutes;
    }

    /**
     *
     * @return the price to bail a person
     */
    public int getPriceToBail(){
        return this.priceToBail;
    }

    /**
     *
     * @param name set new name of reason
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param priceToBail set a new value for price to bail
     */
    public void setPriceToBail(int priceToBail) {
        this.priceToBail = priceToBail;
    }

    /**
     *
     * @param timeInMinutes set new time in minutes
     */
    public void setTimeInMinutes(double timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }
}
