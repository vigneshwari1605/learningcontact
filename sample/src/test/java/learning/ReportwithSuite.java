package learning;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportwithSuite {
ExtentReports report;
	@BeforeSuite
	public void configbs() {
		//spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM test suite Results");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information & create test
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	
	@AfterSuite
	public void configas() {
		report.flush();
		
	}
	@Test
	public void createContactTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		//takeScreenshot
		TakesScreenshot ts=(TakesScreenshot) driver;
		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("createContactTest");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.INFO,"contact is created ");
		}
		else {
		test.addScreenCaptureFromBase64String(filepath,"ErrorFile");
		}
	}
	@Test
	public void createContactTestwithnum() {
		ExtentTest test = report.createTest("createContactTest");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.INFO,"contact is created ");
		}
		else {
		test.log(Status.INFO,"Not created");
		}}
	@Test
	public void createContactTestwithorg() {
		ExtentTest test = report.createTest("createContactTest");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.INFO,"contact is created ");
		}
		else {
		test.log(Status.INFO,"Not created");
		}}
}
