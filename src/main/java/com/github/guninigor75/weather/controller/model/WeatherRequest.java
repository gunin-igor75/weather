package com.github.guninigor75.weather.controller.model;

import java.time.LocalDateTime;

public record WeatherRequest(Double longitude, Double latitude, LocalDateTime date) {
}
