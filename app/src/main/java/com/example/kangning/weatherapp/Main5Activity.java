package com.example.kangning.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kangning.weatherapp.DataProvider.chart.ChartDataProvider;
import com.example.kangning.weatherapp.DataProvider.chart.model.ChartInfoLineColumn;
import com.example.kangning.weatherapp.DataProvider.horizontalChart.HorizontalChartDataProvider;
import com.example.kangning.weatherapp.DataProvider.horizontalChart.model.HorizontalChartInfo;
import com.example.kangning.weatherapp.view.ComboLineBarView;
import com.example.kangning.weatherapp.view.HorizontalChartDual;
import com.example.kangning.weatherapp.view.HorizontalChartSingle;

public class Main5Activity extends AppCompatActivity {

    private HorizontalChartInfo chartInfoLineColumn = HorizontalChartDataProvider.getData();

    private HorizontalChartSingle comboLineColumnChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        comboLineColumnChartView = findViewById(R.id.combo_chart);
        comboLineColumnChartView.setData(chartInfoLineColumn.getList());
    }

}
