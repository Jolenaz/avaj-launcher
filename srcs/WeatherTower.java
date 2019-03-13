package pack;

import java.util.Random;

/**
 * WeatherTower
 */
public class WeatherTower extends Tower{

    private static WeatherProvider _wp = WeatherProvider.getProvider();

    public String getWeather(Coordinates coordinates){
        return _wp.getCurrentWeather(coordinates);
    };
    
    public void changeWeather(){
        conditionsChanged();
    }

}