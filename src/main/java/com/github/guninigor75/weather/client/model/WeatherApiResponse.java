package com.github.guninigor75.weather.client.model;

import java.time.LocalDateTime;

public record WeatherApiResponse(LocalDateTime date, String value) {
}
