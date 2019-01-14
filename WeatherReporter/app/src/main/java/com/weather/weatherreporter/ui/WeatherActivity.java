package com.weather.weatherreporter.ui;

import android.arch.lifecycle.Observer;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.weather.weatherreporter.R;
import com.weather.weatherreporter.WeatherListAdapter;
import com.weather.weatherreporter.model.Main;

import java.util.List;

public class WeatherActivity extends AppCompatActivity {
public static int fragId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, WeatherFragment.newInstance())
                    .commitNow();
        }
    }

    public void showCityChangeDialog(View view) {
        AlertDialog.Builder alrt = new AlertDialog.Builder(this);
        alrt.setTitle("Change City Name");
        alrt.setView(R.layout.change_city);
        alrt.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText et_change_city = (EditText) ((AlertDialog) dialog).findViewById(R.id.et_change_city);
if(et_change_city.getText()!=null )
                callChangeMethod(et_change_city.getText().toString().trim());
            }
        });
        alrt.show();
    }

    private void callChangeMethod(String newCity) {
        Fragment fm = getSupportFragmentManager().findFragmentById(fragId);

        if (fm instanceof WeatherFragment) {

            ((WeatherFragment)fm).cityChanged(newCity);
        }

    }
}
