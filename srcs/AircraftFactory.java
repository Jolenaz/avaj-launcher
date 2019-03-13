package pack;

import pack.Coordinates;

/**
 * AircraftFactory
 */
public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws InvalidAircraftException{
            if (height < 0)
                throw new InvalidAircraftException(height);
            else if (height > 100)
                height = 100;

            if (longitude < 0)
                throw new InvalidAircraftException(longitude);
    
            if (latitude < 0)
                throw new InvalidAircraftException(latitude);

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