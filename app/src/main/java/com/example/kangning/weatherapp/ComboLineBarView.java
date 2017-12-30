package com.example.kangning.weatherapp;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.kangning.weatherapp.DataProvider.chart.model.ChartItemLineColumn;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangning on 2017/12/30.
 */

public class ComboLineBarView extends LinearLayout {

    private CombinedChart combinedChart;

    public ComboLineBarView(Context context) {
        super(context);
        initView();
    }

    public ComboLineBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.view_combo_line_bar, null, false);
        combinedChart = relativeLayout.findViewById(R.id.chart);
        initCombinedChart();
        this.addView(relativeLayout);
    }

    private void initCombinedChart() {
        combinedChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE,
        });

        //legend 图例
        Legend l = combinedChart.getLegend();
        l.setWordWrapEnabled(true);
        //将图例放置在 chart的 顶部左侧
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(true);

        //设置左右两侧的轴
        YAxis rightAxis = combinedChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f);

        YAxis leftAxis = combinedChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(0f);
        //最大值100
        rightAxis.setAxisMaximum(100f);


        //设置表的描述信息 暂时置空
        Description description = new Description();
        description.setText("");
        combinedChart.setDescription(description);
    }


    public void setData(final List<ChartItemLineColumn> chartItems) {

        XAxis bottomAxis = combinedChart.getXAxis();
        bottomAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        bottomAxis.setAxisMinimum(0f);

        CombinedData data = new CombinedData();
        //设置LineData 和 BarData
        data.setData(generateLineData(chartItems));
        data.setData(generateBarData(chartItems));

        //设置横轴
        bottomAxis.setAxisMaximum(data.getXMax() + 0.25f);
        bottomAxis.setLabelCount(chartItems.size());
        bottomAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (value < chartItems.size() + 1 && value > 0)
                    return chartItems.get((int) value - 1).getDate();
                else
                    return "";
            }
        });

        combinedChart.setData(data);
        combinedChart.invalidate();
    }


    private LineData generateLineData(final List<ChartItemLineColumn> chartItems) {

        LineData d = new LineData();

        ArrayList<Entry> entries = new ArrayList();
        List<ChartItemLineColumn> dataList = chartItems;

        for (int index = 0; index < dataList.size(); index++)
            entries.add(new Entry(index + 1f, dataList.get(index).getRate()));

        LineDataSet set = new LineDataSet(entries, "产单率");
        set.setColor(Color.rgb(240, 238, 70));
        set.setLineWidth(2.5f);
        set.setCircleColor(Color.rgb(240, 238, 70));
        set.setCircleRadius(5f);
        set.setFillColor(Color.rgb(240, 238, 70));
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.rgb(240, 238, 70));

        set.setAxisDependency(YAxis.AxisDependency.RIGHT);
        d.addDataSet(set);

        return d;
    }

    private BarData generateBarData(final List<ChartItemLineColumn> chartItems) {

        ArrayList<BarEntry> entries1 = new ArrayList();

        List<ChartItemLineColumn> dataList = chartItems;
        for (int index = 0; index < dataList.size(); index++) {
            entries1.add(new BarEntry(index + 1f, dataList.get(index).getNum()));

            // stacked
        }

        BarDataSet set1 = new BarDataSet(entries1, "产单量");
        set1.setColor(Color.rgb(60, 220, 78));
        set1.setValueTextColor(Color.rgb(60, 220, 78));
        set1.setValueTextSize(10f);
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);

        float barWidth = 0.2f; // x2 dataset
        // (0.45 + 0.02) * 2 + 0.06 = 1.00 -> interval per "group"

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        BarData d = new BarData(dataSets);
        d.setBarWidth(barWidth);


        return d;
    }
}
