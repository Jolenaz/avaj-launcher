package simulator.aircraft;

import simulator.Log;
import simulator.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable
{
	private WeatherTower		weatherTower;

	/*
	** Constructor
	*/
	Helicopter(String name, Coordinates coordinates)
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
				+ "] Arrrggggg... *sprotch*");
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
		return "Helicopter#" + super.toString();
	}

	/*
	** Private Methods
	*/
	private Coordinates		_sun(Coordinates coordinates)
	{
		Log.write(this.toString() + ": Wait wait where are my sunglasses?");

		Coordinates newCoord = new Coordinates(coordinates.getLongitude() + 10,
												coordinates.getLatitude(),
												coordinates.getHeight() + 2);
		return (newCoord);
	}

	private Coordinates		_rain(Coordinates coordinates)
	{
		Log.write(this.toString() + ": It's raining cats and dogs...");

		Coordinates newCoord = new Coordinates(coordinates.getLongitude() + 5,
												coordinates.getLatitude(),
												coordinates.getHeight());
		return (newCoord);
	}

	private Coordinates		_fog(Coordinates coordinates)
	{
		Log.write(this.toString() + ": It's so foggy, I can't see my rotors.");

		Coordinates newCoord = new Coordinates(coordinates.getLongitude() + 1,
												coordinates.getLatitude(),
												coordinates.getHeight());
		return (newCoord);
	}

	private Coordinates		_snow(Coordinates coordinates)
	{
		Log.write(this.toString() + ": My rotors are gonna freeze!!");

		Coordinates newCoord = new Coordinates(coordinates.getLongitude(),
												coordinates.getLatitude(),
												coordinates.getHeight() - 12);
		return (newCoord);
	}
}