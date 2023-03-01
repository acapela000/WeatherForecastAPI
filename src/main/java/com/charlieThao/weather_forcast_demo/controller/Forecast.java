package com.charlieThao.weather_forcast_demo.controller;

import com.charlieThao.weather_forcast_demo.model.ResponseMsg;
import com.charlieThao.weather_forcast_demo.model.WeatherForecast;
import com.charlieThao.weather_forcast_demo.repository.weather.WFDatabase;
import com.charlieThao.weather_forcast_demo.repository.weather.WFMemoryDatabase;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forecast")
public class Forecast {
private WFDatabase db = new WFMemoryDatabase();

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
            value = "/week",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WeatherForecast>> getWeek() {
        List<WeatherForecast> wfList = db.getListOfWF("", 7);
        if (wfList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(wfList);
    }

    @RequestMapping(
            value = "/{city}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMsg> deleteWFToday(@PathVariable("city") String city) {
        boolean isDeleted = db.deleteWF(city);
        if (isDeleted) {
            return ResponseEntity.ok(new ResponseMsg("Delete successfully!"));
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(
            value = "/{city}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResponseMsg> createWFToday(@PathVariable("city") String city,
                                                     @RequestBody WeatherForecast wf) {
        boolean created = db.createWF(city, wf);
        if (created) {
            return ResponseEntity.ok(new ResponseMsg("Created successfully!"));
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(
            value = "/{city}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<WeatherForecast> updateWFToday(@PathVariable("city") String city,
                                                         @RequestBody WeatherForecast wf) {
        WeatherForecast weatherForecast = db.updateWF(city, wf);
        if (weatherForecast != null) {
            return ResponseEntity.ok(weatherForecast);
        }
        return ResponseEntity.notFound().build();
    }

}
