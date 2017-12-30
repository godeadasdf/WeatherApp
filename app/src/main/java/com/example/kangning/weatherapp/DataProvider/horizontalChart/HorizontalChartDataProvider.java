package com.example.kangning.weatherapp.DataProvider.horizontalChart;

import com.example.kangning.weatherapp.DataProvider.horizontalChart.model.HorizontalChartInfo;
import com.google.gson.Gson;

/**
 * Created by kangning on 2017/12/30.
 */

public class HorizontalChartDataProvider {
    final private static String jsonString = "{\n" +
            "    \"total\": 288,\n" +
            "    \"list\": [\n" +
            "        {\n" +
            "            \"num\": 282,\n" +
            "            \"rate\": \"17.7\",\n" +
            "            \"zone_id\": \"1100101709280107\",\n" +
            "            \"zone_name\": \"海淀万寿路莲花池二区\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"num\": 243,\n" +
            "            \"rate\": \"31.3\",\n" +
            "            \"zone_id\": \"1100101710100321\",\n" +
            "            \"zone_name\": \"朝阳金台夕照三区\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"num\": 242,\n" +
            "            \"rate\": \"47.5\",\n" +
            "            \"zone_id\": \"1100101710130332\",\n" +
            "            \"zone_name\": \"西城金融街天安门四区\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"num\": 234,\n" +
            "            \"rate\": \"12.0\",\n" +
            "            \"zone_id\": \"1100101709280135\",\n" +
            "            \"zone_name\": \"丰台方庄宋家庄二区\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public static HorizontalChartInfo getData() {
        return new Gson().fromJson(jsonString, HorizontalChartInfo.class);
    }
}
