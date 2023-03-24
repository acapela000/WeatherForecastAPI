package com.charlieThao.weather_forcast_demo.repository;

import com.charlieThao.weather_forcast_demo.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "locationList", path = "location")
@CrossOrigin("*")
public interface LocationRepository extends CrudRepository<Location, String>, PagingAndSortingRepository<Location, String> {

}
