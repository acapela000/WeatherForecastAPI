package com.charlieThao.weather_forcast_demo.repository.weather;

import com.charlieThao.weather_forcast_demo.model.WeatherForecast;

import java.util.List;

public interface WFDatabase {


    public boolean createWF(String city, WeatherForecast weatherForecast);

    public WeatherForecast updateWF(String city, WeatherForecast wf);

    public WeatherForecast getWF(String city);

    public List<WeatherForecast> getListOfWF(String city, int amountOfDays);

    public boolean deleteWF(String city);

}
