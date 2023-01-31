package com.java.DIG_cukes;
import java.util.logging.Logger;

public class Log {

	private static Logger Log = Logger.getLogger(Log.class.getName()); 
	
	public static void startTestCase(String sTestCaseName){
		Log.info("Started Test case");
	}


	public static void endTestCase(String sTestCaseName){
		Log.info("Ended Test Case");
	}

	public static void info(String message)
	{
		Log.info(message);
	}

}