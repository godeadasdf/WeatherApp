package com.example.kangning.weatherapp.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.kangning.weatherapp.DataProvider.horizontalChart.HorizontalChartInfo;
import com.example.kangning.weatherapp.DataProvider.horizontalChart.HorizontalChartItem;

import java.util.List;

/**
 * Created by kangning on 2017/12/30.
 */

public class HorizontalChartAdapter extends BaseQuickAdapter<HorizontalChartItem, BaseViewHolder> {

    private float lineMaxLength = 1000; //todo dp -> px

    public HorizontalChartAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HorizontalChartItem item) {

    }
}
