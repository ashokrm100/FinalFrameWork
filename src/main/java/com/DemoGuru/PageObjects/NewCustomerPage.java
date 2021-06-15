package com.DemoGuru.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoGuru.TestBase.BaseTest;

public class NewCustomerPage extends BaseTest {
	
	@FindBy(name="name")
	@CacheLookup
	WebElement custName;
	
	@FindBy(name="name") 
	@CacheLookup
	WebElement customername;
	
	@FindBy(xpath="//input[@type='radio' and @value='m']")
	@CacheLookup
	WebElement gender;
	
	@FindBy(name="dob")
	@CacheLookup
	WebElement dob;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement address;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement city;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement state;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement pincode;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement telephoneno;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement emailid;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(css="input[type='submit']")
	@CacheLookup
	WebElement submit;
	
	
	
	public NewCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void getCustName(String cName)
	{
		custName.sendKeys(cName);
	}
	
	public void Gender()
	{
		gender.click();
	}
	
	public void getDOB(String day, String month, String Year)
	//public WebElement getDOB()
	{
		dob.click();
		dob.sendKeys(day);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dob.sendKeys(month);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dob.click();
		dob.sendKeys(Year);
	}
	
	public void addAddress(String add)
	{
		address.sendKeys(add);
		
	}
	
	public void place(String location)
	{
		city.sendKeys(location);
	}
	
	public void getState(String loc)
	{
		state.sendKeys(loc);
	}
	
	public void pincode(String pin)
	{
		pincode.sendKeys(pin);
	}
	
	public void getMobile(String mob)
	{
		telephoneno.sendKeys(mob);
	}
	
	public void getEmailId(String mail)
	{
		emailid.sendKeys(mail);
	}
	
	public void getPwd(String pass) {
		pwd.sendKeys(pass);
	}
	
	
	public void getSubmit()
	{
		submit.click();
	}

}
