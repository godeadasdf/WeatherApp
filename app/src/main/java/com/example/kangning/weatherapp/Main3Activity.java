package com.example.kangning.weatherapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kangning.weatherapp.DataProvider.chart.ChartDataProvider;
import com.example.kangning.weatherapp.DataProvider.chart.ChartInfoLineColumn;
import com.example.kangning.weatherapp.DataProvider.chart.ChartItemLineColumn;
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

public class Main3Activity extends AppCompatActivity {

    private CombinedChart combinedChart;

    //fake data
    private ChartInfoLineColumn chartInfoLineColumn = ChartDataProvider.getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        combinedChart = findViewById(R.id.chart);

        // 把line在bar的前面
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

        XAxis bottomAxis = combinedChart.getXAxis();
        bottomAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        bottomAxis.setAxisMinimum(0f);


        CombinedData data = new CombinedData();

        //设置LineData 和 BarData
        data.setData(generateLineData());
        data.setData(generateBarData());

        //设置横轴
        bottomAxis.setAxisMaximum(data.getXMax() + 0.25f);
        bottomAxis.setLabelCount(chartInfoLineColumn.getList().size());
        bottomAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (value < chartInfoLineColumn.getList().size() + 1 && value > 0)
                    return chartInfoLineColumn.getList().get((int) value - 1).getDate();
                else
                    return "";
            }
        });

        //设置表的描述信息 暂时置空
        Description description = new Description();
        description.setText("");
        combinedChart.setDescription(description);

        combinedChart.setData(data);
        combinedChart.invalidate();
    }

    private LineData generateLineData() {

        LineData d = new LineData();

        ArrayList<Entry> entries = new ArrayList();
        List<ChartItemLineColumn> dataList = chartInfoLineColumn.getList();

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

    private BarData generateBarData() {

        ArrayList<BarEntry> entries1 = new ArrayList();

        List<ChartItemLineColumn> dataList = chartInfoLineColumn.getList();
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
