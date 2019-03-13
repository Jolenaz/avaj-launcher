package pack;

import java.util.concurrent.ThreadLocalRandom;

/**
 * WeatherProvider
 */
public class WeatherProvider {

    static private WeatherProvider _weatherProvider = new WeatherProvider();

    private int _sunLimit = 60;
    private int _longitudeLimit = 180;
    private int _latitudeLimit = 10;

    private WeatherProvider(){};

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

    public void changWeather(){
        this._sunLimit += ThreadLocalRandom.current().nextInt(-2, 2 + 1);
        if (this._sunLimit < 0)
            this._sunLimit = 0;
        else if (this._sunLimit > 100)
            this._sunLimit = 100;

        this._longitudeLimit += ThreadLocalRandom.current().nextInt(-20, 20 + 1);
        if (this._longitudeLimit < 0)
            this._longitudeLimit += 360;
        else
            this._longitudeLimit %= 360; 

        this._latitudeLimit += ThreadLocalRandom.current().nextInt(-0, 10 + 1);
        if (this._latitudeLimit > 90)
            this._latitudeLimit = 90;
        else if (this._latitudeLimit < -90)
            this._latitudeLimit = -90;

    };
}