package com.DemoGuru.Utility;

import org.apache.logging.log4j.LogManager;
//import com.DemoGuru.TestCases.ManagerLoginTest;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.DemoGuru.TestBase.BaseTest;

public class ItestListener extends BaseTest implements ITestListener {
	
	Logger Log = LogManager.getLogger(ItestListener.class.getName());
	//ManagerLoginTest MT;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String name= result.getMethod().getMethodName();
		System.out.println("Test Name" +name);
		//MT = new ManagerLoginTest();
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("-------------- Test Completed: Test Method name---------" +result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
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
		
	}

}
