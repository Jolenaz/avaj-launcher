package pack;

/**
 * JetPlane
 */
public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower _weatherTower;

    public JetPlane(String name, Coordinates coord) {
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
                Log.write("\tsays: it's Sunny, Go Faster");
                moveTo(new Coordinates(0,10,2));
            break;
            case "SNOW":
                Log.write(toString());
                Log.write("\tsays:  it's the Snow, but I don't care I have a big plane");
                moveTo(new Coordinates(0,0,-7));
            break;
            case "RAIN":
                Log.write(toString());
                Log.write("\tsays: it's raining, go watching my zinc");
                moveTo(new Coordinates(0,5,0));
            break;
            case "FOG":
                Log.write(toString());
                Log.write("\tsays: it's the Fog idiot, not a funcking chemtrail!!!");
                moveTo(new Coordinates(0,1,0));
            break;
        }
        if (_coordinates.getHeight() == 0)
            Log.write(toString() + " is now Landed");
    }

    public String toString(){
        return "JetPlane : " + super.toString();
    }
}