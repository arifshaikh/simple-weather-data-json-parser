package com.example.jsonparser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherListRain {
    @JsonProperty("3h")
    private float threeH;

    public float getThreeH() {
        return threeH;
    }

    public void setThreeH(float threeH) {
        this.threeH = threeH;
    }

    @Override
    public String toString() {
        return "WeatherListRain{" +
                "threeH=" + threeH +
                '}';
    }
}
