package com.charlieThao.weather_forcast_demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@JsonSerialize
public class WeatherForecast {

    @JsonProperty
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
    private Timestamp lastUpdated;

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
