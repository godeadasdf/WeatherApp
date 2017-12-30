package com.example.kangning.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kangning.weatherapp.DataProvider.horizontalChart.HorizontalChartDataProvider;
import com.example.kangning.weatherapp.DataProvider.horizontalChart.HorizontalChartInfo;
import com.example.kangning.weatherapp.adapter.HorizontalChartAdapterDual;


public class Main2Activity extends AppCompatActivity {

    private HorizontalChartInfo horizontalChartInfo = HorizontalChartDataProvider.getData();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.data_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new HorizontalChartAdapterDual(R.layout.listview_item_horizontal_chart_dual,
                horizontalChartInfo.getList(),
                horizontalChartInfo.getList().get(0).getNum()));
    }
}

