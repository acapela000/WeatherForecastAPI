package com.charlieThao.weather_forcast_demo.repository;

import com.charlieThao.weather_forcast_demo.model.WeatherForecast;

import java.util.HashMap;

public class MemoryDatabase implements Database {

    public HashMap<String, WeatherForecast> weatherForecastList = new HashMap<String, WeatherForecast>() {
        {
            put("New York", new WeatherForecast(26.0, 25.0, false, "cloudy", "New York"));
            put("Melbourn", new WeatherForecast(29.0, 20.0, true, "snowy", "Melbourn"));
        }
    };

    @Override
    public boolean createWF(String city, WeatherForecast wf) {
       if (!weatherForecastList.containsKey(city)) {
           weatherForecastList.put(city, wf);
           return true;
       }
        return false;
    }

    @Override
    public WeatherForecast updateWF(String city, WeatherForecast wf) {
        if (weatherForecastList.containsKey(city)) {
            weatherForecastList.put(city, wf);
            return wf;
        }
        return null;
    }

    @Override
    public WeatherForecast getWF(String city) {
        return weatherForecastList.get(city);
    }

    @Override
    public boolean deleteWF(String city) {
        if (weatherForecastList.containsKey(city)) {
            weatherForecastList.remove(city);
            return true;
        }
        return false;
    }
}
