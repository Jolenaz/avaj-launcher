package simulator.weather;

import simulator.aircraft.Coordinates;

public class WeatherProvider
{
	private static WeatherProvider		weatherProvider = new WeatherProvider();
	private static String[]				weather = {"rain", "fog", "sun", "snow"};

	/*
	** Constructor(s)
	*/
	private WeatherProvider()
	{
	}

	/*
	** Public Methods
	*/

	public static WeatherProvider	getProvider()
	{
		return WeatherProvider.weatherProvider;
	}

	public String					getCurrentWeather(Coordinates coordinates)
	{
		return (this._getWeatherFromLocation(coordinates));
	}

	/*
	** Private Methods
	*/

	private String _getWeatherFromLocation(Coordinates coordinates)
	{
		int		ret = (coordinates.getHeight()
						+ coordinates.getLatitude()
						+ coordinates.getLongitude()) % WeatherProvider.weather.length;

		return (this.weather[ret]);
	}
}
