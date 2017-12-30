package com.example.kangning.weatherapp.DataProvider.chart;

import com.google.gson.Gson;

/**
 * Created by kangning on 2017/12/29.
 */

public class ChartDataProvider {
    private final static String jsonString = "{list: [{" +
            "date: \"2017-11-30\",\n" +
            "increase_proportion: \"2.2\"," +
            "num: 17566," +
            "rate: 60.7," +
            "week_increase_proportion: \"41.6\"" +
            "}, {" +
            "date: \"2017-12-01\"," +
            "increase_proportion: \"15.3\"," +
            "num: 20251," +
            "rate: 58.9," +
            "week_increase_proportion: \"53.9\"" +
            "}]," +
            "peek: 25266," +
            "today_detail: {" +
            "date: \"2017-12-29\"," +
            "increase_proportion: \"100.0\"," +
            "num: 19663," +
            "rate: \"28.7\"," +
            "week_increase_proportion: \"100.0\"" +
            "}}";

    public static ChartInfoLineColumn getData() {
        return new Gson().fromJson(jsonString, ChartInfoLineColumn.class);
    }
}
