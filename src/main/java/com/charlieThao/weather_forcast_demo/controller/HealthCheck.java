package com.charlieThao.weather_forcast_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @RequestMapping(value = "/health-check", method = RequestMethod.GET)
    public String checkSttOfAPI() {
        return "OK";
    }
}
