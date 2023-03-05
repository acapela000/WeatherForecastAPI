package com.charlieThao.weather_forcast_demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@JsonSerialize
public class User {
    @Setter
    private String id;
    @JsonProperty
    private String userName;//"unique"
    @JsonProperty
    private String email;//"unique"
    @JsonProperty
    private String password;//"hashed"
    @JsonProperty
    private List<Location> locationList;//"default to empty list"
    @JsonProperty
    private List<Role> roleList;//"default to Role with name 'guest'"
    //private final List<WeatherForecast> weatherForecastList = new ArrayList<>();

    public User() {
    }

    public User(String userName, String email, String password,
                List<Location> locationList, List<Role> roleList) {
        this(null, userName, email,password, locationList, roleList);
    }

    public User(String id, String userName, String email, String password,
                List<Location> locationList, List<Role> roleList) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.locationList = locationList;
        this.roleList = roleList;
    }



}
