package com.example.kangning.weatherapp.model

/**
 * Created by kangning on 2017/12/29.
 */
/*
        "date": "2017-12-28",
        "increase_proportion": "-1.7",
        "num": 22569,
        "rate": "59.1",
        "week_increase_proportion": "15.8"

*/

data class ChartItemLineColumn(val date: String,
                               val increase_proportion: String,
                               val num: Int,
                               val rate: Float,
                               val week_increase_proportion: String);