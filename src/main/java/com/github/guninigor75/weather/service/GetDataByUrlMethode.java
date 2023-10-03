package com.github.guninigor75.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.guninigor75.weather.controller.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class GetDataByUrlMethode {

    @Autowired
    private static RestTemplate restTemplate;

    public static WeatherResponse getDataObjectMapper() throws IOException {
        final URL url = UriComponentsBuilder.fromHttpUrl("http://localhost:9090/api/weather")
                .queryParam("longitude", 10)
                .queryParam("latitude", 20)
                .build().toUri().toURL();
        return new ObjectMapper().readValue(url, WeatherResponse.class);
    }

    public static WeatherResponse getDataRestTemplate() {
        return restTemplate.getForObject(
                UriComponentsBuilder.fromHttpUrl("http://localhost:9090/api/weather")
                        .queryParam("longitude", 10)
                        .queryParam("latitude", 20).toUriString(),
                WeatherResponse.class
        );
    }

    public static WeatherResponse getDataUrlConnection() {
        final URLConnection urlConnection;
        try {
            urlConnection = new URL(UriComponentsBuilder.fromHttpUrl("http://localhost:9090/api/weather")
                    .queryParam("longitude", 10)
                    .queryParam("latitude", 20).toUriString()).openConnection();
            try (InputStream stream = urlConnection.getInputStream()) {
                return new ObjectMapper().readValue(stream.readAllBytes(), WeatherResponse.class);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
