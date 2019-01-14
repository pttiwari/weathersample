package com.weather.weatherreporter.model;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("id")
   private String id;
    @SerializedName("main")
   private String main;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

}
