package com.charlieThao.weather_forcast_demo.repository;

import com.charlieThao.weather_forcast_demo.model.WeatherForecast;

import java.util.List;

public interface DatabaseInterface <T, U> {

    public boolean creat(U id, T item);

    public T getById(U id);

    public List<T> getList(int limit);

    public T updateById(U id, T item);

    public boolean deleteById(U id);

    public List<T> search(U u, int limit);

}
