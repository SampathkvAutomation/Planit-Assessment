package com.web.ui.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader 
{
	

	private static Properties prop = new Properties();
	
	public static void load() 
	{
  String file = System.getProperty("user.dir")+File.separator+ "src/test/resources/project.properties";
		  
  try {
	FileInputStream propsFile = new FileInputStream(file);
	prop.load(propsFile);
	}
  catch(FileNotFoundException e)
  {
	  e.printStackTrace();
  }
  catch(IOException e)
  {
	  e.printStackTrace();
  }
}
	public static String getBaseUrl()
	{
		load();
		return prop.getProperty("project.base.url");
	}
	
	
	public static String getChromeDriver()
	{
		load();
		return prop.getProperty("project.driver.chrome.driver");
	}
}
