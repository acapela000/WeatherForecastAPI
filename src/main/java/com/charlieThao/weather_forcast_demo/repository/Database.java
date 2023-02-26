package com.charlieThao.weather_forcast_demo.repository;

import com.charlieThao.weather_forcast_demo.model.WeatherForecast;

import java.util.HashMap;

public interface Database {

    public boolean createWF(String city, WeatherForecast weatherForecast);

    public WeatherForecast updateWF(String city, WeatherForecast wf);

    public WeatherForecast getWF(String city);

    public boolean deleteWF(String city);

}
