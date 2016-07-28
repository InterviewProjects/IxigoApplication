package com.example.noone.ixigoappication.dataModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AirportMap {

    @SerializedName("DEL")
    @Expose
    private String dEL;
    @SerializedName("MUM")
    @Expose
    private String mUM;

    /**
     *
     * @return
     * The dEL
     */
    public String getDEL() {
        return dEL;
    }

    /**
     *
     * @param dEL
     * The DEL
     */
    public void setDEL(String dEL) {
        this.dEL = dEL;
    }

    /**
     *
     * @return
     * The mUM
     */
    public String getMUM() {
        return mUM;
    }

    /**
     *
     * @param mUM
     * The MUM
     */
    public void setMUM(String mUM) {
        this.mUM = mUM;
    }

}
