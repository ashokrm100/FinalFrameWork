package com.DemoGuru.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoGuru.TestBase.BaseTest;

public class ManagerLoginPage extends BaseTest {
		
	@FindBy(css="input[type='text'][name='uid']")
	@CacheLookup
	WebElement userName;
	
	@FindBy(css="input[type='password']")
	@CacheLookup
	WebElement passWord;
	
	@FindBy(css="input[type='submit']")
	@CacheLookup
	WebElement submit;
	
	@FindBy(css="input[type='reset']")
	@CacheLookup
	WebElement reset;
	
	public ManagerLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getManagerUser(String usr)
	{
		userName.sendKeys(usr);
		return userName;
	}
	
	public WebElement getManagerPwd(String pwd)
	{
		passWord.sendKeys(pwd);
		return passWord;
	}
	
	public WebElement getSubmit()
	{
		submit.click();
		return submit;
	}

	
	
}
