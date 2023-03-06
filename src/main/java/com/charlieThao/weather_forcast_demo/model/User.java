package com.charlieThao.weather_forcast_demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tc_user")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false, unique = true)
    private String userName;//"unique"

    @Column(nullable = false, unique = true)
    private String email;//"unique"

    @Column(nullable = false)
    private String password;//"hashed"

    @ManyToMany//"default to empty list"
//    @Column(nullable = false)
    @JoinTable(
            name = "tc_user_location",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private List<Location> locationList = new ArrayList<>();

    @ManyToMany()//"default to Role with name 'guest'"
    @Column(nullable = false)
    @JoinTable(
            name = "tc_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roleList = new ArrayList<>();


    public User(String s, String nanami, String s1, String s2) {
    }
}
