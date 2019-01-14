package com.weather.weatherreporter.model;

import com.google.gson.annotations.SerializedName;

class City {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String country;
    @SerializedName("population")
    private String population;

}
