package com.example.weatherapps;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {

    private String mTemperature,micon,mcity,mWeatherType;
    private int mCondition;

    public static weatherData fromJson(JSONObject jsonObject)
    {
        try {
            weatherData weatherD=new weatherData();
            weatherD.mcity=jsonObject.getString("name");
            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.micon=updateWeatherIcon(weatherD.mCondition);
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherD.mTemperature=Integer.toString(roundedValue);
            return weatherD;
        }
         catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static String updateWeatherIcon(int condition)
    {
        if (condition>=0&&condition<=300)
        {
            return "thunderstrom1";
        }
       else if (condition>=300&&condition<=500)
        {
            return "lightrain";
        }
       else if (condition>=500&&condition<=600)
        {
            return "shower";
        }
       else if (condition>=600&&condition<=700)
        {
            return "snow2";
        }
       else if (condition>=701&&condition<=771)
        {
            return "fog";
        }
       else if (condition>=772&&condition<=800)
        {
            return "overcast";
        }
       else if(condition>=800)
        {
            return "sunny";
        }
        return "dunno";
    }

    public String getmTemperature() {
        return mTemperature+"°C";
    }

    public String getMicon() {
        return micon;
    }

    public String getMcity() {
        return mcity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }


}
