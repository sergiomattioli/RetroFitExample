package com.astro.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sergio Mattioli on 28/03/2015.
 */
public class MainInfos {

    @SerializedName("temp")
    private Double temp;
    @SerializedName("temp_min")
    private Double tempMin;
    @SerializedName("temp_max")
    private Double tempMax;

    public Double getTemp() {
        return temp;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }
}
