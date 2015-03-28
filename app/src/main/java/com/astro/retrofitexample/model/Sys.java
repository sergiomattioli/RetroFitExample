package com.astro.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sergio Mattioli on 28/03/2015.
 */
public class Sys implements Serializable
{
    @SerializedName("country")
    private String country;
    @SerializedName("sunrise")
    private Long sunriseTime;
    @SerializedName("sunset")
    private Long sunsetTime;

    public String getCountry() {
        return country;
    }

    public Long getSunriseTime() {
        return sunriseTime;
    }

    public Long getSunsetTime() {
        return sunsetTime;
    }

}