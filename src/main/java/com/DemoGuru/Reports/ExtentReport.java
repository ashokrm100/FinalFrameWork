package com.DemoGuru.Reports;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	

	public static ExtentReports getExtentReports()
	{
		String path = System.getProperty("user.dir")+"//Reports/kusha.html";
		String xmlpath= System.getProperty("user.dir")+"\\src\\resources\\extent-config.xml";
		reporter = new ExtentSparkReporter(path);
		reporter.loadXMLConfig(xmlpath);
		//reporter.config().setDocumentTitle("DemoGuru Manager Login");
		//reporter.config().setReportName("Frame work Design");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Name", "Automation");
		extent.setSystemInfo("Host","LocalHost");
		extent.setSystemInfo("Tester", "Ashok Kumar");
		extent.setSystemInfo("Environment","QA");
		return extent;
		
	}
}
