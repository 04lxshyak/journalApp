package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.weatherResponse;
import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.constants.PlaceHolders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class weatherService {
    @Value("${weather.api.key}")
    private   String apiKey;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;
    @Autowired
    private RedisService redisService;

    public weatherResponse getWeather(String city){

        weatherResponse weatherResponse= redisService.get("weather_of_" + city,weatherResponse.class);
        if(weatherResponse != null){
            return weatherResponse;
        }else {
            String finalAPI = appCache.App_Cache.get(AppCache.keys.WEATHER_API.toString()).replace(PlaceHolders.CITY, city).replace(PlaceHolders.API_KEY, apiKey);
            ResponseEntity<weatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, weatherResponse.class);
            weatherResponse body = response.getBody();
            if(body != null){
                redisService.set("weather_of_" + city,body,300l);

            }
            return body;
        }
    }
}
