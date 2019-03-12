package pack;

import java.util.Arrays;

/**
 * WeatherProvider
 */
public class WeatherProvider {

    static private WeatherProvider _weatherProvider = new WeatherProvider();

    private int _sunLimit = 60;
    private int _longitudeLimit = 180;
    private int _latitudeLimit = 10;

    private WeatherProvider(){
        
    };

    public static WeatherProvider getProvider(){
        return _weatherProvider;
    }

    private String[] _weather = new String[] {"SUN","RAIN","SNOW","FOG"};

    public String getCurrentWeather(Coordinates coordinates){
        if (coordinates.getHeight() >= this._sunLimit)
            return _weather[0];
        if (coordinates.getLongitude() <= this._longitudeLimit)
        {
            if (coordinates.getLatitude() <= this._latitudeLimit)
                return _weather[2];
            else 
                return _weather[1];
        }
        else
        {
            if (coordinates.getLatitude() > this._latitudeLimit)
                return _weather[0];
            else 
                return _weather[3];
        }
    };
}