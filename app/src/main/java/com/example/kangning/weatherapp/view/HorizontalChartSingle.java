package com.example.kangning.weatherapp.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kangning.weatherapp.DataProvider.horizontalChart.model.HorizontalChartItem;
import com.example.kangning.weatherapp.R;
import com.example.kangning.weatherapp.adapter.HorizontalChartAdapterSingle;

import java.util.List;

/**
 * Created by kangning on 2017/12/30.
 */

public class HorizontalChartSingle extends LinearLayout {

    private RelativeLayout relativeLayout;
    private RecyclerView recyclerView;
    private LinearLayout forMeasure;
    private LinearLayout measureLine;
    private TextView measureNum;

    private int maxLength; //条最大长度
    private List<HorizontalChartItem> data = null;

    public HorizontalChartSingle(Context context) {
        super(context);
        init();
    }

    public HorizontalChartSingle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        relativeLayout = (RelativeLayout) inflater.inflate(R.layout.view_horizon_chart_single, null, false);
        recyclerView = relativeLayout.findViewById(R.id.data_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        this.addView(relativeLayout);
    }

    public void setData(List<HorizontalChartItem> data) {
        this.data = data;
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (data != null) {
            forMeasure = findViewById(R.id.for_measure);
            measureLine = findViewById(R.id.measure_line);
            measureNum = findViewById(R.id.measure_num);
            measureNum.setText(data.get(0).getNum() + "");
            //todo why need -100
            maxLength = measureLine.getWidth() - 100;
            forMeasure.setVisibility(View.GONE);
            recyclerView.setAdapter(new HorizontalChartAdapterSingle(R.layout.listview_item_horizontal_chart_single,
                    data,
                    data.get(0).getNum(),
                    (float) maxLength));
            recyclerView.setVisibility(View.VISIBLE);
        }
    }
}

