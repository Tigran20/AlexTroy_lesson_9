package ru.tinkoff.ru.seminar.model;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
  private static WeatherApi weatherApi;
  private Retrofit retrofit;

  @Override
  public void onCreate() {
    super.onCreate();

    retrofit =
        new Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    weatherApi = retrofit.create(WeatherApi.class);
  }

  public static WeatherApi getApi() {
    return weatherApi;
  }
}
