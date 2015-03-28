package com.astro.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sergio Mattioli on 24/03/2015.
 *
 * Example Result:
 *
 *
 *    { "id":88319,"dt":1345284000,"name":"Benghazi",
 *           "coord":{"lat":32.12,"lon":20.07},
 *           "main":{"temp":306.15,"pressure":1013,"humidity":44,"temp_min":306,"temp_max":306},
 *           "wind":{"speed":1,"deg":-7},
 *           "weather":[
 *                       {"id":520,"main":"rain","description":"light intensity shower rain","icon":"09d"},
 *                       {"id":500,"main":"rain","description":"light rain","icon":"10d"},
 *                       {"id":701,"main":"mist","description":"mist","icon":"50d"}
 *                     ],
 *           "clouds":{"all":90},
 *           "rain":{"3h":3}}
*
 */
public class WeatherResponse {

    @SerializedName("sys")
    private Sys sys;

    @SerializedName("weather")
    private List<Weather> weather;

    @SerializedName("main")
    private MainInfos mainInfos;

    public MainInfos getMainInfos() {
        return mainInfos;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Sys getSys() {
        return sys;
    }

}