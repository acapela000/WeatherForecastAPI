package com.charlieThao.weather_forcast_demo.controller;

import com.charlieThao.weather_forcast_demo.model.WeatherForecast;
import com.charlieThao.weather_forcast_demo.repository.Database;
import com.charlieThao.weather_forcast_demo.repository.MemoryDatabase;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/forecast")
public class GetForecast {

    Database db = new MemoryDatabase();
    @RequestMapping (
            value = "/today/{city}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<WeatherForecast> getToday(@PathVariable("city") String city) {
        WeatherForecast weatherForecast = db.getWF(city);
        if (weatherForecast == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(weatherForecast);
    }

    @RequestMapping (
            value = "/week/{city}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WeatherForecast>> getWeek(@PathVariable("city") String city) {
        return null;
    }

}
