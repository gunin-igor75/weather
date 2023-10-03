package com.github.guninigor75.weather.controller;

import com.github.guninigor75.weather.controller.model.WeatherRequest;
import com.github.guninigor75.weather.controller.model.WeatherResponse;
import com.github.guninigor75.weather.facade.WeatherFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherFacade weatherFacade;

    @PostMapping
    public WeatherResponse getWeather(@RequestBody final WeatherRequest request) {
        return  weatherFacade.getWeather(request);
    }
}
