package simulator.weather;

import simulator.aircraft.Flyable;

public class WeatherSimulator
{
	private Flyable			observers[] = {};
	private int				nbRun = 1;
	/*
	** Constructors
	*/

	/*
	** Public Methods
	*/
	public void		setObservers(Flyable observers[])
	{
		this.observers = observers;
	}

	public void		setNbRun(int nbRun) throws WeatherSimulator.NbOfRunException
	{
		if (nbRun <= 0)
			throw new WeatherSimulator.NbOfRunException(nbRun);
		this.nbRun = nbRun;
	}

	public void		run(int nbRun, Flyable observers[])
	{
		WeatherTower		tower = new WeatherTower();

		for (int i = 0; i < observers.length; i++)
		{
			if (observers[i] == null)
				break ;
			observers[i].registerTower(tower);
		}

		for (int i = 0; i < this.nbRun; i++)
		{
			tower.changeWeather();
		}
	}

	/*
	** Exceptions
	*/
	static public class	NbOfRunException extends Exception
	{
		public NbOfRunException (int nbRun)
		{
			super("value " + nbRun);
		}
	}
}