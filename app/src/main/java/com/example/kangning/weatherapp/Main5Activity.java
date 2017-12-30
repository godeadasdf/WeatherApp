package com.example.kangning.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kangning.weatherapp.DataProvider.chart.ChartDataProvider;
import com.example.kangning.weatherapp.DataProvider.chart.model.ChartInfoLineColumn;
import com.example.kangning.weatherapp.view.ComboLineBarView;

public class Main5Activity extends AppCompatActivity {

    private ChartInfoLineColumn chartInfoLineColumn = ChartDataProvider.getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ComboLineBarView comboLineColumnChartView = findViewById(R.id.combo_chart);
        comboLineColumnChartView.setData(chartInfoLineColumn.getList());
    }
}
