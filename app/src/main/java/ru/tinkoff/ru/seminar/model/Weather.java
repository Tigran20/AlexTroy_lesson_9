package ru.tinkoff.ru.seminar.model;


import android.support.annotation.NonNull;

@SuppressWarnings("unused")
public class Weather {
    public String name;
    public String description;
    public String city;
    public float temp;
    public float speedWind;

    public Weather(@NonNull String name, @NonNull String description, @NonNull String city, float temp, float speedWind) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.temp = temp;
        this.speedWind = speedWind;
    }

    public Weather() {
    }

    @Override
    public String toString() {
        return "Weather{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", temp=" + temp +
                ", speedWind=" + speedWind +
                '}';
    }
}
