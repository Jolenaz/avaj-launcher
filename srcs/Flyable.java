package pack;

import pack.WeatherTower;

/**
 * Flyable
 */

public interface Flyable {

    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);

}