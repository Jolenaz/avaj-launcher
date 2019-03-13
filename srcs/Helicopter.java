package pack;

/**
 * Helicopter
 */
public class Helicopter extends Aircraft implements Flyable{

    private WeatherTower _weatherTower;

    public Helicopter(String name, Coordinates coord){
        super(name, coord);
    }
    
    public void registerTower(WeatherTower weatherTower){
        this._weatherTower = weatherTower;
        weatherTower.register(this);
    }

    public void updateConditions(){
        String weather = this._weatherTower.getWeather(_coordinates);
        switch (weather){
            case "SUN":
            break;
            case "SNOW":
            break;
            case "RAIN":
            break;
            case "FOG":
            break;
        }
    }
    
    public String toString(){
        return "Helicopter : " + super.toString();
    }

}