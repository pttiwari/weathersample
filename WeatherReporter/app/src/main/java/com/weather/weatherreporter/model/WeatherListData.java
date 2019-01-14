package com.weather.weatherreporter.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherListData {

    public String getDt() {
        return dt;
    }

    public Main getReport() {
        return report;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    @SerializedName("dt")
    private String dt;
    @SerializedName("main")
    private Main report;
    @SerializedName("weather")
    private List<Weather> weather;

  /*  "dt":1547467200,
            "main":{},
            "weather":[],
            "clouds":{},
            "wind":{},
            "sys":{},
            "dt_txt":"2019-01-14 12:00:00"*/
}
