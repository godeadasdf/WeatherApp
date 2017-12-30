package com.example.kangning.weatherapp.adapter;

import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.kangning.weatherapp.DataProvider.horizontalChart.HorizontalChartItem;
import com.example.kangning.weatherapp.R;

import java.util.List;

/**
 * Created by kangning on 2017/12/30.
 */

public class HorizontalChartAdapterSingle extends BaseQuickAdapter<HorizontalChartItem, BaseViewHolder> {
    private float lineMaxLength;
    private float maxNum;

    public HorizontalChartAdapterSingle(int layoutResId, List data, float maxNum, float lineMaxLength) {
        super(layoutResId, data);
        this.maxNum = maxNum;
        this.lineMaxLength = lineMaxLength;
    }

    @Override
    protected void convert(BaseViewHolder helper, HorizontalChartItem item) {
        helper.setText(R.id.station, item.getZone_name());
        helper.setText(R.id.number, item.getNum() + "");
        helper.setText(R.id.rate, item.getRate());
        LinearLayout lineNum = helper.getView(R.id.number_line);
        float numLength = (item.getNum() / maxNum) * lineMaxLength;
        lineNum.setMinimumWidth((int) numLength);
    }
}
