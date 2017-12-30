package com.example.kangning.weatherapp.model;

import android.content.Context;
import android.util.AttributeSet;

import lecho.lib.hellocharts.BuildConfig;
import lecho.lib.hellocharts.listener.ComboLineColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.listener.DummyCompoLineColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.ChartData;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SelectedValue;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.provider.ColumnChartDataProvider;
import lecho.lib.hellocharts.provider.LineChartDataProvider;
import lecho.lib.hellocharts.renderer.ColumnChartRenderer;
import lecho.lib.hellocharts.renderer.ComboLineColumnChartRenderer;
import lecho.lib.hellocharts.renderer.LineChartRenderer;
import lecho.lib.hellocharts.view.AbstractChartView;

/**
 * ComboChart, supports ColumnChart combined with LineChart. Lines are always drawn on top.
 *
 * @author Leszek Wach
 */
public class DualYComboChart extends AbstractChartView implements DualYComboChartProvider {
    private static final String TAG = "ComboLineColumnChartView";
    protected DualYComboData data;
    protected ColumnChartDataProvider columnChartDataProvider = new ComboColumnChartDataProvider();
    protected LineChartDataProvider lineChartDataProvider = new ComboLineChartDataProvider();
    protected ComboLineColumnChartOnValueSelectListener onValueTouchListener = new
            DummyCompoLineColumnChartOnValueSelectListener();

    public DualYComboChart(Context context) {
        this(context, null, 0);
    }

    public DualYComboChart(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DualYComboChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setChartRenderer(new ComboLineColumnChartRenderer(context, this, columnChartDataProvider,
                lineChartDataProvider));
        setDualYComboData(DualYComboData.generateDummyData());
    }

    @Override
    public DualYComboData getComboLineColumnChartData() {
        return data;
    }

    public void setAxisXBottom(Axis axisX) {
        data.getColumnChartData().setAxisXBottom(axisX);
        data.getLineChartData().setAxisXBottom(axisX);
        this.setDualYComboData(data);
    }

    public void setAxisYLeft(Axis axisY) {
        data.getColumnChartData().setAxisYLeft(axisY);
        this.setDualYComboData(data);
    }

    public void setAxisYRight(Axis axisY) {
        data.getLineChartData().setAxisYRight(axisY);
        this.setDualYComboData(data);
    }

    @Override
    public void setDualYComboData(DualYComboData data) {
        if (BuildConfig.DEBUG) {
            // Log.d(TAG, "Setting data for ComboLineColumnChartView");
        }

        if (null == data) {
            this.data = null;// generateDummyData();
        } else {
            this.data = data;
        }

        super.onChartDataChange();
    }

    @Override
    public ChartData getChartData() {
        return data;
    }

    @Override
    public void callTouchListener() {
        SelectedValue selectedValue = chartRenderer.getSelectedValue();

        if (selectedValue.isSet()) {

            if (SelectedValue.SelectedValueType.COLUMN.equals(selectedValue.getType())) {

                SubcolumnValue value = data.getColumnChartData().getColumns().get(selectedValue.getFirstIndex())
                        .getValues().get(selectedValue.getSecondIndex());
                onValueTouchListener.onColumnValueSelected(selectedValue.getFirstIndex(),
                        selectedValue.getSecondIndex(), value);

            } else if (SelectedValue.SelectedValueType.LINE.equals(selectedValue.getType())) {

                PointValue value = data.getLineChartData().getLines().get(selectedValue.getFirstIndex()).getValues()
                        .get(selectedValue.getSecondIndex());
                onValueTouchListener.onPointValueSelected(selectedValue.getFirstIndex(), selectedValue.getSecondIndex(),
                        value);

            } else {
                throw new IllegalArgumentException("Invalid selected value type " + selectedValue.getType().name());
            }
        } else {
            onValueTouchListener.onValueDeselected();
        }
    }

    public ComboLineColumnChartOnValueSelectListener getOnValueTouchListener() {
        return onValueTouchListener;
    }

    public void setOnValueTouchListener(ComboLineColumnChartOnValueSelectListener touchListener) {
        if (null != touchListener) {
            this.onValueTouchListener = touchListener;
        }
    }

    public void setColumnChartRenderer(Context context, ColumnChartRenderer columnChartRenderer) {
        setChartRenderer(new ComboLineColumnChartRenderer(context, this, columnChartRenderer, lineChartDataProvider));
    }

    public void setLineChartRenderer(Context context, LineChartRenderer lineChartRenderer) {
        setChartRenderer(new ComboLineColumnChartRenderer(context, this, columnChartDataProvider, lineChartRenderer));
    }

    private class ComboLineChartDataProvider implements LineChartDataProvider {

        @Override
        public LineChartData getLineChartData() {
            return DualYComboChart.this.data.getLineChartData();
        }

        @Override
        public void setLineChartData(LineChartData data) {
            DualYComboChart.this.data.setLineChartData(data);

        }

    }

    private class ComboColumnChartDataProvider implements ColumnChartDataProvider {

        @Override
        public ColumnChartData getColumnChartData() {
            return DualYComboChart.this.data.getColumnChartData();
        }

        @Override
        public void setColumnChartData(ColumnChartData data) {
            DualYComboChart.this.data.setColumnChartData(data);

        }

    }

}
