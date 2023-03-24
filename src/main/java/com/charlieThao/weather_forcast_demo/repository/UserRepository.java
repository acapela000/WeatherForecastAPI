package com.charlieThao.weather_forcast_demo.repository;

import com.charlieThao.weather_forcast_demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "userList", path = "user")
@CrossOrigin("*")
public interface UserRepository extends CrudRepository<User, String>, PagingAndSortingRepository<User, String> {

    @RestResource(path = "/userName")
    List<User> findByUserName(String userName);

    @RestResource(path = "/email")
    List<User> findByEmail(String email);
}
