package com.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExeReport2 {
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest logger1;
	@BeforeClass
	public void startTest1()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
		
		String path=System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html";
		reporter=new ExtentHtmlReporter(path);
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("hostname","localhost");
		reports.setSystemInfo("Environment","Testing Env");
		reports.setSystemInfo("Username","avilala");
		
		reporter.config().setDocumentTitle("The title of the document is here");
		reporter.config().setReportName("Next Gen Testing Report");
		reporter.config().setTheme(Theme.DARK);
		
}
	
	@AfterClass
	public void endTest()
	{
		reports.flush();
	}
	@AfterMethod
	public void captureStatus(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger1.log(Status.PASS,  result.getMethod().getMethodName()+"test is passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			logger1.log(Status.FAIL, result.getMethod().getMethodName()+"test is failed");
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger1.log(Status.SKIP, result.getMethod().getMethodName()+"test is skipped");
		}
	}
	@Test
	public void passTest()
	{
		logger1=reports.createTest("Pass Test");
		Assert.assertTrue(true);
		
	}
	@Test
	public void failTest()
	{
		logger1=reports.createTest("Fail Test");
		Assert.assertTrue(false);
	}
	@Test
	public void skipTest()
	{
		logger1=reports.createTest("Skip Test");
		throw new SkipException("Explicitly throw new Skip Exception");
	}
}



