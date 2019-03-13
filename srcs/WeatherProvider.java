package pack;

import java.util.concurrent.ThreadLocalRandom;

/**
 * WeatherProvider
 */
public class WeatherProvider {

    static private WeatherProvider _weatherProvider = new WeatherProvider();

    private WeatherProvider(){};

    public static WeatherProvider getProvider(){
        return _weatherProvider;
    }

    private String[] _weather = new String[] {"SUN","RAIN","SNOW","FOG"};

    public String getCurrentWeather(Coordinates coordinates){
        return(_weather[(coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight())% 4]);
    };
    
}