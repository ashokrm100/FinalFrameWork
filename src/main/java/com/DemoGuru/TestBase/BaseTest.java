package com.DemoGuru.TestBase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.openqa.selenium.remote.DesiredCapabilities;
import com.DemoGuru.PageObjects.ConfigLinkPage;
import com.DemoGuru.Utility.TimeoutsUtility;

public class BaseTest {
	
	ConfigLinkPage cp = new ConfigLinkPage();
	public String username = cp.getUserName();
	public String password = cp.getPassword();
	public String url = cp.getUrl();
	public String browser = cp.getBrowser();
	public WebDriver driver;
	//public String browser = System.getproperty("browser");
	//Logger Log = LogManager.getLogger(BaseTest.class.getName());
	
	
	//@Parameters("browser")
	@BeforeClass
	//public void setup(@Optional("chrome") String browser)
	public void setup()
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E://CHROMEDRIVER//chromedriver.exe" );
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","E://firefox//geckodriver.exe");
			DesiredCapabilities ffCapabilities = DesiredCapabilities.firefox();
			ffCapabilities.setCapability("marionette",true);
			WebDriver driver = new FirefoxDriver(ffCapabilities);
			
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
	
	public String getScreenShot(String methodName, WebDriver driver)
	{
	String path = System.getProperty("user.dir")+"/test-output/ScreenShots"+methodName+System.currentTimeMillis()+".png"; 
	TakesScreenshot ts =(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(src, new File(path));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	return path;
				
	}

}
