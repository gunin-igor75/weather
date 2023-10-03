package com.github.guninigor75.weather.repository.model;

import java.time.LocalDateTime;

public record WeatherModel(LocalDateTime date, Double temperature, TemperatureType type) {
}
