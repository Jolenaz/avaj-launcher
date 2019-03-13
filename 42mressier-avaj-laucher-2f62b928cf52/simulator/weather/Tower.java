package simulator.weather;

import simulator.Log;
import simulator.aircraft.Flyable;
import java.util.ArrayList;

abstract class Tower
{
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	/*
	** Constructor
	*/

	/*
	** Public Methods
	*/
	public void 	register(Flyable flyable)
	{
		if (this.observers.contains(flyable))
			System.err.println("Already register");
		else
		{
			this.observers.add(flyable);
			Log.write("Tower says: " + flyable.toString()
				+ " register.");
		}
	}

	public void 	unregister(Flyable flyable)
	{
		int		index = this.observers.indexOf(flyable);

		if (index == -1)
			System.err.println("Not register");
		else
		{
			this.observers.remove(index);
			Log.write("Tower says: " + flyable.toString()
				+ " unregister.");
		}
	}

	/*
	** Protected Methods
	*/
	protected void	conditionsChanged()
	{
		Flyable tmpObservers[] = {};

		tmpObservers = this.observers.toArray(tmpObservers);
		for (int i = 0; i < tmpObservers.length; i++)
		{
			tmpObservers[i].updateConditions();
		}
	}
}