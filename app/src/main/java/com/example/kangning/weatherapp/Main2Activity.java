package com.example.kangning.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Line line = findViewById(R.id.line);
        line.setLength(100);
    }
}

