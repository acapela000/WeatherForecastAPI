package com.charlieThao.weather_forcast_demo.repository;

import com.charlieThao.weather_forcast_demo.model.Role;
import com.charlieThao.weather_forcast_demo.model.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "roleList", path = "role")
@CrossOrigin("*")
public interface RoleRepository extends CrudRepository<Role, String>, PagingAndSortingRepository<Role, String> {
    @RestResource(path = "/name")
    List<Role> findByName(Roles name);
}
