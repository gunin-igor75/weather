package com.github.guninigor75.weather.repository;

import com.github.guninigor75.weather.repository.model.TemperatureType;
import com.github.guninigor75.weather.repository.model.WeatherModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Random;

@Component
public class WeatherRepository {

    private final Random random = new Random();

    public Optional<WeatherModel> getWeather(
            final Double longitude,
            final Double latitude,
            final LocalDateTime date) {
        return Optional.of(new WeatherModel(date.truncatedTo(ChronoUnit.HOURS),
                random.nextDouble(40d), TemperatureType.C));
    }
}
