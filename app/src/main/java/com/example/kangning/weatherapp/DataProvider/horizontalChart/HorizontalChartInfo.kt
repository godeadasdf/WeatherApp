package com.example.kangning.weatherapp.DataProvider.horizontalChart

/**
 * Created by kangning on 2017/12/30.
 */
/*{
    "total": 288,
    "list": [
    {
        "num": 282,
        "rate": "17.7",
        "zone_id": "1100101709280107",
        "zone_name": "海淀万寿路莲花池二区"
    }]
}*/

data class HorizontalChartInfo(val total: Int,
                               val list: List<HorizontalChartItem>)