package com.simonsejse.managing;

import java.util.HashMap;
import java.util.Map;

public class Block {

    public Block(){

    }

    /* Properties */
    /**
     * @Key a string for the reason name e.g. 'slagvagt' or 'slag'
     * @Value a Reason object containing all data the reason needs e.g. time, price etc.
     * @Usage reasons.get('slagvagt') returns Reason object
     */
    private Map<String, Reason> reasons = new HashMap<>();
    private int locationX;
    private int locationY;
    private int locationZ;

     /* Getters and Setters */

    /**
     *
     * @return map containing all reason objects
     */
    public Map<String, Reason> getReasons(){
        return this.reasons;
    }

    /**
     *
     * @return the X-axis of the location
     */
    public int getLocationX() {
        return locationX;
    }

    /**
     *
     * @return the Y-axis of the location
     */
    public int getLocationY() {
        return locationY;
    }

    /**
     *
     * @return the Z-axis of the location
     */
    public int getLocationZ() {
        return locationZ;
    }

    /**
     *
     * @param reasons new reason data
     */
    public void setReasons(Map<String, Reason> reasons) {
        this.reasons = reasons;
    }

    /**
     *
     * @param locationX new X value for location
     */
    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    /**
     *
     * @param locationY new Y value for location
     */
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    /**
     *
     * @param locationZ new Z value for location
     */
    public void setLocationZ(int locationZ) {
        this.locationZ = locationZ;
    }
}
