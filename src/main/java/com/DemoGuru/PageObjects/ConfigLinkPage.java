package com.DemoGuru.PageObjects;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigLinkPage {

	FileInputStream fis;
	Properties prop;
	public String user;
	public String passd;
	public String url1;
	public String browse;
	public ConfigLinkPage()
	{
		
		try {
			prop = new Properties();
			fis=new FileInputStream(".\\src\\main\\java\\com\\DemoGuru\\Config\\config.properties");
			
			prop.load(fis);			
			//System.out.println(prop.getProperty("username"));
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}
		
	}
	
	public String getUserName()
	{
		user = prop.getProperty("username");
		//System.out.println(user);
		return user;
	}
	
	public String getPassword()
	{
		passd = prop.getProperty("password");
		//System.out.println(passd);
		return passd;
	}
	
	public String getUrl()
	{
		url1 = prop.getProperty("url");
		//System.out.println(url1);
		return url1;
	}
	
	public String getBrowser()
	{
	 browse = System.getProperty("browser");
	 return browse;
	}
	
	/*public static void main(String args[])
	{
		ConfigLinkPage cp = new ConfigLinkPage();
		//cp.setConfig();
		cp.getUserName();
		cp.getPassword();
		cp.getUrl();
	}*/
	
	
}
