package simulator.aircraft;

public class Coordinates
{
	private int latitude;
	private int longitude;
	private int height;

	/*
	** Constructor
	*/
	Coordinates(int longitude, int latitude, int height)
	{
		this._setLongitude(longitude);
		this._setLatitude(latitude);
		this._setHeight(height);
	}

	/*
	** Public Methods
	*/
	public int getLatitude()
	{
		return this.latitude;
	}

	public int getLongitude()
	{
		return this.longitude;
	}

	public int getHeight()
	{
		return this.height;
	}

	public String toString()
	{
		return ("lg: " + this.longitude
				+ ", lt: " + this.latitude
				+ ", h: " + this.height);
	}

	/*
	** Private Methods
	*/
	private void _setLatitude(int latitude)
	{
		if (latitude < 0)
			this.latitude = -latitude;
		else
			this.latitude = latitude;
	}

	private void _setLongitude(int longitude)
	{
		if (longitude < 0)
			this.longitude = -longitude;
		else
			this.longitude = longitude;
	}

	private void _setHeight(int height)
	{
		if (height > 100)
			this.height = 100;
		else
			this.height = height;
	}
}