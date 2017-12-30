package com.example.kangning.weatherapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kangning on 2017/12/30.
 */

public class Line extends View {

    //todo px -> dp
    private float length = 0;
    private Paint paint;

    private void initPaint() {
        paint = new Paint();
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(100);
    }

    public Line(Context context) {
        super(context);
        initPaint();
    }

    public Line(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public void setLength(float length) {
        this.length = length;
        invalidate();
    }

    public void setColor(int color) {
        paint.setColor(color);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(0f, 50f, length, 50f, paint);
    }
}
