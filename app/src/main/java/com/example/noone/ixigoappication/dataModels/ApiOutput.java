package com.example.noone.ixigoappication.dataModels;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by NoOne on 7/27/2016.
 */
public class ApiOutput {

    @SerializedName("airlineMap")
    @Expose
    private Map<String, String> airlineMap;
    @SerializedName("airportMap")
    @Expose
    private Map<String, String> airportMap;
    @SerializedName("flightsData")
    @Expose
    private List<FlightsDatum> flightsData = new ArrayList<FlightsDatum>();

    /**
     *
     * @return
     * The airlineMap
     */
    public Map<String, String> getAirlineMap() {
        return airlineMap;
    }

    /**
     *
     * @param airlineMap
     * The airlineMap
     */
    public void setAirlineMap(Map<String, String> airlineMap) {
        this.airlineMap = airlineMap;
    }

    /**
     *
     * @return
     * The airportMap
     */
    public Map<String, String> getAirportMap() {
        return airportMap;
    }

    /**
     *
     * @param airportMap
     * The airportMap
     */
    public void setAirportMap(Map<String, String> airportMap) {
        this.airportMap = airportMap;
    }

    /**
     *
     * @return
     * The flightsData
     */
    public List<FlightsDatum> getFlightsData() {
        return flightsData;
    }

    /**
     *
     * @param flightsData
     * The flightsData
     */
    public void setFlightsData(List<FlightsDatum> flightsData) {
        this.flightsData = flightsData;
    }

}
