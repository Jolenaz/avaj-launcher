package pack;

/**
 * Coordinates
 */
public class Coordinates {

    private int _longitude;
    private int _latitude;
    private int _height;
    
    public Coordinates(int longitude, int latitude, int height){

        if (longitude < 0)
            this._longitude = 0;
        else 
            this._longitude = longitude % 360;

        if (latitude > 90)
            this._latitude = 90;
        else if (latitude < -90)
            this._latitude = -90;
        else 
            this._latitude = latitude;

        if (height > 100)
            this._height = 100;
        else if (height < 0)
            this._height = 0;
        else 
            this._height = height;
            
    }

    public int getLongitude(){
        return this._longitude;
    }

    public int getLatitude(){
        return this._latitude;
    }

    public int getHeight(){
        return this._height;
    } 

    public String toString(){
        return ("long: " + this._longitude + ", lat: " + this._latitude + ", height: " + this._latitude);
    }

}