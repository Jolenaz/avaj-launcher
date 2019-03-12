package pack;

import pack.Coordinates;

/**
 * AircraftFactory
 */
public class AircraftFactory {

    public Flyable newAirecraft(String type, String name, int longitude, int latitude, int height){
        Aircraft ret;
        Coordinates coor = new Coordinates(longitude, latitude, height);
        switch (type){
            case "Baloon":
                ret = new Baloon(name, coor);
                break;
            case "JetPlane":
                ret = new JetPlane(name, coor);
                break;
            case "Helicopter":
                ret = new Helicopter(name, coor);
                break;
            default:
                ret = null;
        }
        return ret;
    }

}