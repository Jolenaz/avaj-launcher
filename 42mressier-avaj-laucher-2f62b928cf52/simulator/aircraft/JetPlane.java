package simulator.aircraft;

import simulator.Log;
import simulator.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable
{
	private WeatherTower		weatherTower;

	/*
	** Constructor
	*/
	JetPlane(String name, Coordinates coordinates)
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
				+ "] What's going ooon?? *sprotch*");
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
		return "JetPlane#" + super.toString();
	}

	/*
	** Private Methods
	*/
	private Coordinates		_sun(Coordinates coordinates)
	{
		Log.write(this.toString() + ": To infinity, and beyond !");

		Coordinates newCoord = new Coordinates(coordinates.getLongitude(),
												coordinates.getLatitude() + 10,
												coordinates.getHeight() + 2);
		return (newCoord);
	}

	private Coordinates		_rain(Coordinates coordinates)
	{
		Log.write(this.toString() + ": I'm siiiiinging in the rain!");

		Coordinates newCoord = new Coordinates(coordinates.getLongitude(),
												coordinates.getLatitude() + 5,
												coordinates.getHeight());
		return (newCoord);
	}

	private Coordinates		_fog(Coordinates coordinates)
	{
		Log.write(this.toString() + ": Hope there is not a cliff behind these clouds.");

		Coordinates newCoord = new Coordinates(coordinates.getLongitude(),
												coordinates.getLatitude() + 1,
												coordinates.getHeight());
		return (newCoord);
	}

	private Coordinates		_snow(Coordinates coordinates)
	{
		Log.write(this.toString() + ": [...wind sound and censure...] Let it go, let it go !!!");

		Coordinates newCoord = new Coordinates(coordinates.getLongitude(),
												coordinates.getLatitude(),
												coordinates.getHeight() - 7);
		return (newCoord);
	}
}
