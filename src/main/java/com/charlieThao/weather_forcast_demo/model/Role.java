package com.charlieThao.weather_forcast_demo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tc_role")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
@JsonDeserialize
public class Role {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private Roles name;

    private String description;

    @ManyToMany(mappedBy = "roleList")
    private List<User> userList = new ArrayList<>();

    public Role(String name) {
        this(null,Roles.valueOf(name), null, null);
    }
}
