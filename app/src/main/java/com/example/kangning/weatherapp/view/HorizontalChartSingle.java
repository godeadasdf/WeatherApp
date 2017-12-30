package com.example.kangning.weatherapp.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kangning.weatherapp.DataProvider.horizontalChart.model.HorizontalChartItem;

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
    }

    public HorizontalChartSingle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
