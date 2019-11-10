package com.example.jsonparser.service;

import com.example.jsonparser.model.WeatherMap;

public interface RestService {
    WeatherMap getWeatherData(String url);
}
