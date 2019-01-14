package com.weather.weatherreporter;

import com.weather.weatherreporter.model.Main;
import com.weather.weatherreporter.model.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String AppID="429747e2864cda6cf0887dc6e698c1f9";
    String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    @GET("weather?appid=" + AppID)
    Call<WeatherData> getWeatherData(@Query("q") String cityname);
}