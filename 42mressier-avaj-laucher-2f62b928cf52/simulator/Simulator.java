package simulator;

import simulator.weather.*;
import simulator.aircraft.*;
import simulator.Log;
import java.io.*;
import java.util.Arrays;

public class Simulator
{
	private static WeatherSimulator		weatherSimulator = new WeatherSimulator();
	private static Flyable[]			observers;

	/*
	** Public Methods
	*/
	public static void main(String[] args)
	{
		try
		{
			if (args.length != 1)
			{
				System.err.println("Error: usage: simulator.Simulator <file>");
				return ;
			}
			Simulator._readFileAndInitSimulator(args[0]);
			Log.open("simulation.txt");
			Simulator.weatherSimulator.run(10, Simulator.observers);
			Log.close();
		}
		catch (IOException e)
		{
			System.err.println("Error : " + e.getMessage());
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	/*
	** Private Methods
	*/
	private static void _readFileAndInitSimulator(String filename) throws IOException, SimulatorFileException
	{
		InputStream file;
		byte		fileContent[];
		String		strContent;
		int			fileSize;

		file = new FileInputStream(filename);
		try
		{
			fileSize = file.available();
			if (fileSize <= 0)
				throw new IOException(filename + " (File is empty)");
			fileContent = new byte[fileSize];
			if (file.read(fileContent) != fileSize)
				throw new IOException(filename + " (Problem when reading file)");
			strContent = new String(fileContent);
			Simulator._initSimulatorWithFileContent(strContent);
		}
		finally
		{
			file.close();
		}
	}

	private static void		_initSimulatorWithFileContent(String fileContent) throws SimulatorFileException
	{
		String		lines[] = fileContent.split("\r*\n");

		if (lines.length < 2)
			throw new SimulatorFileException(1, "Invalid File format : Need at least one line for number of run,"
				+ "and one line for an aircraft");
		Simulator._initNbOfRun(lines[0]);
		Simulator._initObserverList(lines);
	}

	private static void		_initNbOfRun(String firstLine) throws SimulatorFileException
	{
		int			nbRun;

		try
		{
			Simulator.weatherSimulator.setNbRun(Integer.parseInt(firstLine));
		}
		catch (Exception e)
		{
			throw new SimulatorFileException(1, "invalid number of run : " + e.getMessage());
		}
	}

	private static void		_initObserverList(String lines[]) throws SimulatorFileException
	{
		Flyable 	observers[] = new Flyable[lines.length - 1];
		int			obsNb = 0;
		String		line;
		String		elements[];
		int			lineNb = 1;

		try
		{
			for (lineNb = 1; lineNb < lines.length; lineNb++)
			{
				line = lines[lineNb];
				if (line.isEmpty())
					continue ;
				elements = line.split(" ");
				if (elements.length != 5)
					throw new SimulatorFileException(lineNb, "invalid format");
				observers[obsNb] = AircraftFactory.newAircraft(elements[0],		// type
																elements[1],	// name
																Integer.parseInt(elements[2]),	// longitute
																Integer.parseInt(elements[3]),	// latitude
																Integer.parseInt(elements[4]));	// height
				obsNb++;
			}
			Simulator.observers = observers;
		}
		catch (NumberFormatException e)
		{
			throw new SimulatorFileException(lineNb, "Can't convert to coordinate : " + e.getMessage());
		}
		catch (Exception e)
		{
			throw new SimulatorFileException(lineNb, e.getMessage());
		}
	}
}

/*
** Exceptions
*/
class SimulatorFileException extends Exception
{
	SimulatorFileException(int line, String message)
	{
		super("Error line " + line + ": " + message);
	}
}
