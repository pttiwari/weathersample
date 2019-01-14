package com.weather.weatherreporter.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.weather.weatherreporter.R;
import com.weather.weatherreporter.model.Main;
import com.weather.weatherreporter.WeatherListAdapter;
import com.weather.weatherreporter.model.WeatherListData;

import java.util.List;


public class WeatherFragment extends Fragment {

    private WeatherViewModel mViewModel;
    RecyclerView recyclerView;
    WeatherListAdapter adapter;

    List<Main> dataList;
//https://api.openweathermap.org/data/2.5/weather?q=Delhi,IND&appid=429747e2864cda6cf0887dc6e698c1f9
    public static WeatherFragment newInstance() {
        return new WeatherFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        WeatherActivity.fragId=getId();
        return inflater.inflate(R.layout.weather_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        Button btn_change_city =view.findViewById(R.id.btn_change_city);


    }
public void cityChanged(String newCity){
    mViewModel.getdata(newCity).observe(this, new Observer<List<WeatherListData>>() {
        @Override
        public void onChanged(@Nullable List<WeatherListData> dataList) {
            adapter = new WeatherListAdapter(getContext(), dataList);
            recyclerView.setAdapter(adapter);
        }
    });
}
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        cityChanged("Delhi,IN");

    }

}
