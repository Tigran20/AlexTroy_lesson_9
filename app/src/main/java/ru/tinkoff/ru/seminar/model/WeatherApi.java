package ru.tinkoff.ru.seminar.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
  @GET("/data/2.5/weather")
  Call<Weather> getWeather(
      @Query("q") String city, @Query("units") String unitsFormat, @Query("APPID") String key);
}
