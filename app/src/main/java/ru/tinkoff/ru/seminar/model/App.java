package ru.tinkoff.ru.seminar.model;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.tinkoff.ru.seminar.JsonWeatherDeserializer;

public class App extends Application {
    private static WeatherApi weatherApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        GsonBuilder gsonBuilder = new GsonBuilder();
        JsonDeserializer<Weather> deserializer = new JsonWeatherDeserializer();
        gsonBuilder.registerTypeAdapter(Weather.class, deserializer);
        Gson gson = gsonBuilder.create();

        retrofit =
                new Retrofit.Builder()
                        .baseUrl("http://api.openweathermap.org")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
        weatherApi = retrofit.create(WeatherApi.class);
    }

    public static WeatherApi getApi() {
        return weatherApi;
    }
}
