package com.example.noone.ixigoappication.dataModels;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by NoOne on 7/27/2016.
 */
public class AirlineMap {

    @SerializedName("SJ")
    @Expose
    private String sJ;
    @SerializedName("AI")
    @Expose
    private String aI;
    @SerializedName("G8")
    @Expose
    private String g8;
    @SerializedName("JA")
    @Expose
    private String jA;
    @SerializedName("IN")
    @Expose
    private String iN;

    /**
     *
     * @return
     * The sJ
     */
    public String getSJ() {
        return sJ;
    }

    /**
     *
     * @param sJ
     * The SJ
     */
    public void setSJ(String sJ) {
        this.sJ = sJ;
    }

    /**
     *
     * @return
     * The aI
     */
    public String getAI() {
        return aI;
    }

    /**
     *
     * @param aI
     * The AI
     */
    public void setAI(String aI) {
        this.aI = aI;
    }

    /**
     *
     * @return
     * The g8
     */
    public String getG8() {
        return g8;
    }

    /**
     *
     * @param g8
     * The G8
     */
    public void setG8(String g8) {
        this.g8 = g8;
    }

    /**
     *
     * @return
     * The jA
     */
    public String getJA() {
        return jA;
    }

    /**
     *
     * @param jA
     * The JA
     */
    public void setJA(String jA) {
        this.jA = jA;
    }

    /**
     *
     * @return
     * The iN
     */
    public String getIN() {
        return iN;
    }

    /**
     *
     * @param iN
     * The IN
     */
    public void setIN(String iN) {
        this.iN = iN;
    }

}
