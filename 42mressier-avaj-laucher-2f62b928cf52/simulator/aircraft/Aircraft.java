package simulator.aircraft;

import simulator.weather.WeatherProvider;

public abstract class Aircraft
{
	/*
	** Attributes
	*/
	private static long			idCounter = 0;

	protected long				id;
	protected String			name;
	protected Coordinates		coordinates;

	/*
	** Constructors
	*/
	protected Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
		this.id = _nextId();
	}

	/*
	** Public Methods
	*/
	public String			toString()
	{
		return (this.name + "(" + this.id + ")");
	}

	/*
	** Private Methods
	*/
	private long			_nextId()
	{
		Aircraft.idCounter++;
		return Aircraft.idCounter;
	}

}
