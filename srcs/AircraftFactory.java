package pack;

import pack.Coordinates;

/**
 * AircraftFactory
 */
public class AircraftFactory {

    public Flyable newAirecraft(String type, String name, int longitude, int latitude, int height){
        Coordinates coor = new Coordinates(longitude, latitude, height);
        switch (type){
            case "Baloon":
                return new Baloon(name, coor);
            case "JetPlane":
                return new JetPlane(name, coor);
            case "Helicopter":
                return new Helicopter(name, coor);
            default:
                return null;
        }
    }

}