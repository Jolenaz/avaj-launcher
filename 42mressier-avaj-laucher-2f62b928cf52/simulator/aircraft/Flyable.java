package simulator.aircraft;

import simulator.weather.WeatherTower;

public interface Flyable
{
	/*
	** Public Methods
	*/
	public void		updateConditions();
	public void		registerTower(WeatherTower weatherTower);
	public String	toString();
}
