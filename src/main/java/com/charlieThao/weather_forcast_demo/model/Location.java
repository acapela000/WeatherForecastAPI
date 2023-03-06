package com.charlieThao.weather_forcast_demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tc_location")
public class Location {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;//default to empty string

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @ManyToMany(mappedBy = "locationList")
    List<User> userList = new ArrayList<>();//default to empty list

    @OneToMany(mappedBy = "location")
    List<WeatherForecast> weatherForecastList = new ArrayList<>();//default to empty list


}
