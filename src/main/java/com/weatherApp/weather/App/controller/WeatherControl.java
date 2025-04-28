package com.weatherApp.weather.App.controller;

import com.weatherApp.weather.App.model.WeatherApplication;
import com.weatherApp.weather.App.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherControl {

    private  WeatherService weatherService;

    public WeatherControl(WeatherService weatherService) {
        this.weatherService=weatherService;

    }

    @GetMapping("/weather/city/{city}")
    public WeatherApplication getWeather(@PathVariable String city){
        return  weatherService.getWeather(city);
    }
}
