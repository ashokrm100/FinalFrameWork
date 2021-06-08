package com.DemoGuru.TestBase;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.DemoGuru.PageObjects.ConfigLinkPage;
import com.DemoGuru.Utility.TimeoutsUtility;

public class BaseTest {
	
	ConfigLinkPage cp = new ConfigLinkPage();
	public String username = cp.getUserName();
	public String password = cp.getPassword();
	public String url = cp.getUrl();
	public WebDriver driver;
	//Logger Log = LogManager.getLogger(BaseTest.class.getName());
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("chrome") String browser)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E://CHROMEDRIVER//chromedriver.exe" );
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","E://firefox//geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","E://IEDRIVER//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TimeoutsUtility.Timeouts, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TimeoutsUtility.implicitywait, TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	
	public void tearDown()
	{
		driver.quit();
	}

}
