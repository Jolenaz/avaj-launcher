package pack;

/**
 * Coordinates
 */
public class Coordinates {

    private int _longitude;
    private int _latitude;
    private int _height;
    
    public Coordinates(int longitude, int latitude, int height){

        this._longitude = longitude;
        this._latitude = latitude;
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
        return ("long: " + this._longitude + ", lat: " + this._latitude + ", height: " + this._height);
    }

    public void moveTo(Coordinates next){
        this._longitude += next.getLongitude();
        this._latitude += next.getLatitude();
        this._height += next.getHeight();
        if (this._height < 0)
            this._height = 0;
        if (this._height > 100)
            this._height = 100;
    }

}