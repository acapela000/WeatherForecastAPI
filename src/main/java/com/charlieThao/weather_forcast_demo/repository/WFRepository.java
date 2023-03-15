package com.charlieThao.weather_forcast_demo.repository;

import com.charlieThao.weather_forcast_demo.model.WeatherForecast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "wfList", path = "wf")
public interface WFRepository extends CrudRepository<WeatherForecast, String>, PagingAndSortingRepository<WeatherForecast, String> {


}
