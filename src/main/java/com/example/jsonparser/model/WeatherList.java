package com.example.jsonparser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherList {

    private long id;
    private String name;
    private WeatherListCoord coord;
    private WeatherListMain main;
    private long dt;
    private WeatherListWind wind;
    private WeatherListRain rain;
    private WeatherListClouds clouds;
    private List<WeatherListWeather> weather;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeatherListCoord getCoord() {
        return coord;
    }

    public void setCoord(WeatherListCoord coord) {
        this.coord = coord;
    }

    public WeatherListMain getMain() {
        return main;
    }

    public void setMain(WeatherListMain main) {
        this.main = main;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public WeatherListWind getWind() {
        return wind;
    }

    public void setWind(WeatherListWind wind) {
        this.wind = wind;
    }

    public WeatherListRain getRain() {
        return rain;
    }

    public void setRain(WeatherListRain rain) {
        this.rain = rain;
    }

    public WeatherListClouds getClouds() {
        return clouds;
    }

    public void setClouds(WeatherListClouds clouds) {
        this.clouds = clouds;
    }

    public List<WeatherListWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherListWeather> weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                ", main=" + main +
                ", dt=" + dt +
                ", wind=" + wind +
                ", rain=" + rain +
                ", clouds=" + clouds +
                ", weather=" + weather +
                '}';
    }
}
