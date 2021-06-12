package com.DemoGuru.Utility;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
//import com.DemoGuru.TestCases.ManagerLoginTest;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.DemoGuru.Reports.ExtentReport;
import com.DemoGuru.TestBase.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ItestListener extends BaseTest implements ITestListener {
	
	ExtentReports extent = ExtentReport.getExtentReports();
	ExtentTest test;
	Logger Log = LogManager.getLogger(ItestListener.class.getName());
	//ManagerLoginTest mt;
	Logs lg;
	String name;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test = extent.createTest(result.getMethod().getMethodName());
		name=result.getName();
		lg.onStartLog(name);
		}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.PASS, "Test case executed successfully " +name);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, result.getThrowable());
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		test.fail("Fail o Fail");
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ "- Test Case Failed",ExtentColor.RED));
		String screenPathString=getScreenShot(result.getName(), driver);
		try {
			
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"-Failed Screenshot",ExtentColor.RED)).
		addScreenCaptureFromPath(screenPathString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		lg.onFinishLog(name);
		extent.flush();
	}

}
