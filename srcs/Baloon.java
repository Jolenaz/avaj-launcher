package pack;

/**
 * Baloon
 */
public class Baloon extends Aircraft {

    private WeatherTower _weatherTower;

    public Baloon(String name, Coordinates coord){
        super(name, coord);
    }
    
    public void registerTower(WeatherTower weatherTower){
        this._weatherTower = weatherTower;
        super.registerTower(weatherTower);
    }

    public String toString(){
        return "Baloon : " + super.toString();
    }

}