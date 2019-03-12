package pack;

/**
 * JetPlane
 */
public class JetPlane extends Aircraft {

    private WeatherTower _weatherTower;

    public JetPlane(String name, Coordinates coord){
        super(name, coord);
    }

    public void registerTower(WeatherTower weatherTower){
        this._weatherTower = weatherTower;
        super.registerTower(weatherTower);
    }

    public String toString(){
        return "JetPlane : " + super.toString();
    }
}