package com.charlieThao.weather_forcast_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @RequestMapping("/health-check")
    public String checkSttOfAPI() {
        return "OK";
    }
}
