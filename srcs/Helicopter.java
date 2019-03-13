package pack;

/**
 * Helicopter
 */
public class Helicopter extends Aircraft implements Flyable{

    private WeatherTower _weatherTower;

    public Helicopter(String name, Coordinates coord) {
        super(name, coord);
    }
    
    public void registerTower(WeatherTower weatherTower){
        this._weatherTower = weatherTower;
        weatherTower.register(this);
    }

    public void updateConditions(){
        if (_coordinates.getHeight() == 0)
            return;
        String weather = this._weatherTower.getWeather(_coordinates);
        switch (weather){
            case "SUN":
                Log.write(toString());
                Log.write("\tsays: it's Sunny, flip flap the birds");
                moveTo(new Coordinates(10,0,2));
            break;
            case "SNOW":
                Log.write(toString());
                Log.write("\tsays: it's Snow , where are ypu John");
                moveTo(new Coordinates(0,0,-12));
            break;
            case "RAIN":
                Log.write(toString());
                Log.write("\tsays: it's Rainning again Oh no");
                moveTo(new Coordinates(5,0,0));
            break;
            case "FOG":
                Log.write(toString());
                Log.write("\tsays: it's the Fog, their ar towers next to here?");
                moveTo(new Coordinates(1,0,0));
            break;
        }
        if (_coordinates.getHeight() == 0)
            Log.write(toString() + " is now Landed");
    }
    
    public String toString(){
        return "Helicopter : " + super.toString();
    }

}