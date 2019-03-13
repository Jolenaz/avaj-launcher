package pack;

import java.util.Random;


import srcs.*;

/**
 * WeatherTower
 */
public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    };

    


    
}