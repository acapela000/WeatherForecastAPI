package com.charlieThao.weather_forcast_demo.repository;

import com.charlieThao.weather_forcast_demo.model.WeatherForecast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "wfList", path = "wf")
@CrossOrigin("*")
public interface WFRepository extends CrudRepository<WeatherForecast, String>, PagingAndSortingRepository<WeatherForecast, String> {

    @RestResource(path = "/precipitating")
    List<WeatherForecast> findByPrecipitating(boolean isPrecipitating);

    @RestResource(path = "/condition")
    List<WeatherForecast> findByCondition(String condition);

    @RestResource(path = "/temperature")
    List<WeatherForecast> findByTemperature(String temperature);
}
