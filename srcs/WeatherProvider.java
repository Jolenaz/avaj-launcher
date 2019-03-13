package pack;

import java.util.concurrent.ThreadLocalRandom;

/**
 * WeatherProvider
 */
public class WeatherProvider {

    static private WeatherProvider _weatherProvider = new WeatherProvider();

    private int _sunLimit = 60;

    private WeatherProvider(){};

    public static WeatherProvider getProvider(){
        return _weatherProvider;
    }

    private String[] _weather = new String[] {"SUN","RAIN","SNOW","FOG"};

    public String getCurrentWeather(Coordinates coordinates){
        if (coordinates.getHeight() >= this._sunLimit)
            return _weather[0];
        return(_weather[(coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight())% 4]);
    };
    
}