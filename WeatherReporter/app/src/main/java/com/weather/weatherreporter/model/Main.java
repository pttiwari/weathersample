package com.weather.weatherreporter.model;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private float temp;
    @SerializedName("pressure")
    private float pressure;
    @SerializedName("humidity")
    private float humidity;
    @SerializedName("temp_min")
    private float temp_min;
    @SerializedName("temp_max")
    private float temp_max;

    public float getTemp() {
        return temp;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public Main(float temp, float pressure, float humidity, float temp_min, float temp_max) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
    }
}
