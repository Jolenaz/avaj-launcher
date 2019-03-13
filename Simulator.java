import pack.*;

import java.io.*;

public class Simulator{

    private static WeatherTower wt = new WeatherTower();
    private static int nbRun = 0;
    private static AircraftFactory af = new AircraftFactory();
    public static void main(String[] args){

        try{
            if (args.length != 1)
			{
				System.err.println("Error: need to pass the scenario in args");
				return ;
			}
			Log.open("simulation.txt");
			Simulator._readFileAndInitSimulator(args[0]);
			for (int i = 0; i < Simulator.nbRun; i++){
                Simulator.wt.changeWeather();
            }
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
    
	private static void _initSimulatorWithFileContent(String fileContent) throws SimulatorFileException
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
		try
		{
			Simulator.nbRun = Integer.parseInt(firstLine);
		}
		catch (Exception e)
		{
			throw new SimulatorFileException(1, "invalid number of run : " + e.getMessage());
		}
	}

	private static void		_initObserverList(String lines[]) throws SimulatorFileException
	{
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
                Flyable tmp = Simulator.af.newAircraft(elements[0],	elements[1], Integer.parseInt(elements[2]),	Integer.parseInt(elements[3]), Integer.parseInt(elements[4]));
				tmp.registerTower(Simulator.wt);
			}
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
		super("Error: line " + line + ": " + message);
	}
}