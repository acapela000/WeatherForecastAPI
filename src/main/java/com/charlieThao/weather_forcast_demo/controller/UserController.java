package com.charlieThao.weather_forcast_demo.controller;

import com.charlieThao.weather_forcast_demo.model.ResponseMsg;
import com.charlieThao.weather_forcast_demo.model.User;
import com.charlieThao.weather_forcast_demo.repository.user.UserDatabaseInterface;
import com.charlieThao.weather_forcast_demo.repository.user.UserMemoryDatabase;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

private UserDatabaseInterface userdb = new UserMemoryDatabase();

@RequestMapping(
        value = "/create",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<ResponseMsg> createUserAcc(@RequestBody User user) {
    String unique = UUID.randomUUID().toString();
    //user.setId(unique);
    boolean created = userdb.creatUser(unique, user);
    if (created) {
        return ResponseEntity.ok(new ResponseMsg("User account is created successfully!"));
    }
    return ResponseEntity.notFound().build();
}

@RequestMapping(
        value = "/delete/{idAccount}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<ResponseMsg> deleteUserAcc(@PathVariable("idAccount") String idAccount) {
    boolean deleted = userdb.deleteUser(idAccount);
    if (deleted) {
        return ResponseEntity.ok(new ResponseMsg("Deleted successfully!"));
    }
    return ResponseEntity.notFound().build();
}

@RequestMapping(
        value = "/update/{idAccount}",
        method = RequestMethod.PUT,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<User> updateUserAcc(@PathVariable String idAccount, @RequestBody User user) {
    User us = userdb.updateUser(idAccount, user);
    if (us != null) {
        return ResponseEntity.ok(us);
    }
    return ResponseEntity.badRequest().build();
}

@RequestMapping(
        value = "/{idAccount}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<User> getUserAcc(@PathVariable("idAccount") String idAccount) {
    User us = userdb.getUser(idAccount);
    if (us != null) {
        return ResponseEntity.ok(us);
    }
    return ResponseEntity.notFound().build();
}

@RequestMapping(
        value = "/",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<User>> getAllUserAcc() {
    return ResponseEntity.ok(userdb.getAllUser());
}



}
