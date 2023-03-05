package com.charlieThao.weather_forcast_demo.repository.weather;

import com.charlieThao.weather_forcast_demo.model.WeatherForecast;

import java.util.HashMap;
import java.util.List;

public class WFMemoryDatabase implements WFDatabase {

    public HashMap<String, WeatherForecast> weatherForecastList = new HashMap<>() {
        {
            //temperature, String condition, boolean isPrecipitating, double humidity)
            put("New York", new WeatherForecast(26.0, "sunny", false, 0.8));
            put("Melbourn", new WeatherForecast(29.0, "rainy", true, 0.7));
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
    public List<WeatherForecast> getListOfWF(String city, int amountOfDays) {
//        List<WeatherForecast> wfList = new ArrayList<>();
//        List<WeatherForecast> tmpList = (List<WeatherForecast>) weatherForecastList.values();
//
//        for (int i = 0; i < amountOfDays && i < tmpList.size(); i++) {
//            wfList.add(tmpList.get(i));
//        }
//
//        return wfList;

//        return weatherForecastList.values().stream().filter(
//                ele -> ele.getCity().equals(city)
//        ).limit(amountOfDays).toList();

        return weatherForecastList.values().stream().limit(amountOfDays).toList();
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