package com.example.kangning.weatherapp.model;

import lecho.lib.hellocharts.model.AbstractChartData;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.LineChartData;

/**
 * Data model for combo line-column chart. It uses ColumnChartData and LineChartData internally.
 */
public class DualYComboData extends AbstractChartData {

    private ColumnChartData columnChartData;
    private LineChartData lineChartData;

    public DualYComboData() {
        this.columnChartData = new ColumnChartData();
        this.lineChartData = new LineChartData();
    }

    public static DualYComboData generateDummyData() {
        DualYComboData data = new DualYComboData();
        data.setColumnChartData(ColumnChartData.generateDummyData());
        data.setLineChartData(LineChartData.generateDummyData());
        return data;
    }


    @Override
    public void update(float scale) {
        columnChartData.update(scale);
        lineChartData.update(scale);
    }

    @Override
    public void finish() {
        columnChartData.finish();
        lineChartData.finish();
    }

    public ColumnChartData getColumnChartData() {
        return columnChartData;
    }

    public void setColumnChartData(ColumnChartData columnChartData) {
        if (null == columnChartData) {
            this.columnChartData = new ColumnChartData();
        } else {
            this.columnChartData = columnChartData;
        }
    }

    public LineChartData getLineChartData() {
        return lineChartData;
    }

    public void setLineChartData(LineChartData lineChartData) {
        if (null == lineChartData) {
            this.lineChartData = new LineChartData();
        } else {
            this.lineChartData = lineChartData;
        }
    }

}
