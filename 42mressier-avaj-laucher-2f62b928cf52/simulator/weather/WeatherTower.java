package simulator.weather;

import simulator.aircraft.Coordinates;
import simulator.weather.Tower;

public class WeatherTower extends Tower
{
	private static WeatherProvider		weatherProvider = WeatherProvider.getProvider();

	/*
	** Public Methods
	*/
	public String		getWeather(Coordinates coordinates)
	{
		return weatherProvider.getCurrentWeather(coordinates);
	}

	/*
	** Only-Package Methods
	*/
	void changeWeather()
	{
		super.conditionsChanged();
	}
}