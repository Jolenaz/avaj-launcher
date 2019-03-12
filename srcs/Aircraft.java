package pack;

/**
 * Aircraft
 */
public class Aircraft implements Flyable {

    protected long _id;
    protected String _name;
    protected Coordinates _coordinates;
    
    private static long idCounter = 0L;

    public Aircraft(String name, Coordinates coordinates){
        this._name = name;
        this._coordinates = coordinates;
        this._id = this.nextId();
    }
    
    private long nextId(){
        Aircraft.idCounter += 1;
        return (Aircraft.idCounter);
    }

    public String toString(){
        return("name: " + this._name + ", id: " + this._id + ", coord: " + this._coordinates.toString() );
    }

    public void updateConditions(){

    }
    
    public void registerTower(WeatherTower weatherTower){
        weatherTower.register(this);
    }

}