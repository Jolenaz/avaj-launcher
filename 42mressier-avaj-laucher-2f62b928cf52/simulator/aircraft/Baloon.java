package simulator.aircraft;

import simulator.Log;
import simulator.weather.*;

public class Baloon extends Aircraft implements Flyable
{
	private WeatherTower		weatherTower;

	/*
	** Constructor
	*/
	Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	/*
	** Public Methods
	*/
	public void		updateConditions()
	{
		String weather = this.weatherTower.getWeather(this.coordinates);

		// Log.write(this.coordinates);
		if (weather.compareToIgnoreCase("rain") == 0)
			this.coordinates = this._rain(coordinates);
		if (weather.compareToIgnoreCase("fog") == 0)
			this.coordinates = this._fog(coordinates);
		if (weather.compareToIgnoreCase("sun") == 0)
			this.coordinates = this._sun(coordinates);
		if (weather.compareToIgnoreCase("snow") == 0)
			this.coordinates = this._snow(coordinates);

		/* if scratch */
		if (this.coordinates.getHeight() <= 0)
		{
			Log.write(this.toString()
				+ " : [" + this.coordinates.toString()
				+ "] The floor is growing! *sprotch*");
			this.weatherTower.unregister(this);
		}
	}

	public void		registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}

	public String	toString()
	{
		return "Baloon#" + super.toString();
	}

	/*
	** Private Methods
	*/
	private Coordinates		_sun(Coordinates coordinates)
	{
		Log.write(this.toString() + ": It's sunny today! :D");

		Coordinates newCoord = new Coordinates(coordinates.getLongitude() + 2,
												coordinates.getLatitude(),
												coordinates.getHeight() + 4);
		return (newCoord);
	}

	private Coordinates		_rain(Coordinates coordinates)
	{
		Log.write(this.toString() + ": Arg, where is the umbrella on this baloon ?");

		Coordinates newCoord = new Coordinates(coordinates.getLongitude(),
												coordinates.getLatitude(),
												coordinates.getHeight() - 5);
		return (newCoord);
	}

	private Coordinates		_fog(Coordinates coordinates)
	{
		Log.write(this.toString() + ": It's foggyyyyyy :S");

		Coordinates newCoord = new Coordinates(coordinates.getLongitude(),
												coordinates.getLatitude(),
												coordinates.getHeight() - 3);
		return (newCoord);
	}

	private Coordinates		_snow(Coordinates coordinates)
	{
		Log.write(this.toString() + ": It's snowing now... :X");

		Coordinates newCoord = new Coordinates(coordinates.getLongitude(),
												coordinates.getLatitude(),
												coordinates.getHeight() - 15);
		return (newCoord);
	}
}