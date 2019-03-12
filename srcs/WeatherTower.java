package pack;

import java.util.Random;

import srcs.*;

/**
 * WeatherTower
 */
public class WeatherTower extends Tower{

    private int _sunLimit = 60;

    private int _longitudeLimit = 180;

    private int _latitudeLimit = 10;

    public String getWeather(Coordinates coordinates){
        if (coordinates.getHeight() >= this._sunLimit)
            return "SUN";
        if (coordinates.getLongitude() <= this._longitudeLimit)
        {
            if (coordinates.getLatitude() <= this._latitudeLimit)
                return "SNOW";
            else 
                return "RAIN";
        }
        else
        {
            if (coordinates.getLatitude() > this._latitudeLimit)
                return "SUN";
            else 
                return "FOG";
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