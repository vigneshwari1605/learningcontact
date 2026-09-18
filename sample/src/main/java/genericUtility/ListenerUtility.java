package genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import baseClass.BaseClassliste;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenerUtility implements ITestListener,ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) 
	{
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("CRM test suite Results");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information & create test
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("======"+result.getMethod().getMethodName()+"=====");
	test = report.createTest(result.getMethod().getMethodName());
	UtilityClassObject.setTest(test);
	test.log(Status.INFO, result.getMethod().getMethodName()+"started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("done execution");
		ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, result.getMethod().getMethodName()+"completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)BaseClassliste.sdriver;
		String temp= ts.getScreenshotAs(OutputType.BASE64);
		String time =new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(temp,testName+" "+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
}
