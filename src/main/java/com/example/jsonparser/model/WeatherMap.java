package com.example.jsonparser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherMap {

    private String cod;
    private double calctime;
    private int cnt;
    private List<WeatherList> list;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getCalctime() {
        return calctime;
    }

    public void setCalctime(double calctime) {
        this.calctime = calctime;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<WeatherList> getList() {
        return list;
    }

    public void setList(List<WeatherList> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "WeatherMap{" +
                "cod='" + cod + '\'' +
                ", calctime=" + calctime +
                ", cnt=" + cnt +
                ", list=" + list +
                '}';
    }
}
