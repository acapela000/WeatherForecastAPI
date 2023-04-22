package com.charlieThao.weather_forcast_demo.repository;

import com.charlieThao.weather_forcast_demo.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "locationList", path = "location")
@CrossOrigin("*")
public interface LocationRepository extends CrudRepository<Location, String>, PagingAndSortingRepository<Location, String> {
    @RestResource(path = "/country-city")
    List<Location> findByCountryAndCity(String country, String city);

    @RestResource(path = "/country")
    List<Location> findByCountry(String country);

    @RestResource(path = "/city")
    List<Location> findByCity(String city);

    @RestResource(path = "/name")
    List<Location> findByName(String name);

    @RestResource(path = "/state")
    List<Location> findByState(String state);

}
