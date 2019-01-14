package com.weather.weatherreporter.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.weather.weatherreporter.Api;
import com.weather.weatherreporter.model.Main;
import com.weather.weatherreporter.model.Weather;
import com.weather.weatherreporter.model.WeatherData;
import com.weather.weatherreporter.model.WeatherListData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherViewModel extends ViewModel {
    //this is the data that we will fetch asynchronously
    public MutableLiveData<List<WeatherListData>> dataList;

    //we will call this method to get the data
    public LiveData<List<WeatherListData>> getdata(String city_name) {
        //if the list is null
        if (dataList == null) {
            dataList = new MutableLiveData<List<WeatherListData>>();
            //we will load it asynchronously from server in this method
            loadWeatherReport(city_name);
        }

        //finally we will return the list
        return dataList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadWeatherReport(String city_name) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<WeatherData> call = api.getWeatherData(city_name);


        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
Log.i("pankaj","url>>"+response.raw());
                //finally we are setting the list to our MutableLiveData
                List<WeatherListData> weatherlist= response.body().getList();
                dataList.setValue(weatherlist);
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {

            }

        });
    }
}
