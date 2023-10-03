package com.github.guninigor75.weather.controller.model;

import java.time.LocalDateTime;

public record WeatherResponse(LocalDateTime date, String temperature) {

    public static WeatherResponse empty() {
        return new WeatherResponse(LocalDateTime.now(), "data missing");
    }
}
