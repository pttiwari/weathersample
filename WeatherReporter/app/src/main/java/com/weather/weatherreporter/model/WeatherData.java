package com.weather.weatherreporter.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherData {
    public String getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }

    public String getCnt() {
        return cnt;
    }

    public List<WeatherListData> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }

    @SerializedName("cod")
    private String cod;
    @SerializedName("message")
    private String message;
    @SerializedName("cnt")
    private String cnt;
    @SerializedName("list")
    private List<WeatherListData> list;
    @SerializedName("city")
    private City city;

}
