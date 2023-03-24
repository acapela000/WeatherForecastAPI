package com.charlieThao.weather_forcast_demo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "tc_location")
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
@JsonDeserialize
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

    public Location(String name, String city, String country) {
        this(new UUIDGenerator().toString(), name, city, "", country, new ArrayList<>(), new ArrayList<>());
    }
}
