package ru.tinkoff.ru.seminar;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import ru.tinkoff.ru.seminar.model.Weather;

public class JsonWeatherDeserializer implements JsonDeserializer<Weather> {
    @Override
    public Weather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Weather weather = new Weather();
        weather.city = json.getAsJsonObject().get("name").getAsString();
        weather.name = json.getAsJsonObject().get("cod").getAsString();
        weather.description = (((json.getAsJsonObject().get("weather")).getAsJsonArray().get(0)).getAsJsonObject()).get("description").getAsString();
        weather.temp = (json.getAsJsonObject().get("main").getAsJsonObject()).get("temp").getAsFloat();
        weather.speedWind = (json.getAsJsonObject().get("wind").getAsJsonObject()).get("speed").getAsFloat();
        return weather;
    }
}
