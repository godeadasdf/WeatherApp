package com.example.kangning.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Monday 12/18 - Sunny -1/6",
            "Tuesday 12/19 - Windy -8/-2",
            "Wednesday 12/20 - Cloudy 0/6",
            "Thursday 12/21 - Snow -2/4",
            "Friday 12/22 - Sunny -1/3",
            "Saturday 12/23 - Windy 0/6",
            "Sunday 12/24 - Tornado -10/-6"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList = findViewById<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)
    }
}
