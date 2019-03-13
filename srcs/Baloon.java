package pack;

/**
 * Baloon
 */
public class Baloon extends Aircraft implements Flyable {

    private WeatherTower _weatherTower;

    public Baloon(String name, Coordinates coord) {
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
                Log.write("\tsays: it's Sunny, go heigher");
                moveTo( new Coordinates(2,0,4));
            break;
            case "SNOW":
                Log.write(toString());
                Log.write("\tsays: it's Snowing for me, am cold!!");
                moveTo(new Coordinates(0,0,-15));
            break;
            case "RAIN":
                Log.write(toString());
                Log.write("\tsays: it's Rainning, I hate my Job");
                moveTo(new Coordinates(0,0,-5));
            break;
            case "FOG":
                Log.write(toString());
                Log.write("\tsays: it's the fog, wher the hell am I?");
                moveTo(new Coordinates(0,0,-3));
            break;
        }
        if (_coordinates.getHeight() == 0)
            Log.write(toString() + " is now Landed");
    }

    public String toString(){
        return "Baloon : " + super.toString();
    }


}