package com.DemoGuru.TestCases;

import org.testng.annotations.Test;

import com.DemoGuru.PageObjects.ManagerLoginPage;
import com.DemoGuru.TestBase.BaseTest;
import com.DemoGuru.Utility.ExcelUtility;
import com.DemoGuru.Utility.Logs;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class TC_002_LoginData extends BaseTest {
	//Logger Log = LogManager.getLogger(TC_002_LoginData.class.getName());
	FileInputStream fis;
	String path;

	@Test(dataProvider = "Exceldata")
	public void getLoginData(String username, String password) {
		Logs.info("Browser initialized");
		Logs.info(username);
		Logs.info(password);
		ManagerLoginPage dm = new ManagerLoginPage(driver);
		Logs.info("Data Provider value send");
		dm.getManagerUser(username);
		Logs.info("Data Provider Password send");
		dm.getManagerPwd(password);
		dm.getSubmit();
		if(getalertbox()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else 
		{
			Assert.assertTrue(true);
		}
		//String Expected ="Guru99 Bank Manager HomePage";
		//Assert.assertEquals(driver.getTitle(), Expected,"Not a valid username and password");
		
		
	}
	
	public boolean getalertbox()
	{
		try {
		driver.switchTo().alert();
		return true;
		}catch(Exception e)
		{
			return false;
		}
		
	}

	@DataProvider(name = "Exceldata")
	public Object[][] sendLoginData() throws IOException {

		path = ".\\src\\main\\java\\com\\Demoguru\\Data\\LoginData.xlsx";

		ExcelUtility ex = new ExcelUtility(path);
		int rownum = ex.getRowCount("LoginCredentials");

		int colnum = ex.getCellCount(0, "LoginCredentials");

		Object[][] arr = new Object[rownum][colnum];

		for (int i = 0; i < rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				arr[i][j] = ex.excelContent("LoginCredentials", i + 1, j);
				}
		}
		return arr;
	}
}
