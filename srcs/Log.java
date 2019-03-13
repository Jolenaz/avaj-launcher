package pack;

import java.io.*;

public abstract class Log
{
	private static boolean			isOpen = false;
	private static OutputStream		outputFile;

	/*
	** Constructor
	*/
	private Log() {}

	/*
	** Public Method
	*/
	public static void open(String filename) throws IOException
	{
		if (Log.isOpen == true)
			Log.close();
		Log.outputFile = new FileOutputStream(filename);
		Log.isOpen = true;
	}

	public static void close() throws IOException
	{
		if (Log.isOpen == true)
			Log.outputFile.close();
		Log.isOpen = false;
	}

	public static void write(String message)
	{
		try
		{
			byte	byteMsg[] = new String(message + "\n").getBytes();

			if (Log.isOpen){
				Log.outputFile.write(byteMsg);
			}
		}
		catch (IOException e)
		{
			System.err.println("Log error during writing");
		}
	}
}