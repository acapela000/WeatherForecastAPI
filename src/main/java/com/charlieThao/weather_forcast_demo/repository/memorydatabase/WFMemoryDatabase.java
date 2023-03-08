package com.charlieThao.weather_forcast_demo.repository.memorydatabase;

import com.charlieThao.weather_forcast_demo.model.WeatherForecast;
import com.charlieThao.weather_forcast_demo.repository.DatabaseInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WFMemoryDatabase implements DatabaseInterface<WeatherForecast, String> {

    public HashMap<String, WeatherForecast> weatherForecastList = new HashMap<>() {
        {
            //temperature, String condition, boolean isPrecipitating, double humidity)
            put("New York", new WeatherForecast(26.0, "sunny", false, 0.8));
            put("Melbourn", new WeatherForecast(29.0, "rainy", true, 0.7));
            put("Alaska", new WeatherForecast(12.0, "rainy", true, 0.8));
            put("Tanzania", new WeatherForecast(32.0, "sunny", false, 0.7));
            put("Philipines", new WeatherForecast(30.0, "rainy", true, 0.8));
        }
    };

    @Override
    public boolean creat(String id, WeatherForecast item) {
        if (!weatherForecastList.containsKey(id)) {
            weatherForecastList.put(id, item);
            return true;
        }
        return false;
    }

    @Override
    public WeatherForecast getById(String id) {
        return weatherForecastList.get(id);
    }

    @Override
    public List<WeatherForecast> getList(int limit) {
        return weatherForecastList.values().stream().limit(limit).toList();
    }

    @Override
    public WeatherForecast updateById(String id, WeatherForecast item) {
        if (weatherForecastList.containsKey(id)) {
            weatherForecastList.put(id, item);
            return item;
        }
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        if (weatherForecastList.containsKey(id)) {
            weatherForecastList.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public List<WeatherForecast> search(String s, int limit) {
        List<WeatherForecast> wfList = new ArrayList<>();

        weatherForecastList.forEach((k,v) -> {
            if (k.contains(s)) {
                wfList.add(v);
            }
        });
        return wfList;
    }


}
