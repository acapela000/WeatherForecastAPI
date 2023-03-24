package com.charlieThao.weather_forcast_demo.repository;

import com.charlieThao.weather_forcast_demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "userList", path = "user")
@CrossOrigin("*")
public interface UserRepository extends CrudRepository<User, String>, PagingAndSortingRepository<User, String> {

}
