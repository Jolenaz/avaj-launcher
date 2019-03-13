package pack;

public class InvalidAircraftException extends Exception
{
	public InvalidAircraftException(String type)
	{
		super("aircraft type \"" + type + "\" is invalid");
	}

	public InvalidAircraftException(int coordinateValue)
	{
		super("coordinate value \"" + coordinateValue + "\" is invalid");
	}
}