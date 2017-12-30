package com.example.kangning.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kangning.weatherapp.DataProvider.horizontalChart.HorizontalChartDataProvider;
import com.example.kangning.weatherapp.DataProvider.horizontalChart.HorizontalChartInfo;
import com.example.kangning.weatherapp.adapter.HorizontalChartAdapterDual;


public class Main2Activity extends AppCompatActivity {

    private HorizontalChartInfo horizontalChartInfo = HorizontalChartDataProvider.getData();
    private RecyclerView recyclerView;
    private LinearLayout forMeasure;
    private LinearLayout measureLine;
    private TextView measureNum;

    private int maxLength; //条最大长度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //求解最大长度

        // forMeasure.setVisibility(View.GONE);

        //显示list
        recyclerView = findViewById(R.id.data_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        forMeasure = findViewById(R.id.for_measure);
        measureLine = findViewById(R.id.measure_line);
        measureNum = findViewById(R.id.measure_num);
        measureNum.setText(horizontalChartInfo.getList().get(0).getNum() + "");
        maxLength = measureLine.getWidth();
        forMeasure.setVisibility(View.GONE);
        recyclerView.setAdapter(new HorizontalChartAdapterDual(R.layout.listview_item_horizontal_chart_dual,
                horizontalChartInfo.getList(),
                horizontalChartInfo.getList().get(0).getNum(),
                (float) maxLength));
        recyclerView.setVisibility(View.VISIBLE);
    }
}

