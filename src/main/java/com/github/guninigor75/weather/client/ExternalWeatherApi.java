package com.github.guninigor75.weather.client;

import com.github.guninigor75.weather.client.model.WeatherApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather")
public interface ExternalWeatherApi {

    @GetMapping
    WeatherApiResponse getWeather(
            @RequestParam(name = "lon") double longitude,
            @RequestParam(name = "lat") double latitude);
}
