package com.example.kangning.weatherapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kangning.weatherapp.DataProvider.ChartDataProvider;
import com.example.kangning.weatherapp.model.ChartInfoLineColumn;
import com.example.kangning.weatherapp.model.ChartItemLineColumn;
import com.example.kangning.weatherapp.model.DualYComboChart;
import com.example.kangning.weatherapp.model.DualYComboData;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SubcolumnValue;

public class Main2Activity extends AppCompatActivity {

    private DualYComboChart mComboChart;

    private ChartInfoLineColumn chartInfoLineColumn = ChartDataProvider.getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mComboChart = findViewById(R.id.combochart);
        initComboChart();
        addDateForChart();

    }

    private void initComboChart() {
        mComboChart.setZoomEnabled(false);//设置是否支持缩放
        //mComboChart.setOnValueTouchListener(ColumnChartOnValueSelectListener touchListener);//为图表设置值得触摸事件
        mComboChart.setInteractive(false);//设置图表是否可以与用户互动
        mComboChart.setValueSelectionEnabled(true);//设置图表数据是否选中进行显示
        //mComboChart.setDualYComboData(ComboLineColumnChartData data);//为图表设置数据，数据类型为ComboLineColumnChartData
    }

    private LineChartData generateLineChartData() {
        LineChartData lineChartData = new LineChartData();
        //数据放入点列表
        List<ChartItemLineColumn> chartList = chartInfoLineColumn.getList();
        List<PointValue> pointsList = new ArrayList<>();
        for (ChartItemLineColumn item : chartList) {
            PointValue point = new PointValue();
            point.set((float) chartList.indexOf(item), item.getRate());
            pointsList.add(point);
        }
        //点列表放入线列表
        Line line = new Line();
        line.setValues(pointsList);
        line.setCubic(true);
        line.setHasLabels(true);
        line.setHasLines(true);
        line.setHasPoints(true);
        List<Line> lineList = new ArrayList<>();
        lineList.add(line);
        lineChartData.setLines(lineList);
        return lineChartData;
    }

    private ColumnChartData generateColumnChartData() {
        ColumnChartData columnChartData = new ColumnChartData();
        //数据放入点列表
        List<ChartItemLineColumn> chartList = chartInfoLineColumn.getList();
        List<SubcolumnValue> subColumnValues = new ArrayList<>();
        for (ChartItemLineColumn item : chartList) {
            SubcolumnValue subColumn = new SubcolumnValue();
            subColumn.setValue(item.getNum());
            subColumnValues.add(subColumn);
        }
        //点列表放入柱列表
        Column column = new Column();
        column.setValues(subColumnValues);
        List<Column> columnList = new ArrayList<>();
        columnList.add(column);
        columnChartData.setColumns(columnList);
        return columnChartData;
    }

    private Axis generateXaxis() {
        Axis axisX = new Axis(); //X轴
        //axisX.setHasTiltedLabels(true);  //X坐标轴字体是斜的显示还是直的，true是斜的显示
        axisX.setTextColor(Color.WHITE);  //设置字体颜色
        axisX.setName("date");  //表格名称
        axisX.setTextSize(10);//设置字体大小
        axisX.setHasLines(true);
        axisX.setMaxLabelChars(8); //最多几个X轴坐标，意思就是你的缩放让X轴上数据的个数7<=x<=mAxisXValues.length
        List<ChartItemLineColumn> chartList = chartInfoLineColumn.getList();
        List<AxisValue> axisValues = new ArrayList<>();
        for (ChartItemLineColumn item : chartList) {
            AxisValue axisValue = new AxisValue((float) chartList.indexOf(item)).setLabel(item.getDate());
            axisValues.add(axisValue);
        }
        axisX.setValues(axisValues);  //填充X轴的坐标名称
        return axisX;
    }

    private Axis generateYaxisLeft() {
        Axis axisY = new Axis();  //Y轴
        axisY.setName("你好");//y轴标注
        axisY.setTextSize(10);//设置字体大小
        axisY.setHasLines(true);
        return axisY;
    }

    private Axis generateYaxiusLeft() {
        Axis axisY = new Axis();  //Y轴
        axisY.setName("");//y轴标注
        axisY.setTextSize(10);//设置字体大小
        axisY.setHasLines(true);
        return axisY;
    }

    private Axis generateYaxiusRight() {
        Axis axisY = new Axis();  //Y轴
        axisY.setName("产单率");//y轴标注
        axisY.setTextSize(10);//设置字体大小
        return axisY;
    }

    private void addDateForChart() {
        DualYComboData dualYChartData = new DualYComboData();//定义组合数据对象
        dualYChartData.setLineChartData(generateLineChartData());//为组合图设置折线图数据
        dualYChartData.setColumnChartData(generateColumnChartData());//为组合图设置柱形图数据
        dualYChartData.setValueLabelsTextColor(Color.BLACK);// 设置数据文字颜色
        dualYChartData.setValueLabelTextSize(15);// 设置数据文字大小
        dualYChartData.setValueLabelTypeface(Typeface.MONOSPACE);// 设置数据文字样式
        mComboChart.setDualYComboData(dualYChartData);//为足额和图添加数据
        mComboChart.setAxisYLeft(generateYaxisLeft());// 将Y轴属性设置到左边
        mComboChart.setAxisXBottom(generateXaxis());// 将X轴属性设置到底部
        mComboChart.setAxisYRight(generateYaxiusRight());//设置右边显示的轴*/
    }


}

