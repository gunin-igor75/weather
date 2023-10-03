package com.github.guninigor75.weather.service;


import com.github.guninigor75.weather.repository.WeatherRepository;
import com.github.guninigor75.weather.repository.model.WeatherModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;
    public Optional<WeatherModel> getWeather(
            final Double longitude,
            final Double latitude,
            final LocalDateTime date) {
        Assert.notNull(longitude, "Longitude must be a set");
        Assert.notNull(latitude, "Latitude must be a set");
        return weatherRepository.getWeather(longitude,
                latitude,
                date == null? LocalDateTime.now(): date);
    }
}
