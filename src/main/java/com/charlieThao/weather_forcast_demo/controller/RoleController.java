package com.charlieThao.weather_forcast_demo.controller;

import com.charlieThao.weather_forcast_demo.model.ResponseMsg;
import com.charlieThao.weather_forcast_demo.model.Role;
import com.charlieThao.weather_forcast_demo.repository.DatabaseInterface;
import com.charlieThao.weather_forcast_demo.repository.postgredatabase.RoleDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private DatabaseInterface<Role, String> db;

    @Autowired
    public RoleController(EntityManagerFactory entityManagerFactory) {
        this.db = new RoleDatabase(entityManagerFactory);
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMsg> create(@RequestBody Role item) {
        boolean created = db.creat(item);
        if (created) {
            return ResponseEntity.ok(new ResponseMsg("Created successfully!"));
        }
        return ResponseEntity.badRequest().build();

    }

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Role>> getAll(@RequestParam("limit") int limit) {
        return ResponseEntity.ok(db.getList(limit));
    }

    @RequestMapping(
            value = "/search/{query}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Role>> search(@PathVariable("query") String name,
                                             @RequestParam("limit") int limit) {
        return ResponseEntity.ok(db.search(name, limit));
    }

}
