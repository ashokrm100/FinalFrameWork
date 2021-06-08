package com.DemoGuru.TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;


import com.DemoGuru.PageObjects.ManagerLoginPage;
import com.DemoGuru.TestBase.BaseTest;
import com.DemoGuru.Utility.Logs;

import jdk.internal.org.jline.utils.Log;

public class ManagerLoginTest extends BaseTest {
	ManagerLoginPage mp ;
	
	//Logger Log = LogManager.getLogger(ManagerLoginTest.class.getName());
	//String name = Log.getName();
	
	@Test
	public void LoginPageTest()
	{
		Logs.onStartLog("LoginPageTest");
		Logs.info("Browser Initialized");
		mp = new ManagerLoginPage(driver);
		Logs.info("Url is Opened");
		mp.getManagerUser(username);
		Logs.info("UserName is send");
		mp.getManagerPwd(password);
		Logs.info("Password is send");
		mp.getSubmit();
		Logs.info("Submitted");
		Logs.onFinishLog("LoginPageTest");
		String expected ="Guru99 Bank Manager HomePage";
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals(expected))
		{
			Assert.assertTrue(true);
			Logs.info("Test cases passed");
			System.out.println("TestCase Pass");
		}
		else
		{
			Assert.assertFalse(true);
		}
	}
}
