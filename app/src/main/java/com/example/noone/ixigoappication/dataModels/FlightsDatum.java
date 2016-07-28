package com.example.noone.ixigoappication.dataModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by NoOne on 7/27/2016.
 */
public class FlightsDatum {

    @SerializedName("originCode")
    @Expose
    private String originCode;
    @SerializedName("destinationCode")
    @Expose
    private String destinationCode;
    @SerializedName("takeoffTime")
    @Expose
    private String takeoffTime;
    @SerializedName("landingTime")
    @Expose
    private String landingTime;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("airlineCode")
    @Expose
    private String airlineCode;
    @SerializedName("class")
    @Expose
    private String _class;

    /**
     *
     * @return
     * The originCode
     */
    public String getOriginCode() {
        return originCode;
    }

    /**
     *
     * @param originCode
     * The originCode
     */
    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    /**
     *
     * @return
     * The destinationCode
     */
    public String getDestinationCode() {
        return destinationCode;
    }

    /**
     *
     * @param destinationCode
     * The destinationCode
     */
    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    /**
     *
     * @return
     * The takeoffTime
     */
    public String getTakeoffTime() {
        return takeoffTime;
    }

    /**
     *
     * @param takeoffTime
     * The takeoffTime
     */
    public void setTakeoffTime(String takeoffTime) {
        this.takeoffTime = takeoffTime;
    }

    /**
     *
     * @return
     * The landingTime
     */
    public String getLandingTime() {
        return landingTime;
    }

    /**
     *
     * @param landingTime
     * The landingTime
     */
    public void setLandingTime(String landingTime) {
        this.landingTime = landingTime;
    }

    /**
     *
     * @return
     * The price
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @return
     * The airlineCode
     */
    public String getAirlineCode() {
        return airlineCode;
    }

    /**
     *
     * @param airlineCode
     * The airlineCode
     */
    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    /**
     *
     * @return
     * The _class
     */
    public String getClass_() {
        return _class;
    }

    /**
     *
     * @param _class
     * The class
     */
    public void setClass_(String _class) {
        this._class = _class;
    }

}
