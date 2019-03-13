package simulator.aircraft;

public abstract class AircraftFactory
{
	private static final String			types[] = {"helicopter", "jetplane", "baloon"};
	private static final AircraftMethod	methods[] = {
													/* Helicopter */
													new AircraftMethod()
														{ public Flyable method(String name, Coordinates coordinates)
															{ return new Helicopter(name, coordinates); } },
													/* JetPlane */
													new AircraftMethod()
														{ public Flyable method(String name, Coordinates coordinates)
															{ return new JetPlane(name, coordinates); } },
													/* Baloon */
													new AircraftMethod()
														{ public Flyable method(String name, Coordinates coordinates)
															{ return new Baloon(name, coordinates); } },
													};

	/*
	** Public Method
	*/
	public static Flyable	newAircraft(String type, String name,
									int longitude, int latitude, int height) throws InvalidAircraftException
	{
		Coordinates coordinates;

		if (longitude <= 0) throw new InvalidAircraftException(longitude);
		if (latitude <= 0) throw new InvalidAircraftException(latitude);
		if (height <= 0) throw new InvalidAircraftException(height);

		coordinates = new Coordinates(longitude, latitude, height);
		for (int i = 0; i < AircraftFactory.types.length; i++)
		{
			if (type.compareToIgnoreCase(AircraftFactory.types[i]) == 0)
				return (AircraftFactory.methods[i].method(name, coordinates));
		}
		throw new InvalidAircraftException(type);
	}
}

interface AircraftMethod {
	Flyable method(String name, Coordinates coordinates);
}
