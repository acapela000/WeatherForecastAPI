package com.charlieThao.weather_forcast_demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "tc_wf")
@AllArgsConstructor
@JsonSerialize
@JsonDeserialize
public class WeatherForecast {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @JsonProperty
    private String icon;
    @JsonProperty
    private double temperature;
    @JsonProperty
    private String condition;
    @JsonProperty
    private boolean isPrecipitating;
    @JsonProperty
    private double humidity;
    @JsonProperty
    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp lastUpdated;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public WeatherForecast(double temperature, String condition, boolean isPrecipitating, double humidity) {
        this(UUID.randomUUID().toString(), "", temperature, condition, isPrecipitating, humidity, new Timestamp(new Date().getTime()));
    }

    public WeatherForecast() {
        this(" ", " ", 0.0, " ", false,0.0);
    }

    public WeatherForecast(String id, String icon, double temperature, String condition, boolean isPrecipitating, double humidity) {
        this(id, icon, temperature, condition, isPrecipitating, humidity, new Timestamp(new Date().getTime()));
    }

    public WeatherForecast(String id, String icon, double temperature, String condition, boolean isPrecipitating, double humidity, Timestamp lastUpdated) {
        this.id = id;
        this.icon = icon;
        this.temperature = temperature;
        this.condition = condition;
        this.isPrecipitating = isPrecipitating;
        this.humidity = humidity;
        this.lastUpdated = lastUpdated;
    }
}
