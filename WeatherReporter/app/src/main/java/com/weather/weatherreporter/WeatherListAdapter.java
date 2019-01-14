package com.weather.weatherreporter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weather.weatherreporter.model.Main;
import com.weather.weatherreporter.model.WeatherListData;

import java.util.List;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.ReportViewHolder> {

    Context mCtx;
    List<WeatherListData> dataList;

    public WeatherListAdapter(Context mCtx, List<WeatherListData> weatherList) {
        this.mCtx = mCtx;
        this.dataList = weatherList;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        WeatherListData weatherdata = dataList.get(position);


        holder.temp_min.setText(String.valueOf(weatherdata.getReport().getTemp_min()));
        holder.temp_max.setText(String.valueOf(weatherdata.getReport().getTemp_max()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ReportViewHolder extends RecyclerView.ViewHolder {

        TextView temp_min,temp_max;

        public ReportViewHolder(View itemView) {
            super(itemView);

            temp_min = itemView.findViewById(R.id.temp_min);
            temp_max = itemView.findViewById(R.id.temp_max);
        }
    }
}