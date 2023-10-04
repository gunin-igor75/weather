package com.github.guninigor75.weather.client;

import com.github.guninigor75.weather.client.model.WeatherApiResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather")
public interface ExternalWeatherApi {

    @GetMapping
    @CircuitBreaker(name = "weather-breaker")
    @Retry(name = "weather-retry")
    WeatherApiResponse getWeather(
            @RequestParam(name = "lon") double longitude,
            @RequestParam(name = "lat") double latitude);
}
