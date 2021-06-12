package com.DemoGuru.Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
	
	public static Logger Log = LogManager.getLogger(Logs.class.getName());
	
	public static void onStartLog(String testname)
	{
		Log.info("---------"+ testname +"  Started" +"----------");
	}
	
	public static void onFinishLog(String testname)
	{
		Log.info("---------"+ testname +"  Finished" +"----------");
	}
	
	public static void info(String message)
	{
		Log.info(message);
	}
	
	public static void warn(String message)
	{
		Log.info(message);
	}
	
	public static void debug(String message)
	{
		Log.info(message);
	}

}
