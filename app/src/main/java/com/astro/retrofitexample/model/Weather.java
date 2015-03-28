package com.astro.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sergio Mattioli on 24/03/2015.
 */
public class Weather {

    @SerializedName("description")
    private String strDesc;
    @SerializedName("icon")
    private String strIconName;

    public String getStrDesc() {
        return strDesc;
    }

    public String getStrIconName() {
        return strIconName;
    }
}