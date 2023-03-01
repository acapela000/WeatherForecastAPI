package com.charlieThao.weather_forcast_demo.repository.user;

import com.charlieThao.weather_forcast_demo.model.User;

import java.util.List;

public interface UserDatabaseInterface {

public boolean creatUser(String idNumber, User user);

public User updateUser(String idNumber, User user);

public User getUser(String idNumber);

public List<User> getAllUser();

public boolean deleteUser(String idNumber);
}
