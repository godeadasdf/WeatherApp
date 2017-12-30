package com.example.kangning.weatherapp.DataProvider.chart.model

/**
 * Created by kangning on 2017/12/29.
 */
/*list": [ {
    "date": "2017-12-28",
    "increase_proportion": "-1.7",
    "num": 22569,
    "rate": "59.1",
    "week_increase_proportion": "15.8"
}, {
    "date": "2017-12-29",
    "increase_proportion": "100.0",
    "num": 19663,
    "rate": "28.7",
    "week_increase_proportion": "100.0"
}],
"peek": 25266,
"today_detail": {
    "date": "2017-12-29",
    "increase_proportion": "100.0",
    "num": 19663,
    "rate": "28.7",
    "week_increase_proportion": "100.0"
}*/
data class ChartInfoLineColumn(val list: List<ChartItemLineColumn>,
                               val peek: Int,
                               val today_detail: ChartItemLineColumn)