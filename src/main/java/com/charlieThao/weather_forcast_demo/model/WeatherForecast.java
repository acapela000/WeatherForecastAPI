package com.charlieThao.weather_forcast_demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.Timestamp;
import java.util.Date;

@JsonSerialize
public class WeatherForecast {

    @JsonProperty
    private double temperature;
    @JsonProperty
    private double humidity;
    @JsonProperty
    private boolean precipitation;
    @JsonProperty
    private String condition;
    @JsonProperty
    private String city;
    @JsonProperty
    private Timestamp date;

    public WeatherForecast() {
    }

    public WeatherForecast(double temperature, double humidity, boolean precipitation, String condition, String city) {
        this(temperature, humidity, precipitation, condition, city, new Timestamp(new Date().getTime()));
    }

    public WeatherForecast(double temperature, double humidity, boolean precipitation, String condition, String city, Timestamp date) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.condition = condition;
        this.city = city;
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public boolean isPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(boolean precipitation) {
        this.precipitation = precipitation;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
