package com.astro.retrofitexample.rest;

import com.astro.retrofitexample.model.WeatherResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Sergio Mattioli on 28/03/2015.
 */
public interface Api {

    @GET("/weather")
    void getWeather(@Query("q") String cityName,
                    Callback<WeatherResponse> callback);
}

