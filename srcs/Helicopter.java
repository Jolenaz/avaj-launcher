package pack;

/**
 * Helicopter
 */
public class Helicopter extends Aircraft{

    private WeatherTower _weatherTower;

    public Helicopter(String name, Coordinates coord){
        super(name, coord);
    }
    
    public void registerTower(WeatherTower weatherTower){
        this._weatherTower = weatherTower;
        super.registerTower(weatherTower);
    }
    
    public String toString(){
        return "Helicopter : " + super.toString();
    }

}