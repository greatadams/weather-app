package com.weatherApp.weather.App.service;
import com.weatherApp.weather.App.Response.WeatherApiResponse;
import com.weatherApp.weather.App.model.WeatherApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class WeatherService {

    public WeatherApplication getWeather(String city) {
        WeatherApplication weatherApplication = new WeatherApplication();
        RestTemplate restTemplate = new RestTemplate();
        WeatherApiResponse apiResponse = restTemplate.getForObject(
                "https://api.openweathermap.org/data/2.5/weather?q="
                + city + "&appid=6c7cec62c73fe1cd900b9bb00d5de493&units=metric",WeatherApiResponse.class
        );

        weatherApplication.setCity(apiResponse.getName());
        weatherApplication.setTemperature(apiResponse.getMain().getTemp());
        weatherApplication.setHumidity(apiResponse.getMain().getHumidity());
        weatherApplication.setDescription(apiResponse.getWeather().get(0).getDescription());

        return weatherApplication;

    }
}
