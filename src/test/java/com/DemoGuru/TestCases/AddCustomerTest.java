package com.DemoGuru.TestCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoGuru.PageObjects.ManagerLoginPage;
import com.DemoGuru.PageObjects.NewCustomerPage;
import com.DemoGuru.TestBase.BaseTest;
import com.DemoGuru.Utility.Logs;


public class AddCustomerTest extends BaseTest {

	NewCustomerPage np;
	ManagerLoginPage mp;
	//String browser;

	@Test
	public void sendCustomerName() {
		Logs.info("Second Test Started");
		mp = new ManagerLoginPage(driver);
		Logs.info("Manager name sent");
		mp.getManagerUser(username);
		Logs.info("Manager pwd sent");
		mp.getManagerPwd(password);
		mp.getSubmit();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mp.getLink();
		np = new NewCustomerPage(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Logs.info("Sending Customer Name");
		np.getCustName("Ashok");
		Logs.info("Clicked on Gender");
		np.Gender();
		System.out.println(System.getProperty("user.dir"));
		//String dateVal="30-12-1990";
		if(browserval.equals("IE"))
		{
		np.getDOB("12/","09/","1990");
		}
		else
		{
			np.getDOB("12","09","1990");
		}
		try {
		Thread.sleep(2000);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		Logs.info("Entered DOB");
		np.addAddress("This is AshokKumar in Valtertheru");
		Logs.info("Entered Address");
		//Logs.debug("Not able to enter address");
		np.place("Ootacalmund");
		Logs.info("Entered Password");
		np.getState("Karunatak");
		Logs.info("Entered State");
		np.pincode(GeneratePincode());
		np.getMobile("7676767676");
		Logs.info("Entered Mobile");
		np.getEmailId(generateMailid()+"@gmail.com");
		Logs.info("Entered Mailid");
		np.getPwd(GeneratePincode());
		Logs.info("Entered Pincode");
		np.getSubmit();
		Logs.info("Clicked on submit");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean val= driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(val==true)
		{
			Assert.assertTrue(true);
			Logs.info("Customer added successfully");
		}
		else 
		{
			Assert.assertTrue(false);
			Logs.info("Failed to add new Customer");
		}

		
		
		
		/*System.out.println(driver.switchTo().alert().getText());
		String expected = "please fill all fields";
		if (expected.equals(driver.switchTo().alert().getText())) {
			Assert.assertTrue(true);
			Logs.info("Alert Message displayed Successfully");

		} else {
			Logs.debug("Alert message doesnot match");

		}*/
	}
	
	public String GeneratePincode()
	{
		String pin = RandomStringUtils.randomNumeric(6);
		return pin;
	}
	
	public String generateMailid()
	{
		String mail = RandomStringUtils.randomAlphanumeric(7);
		return mail;
	}
	
	
	
	
}
