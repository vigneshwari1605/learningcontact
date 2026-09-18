package baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import genericUtility.DataBAseUtility;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.UtilityClassObject;
import genericUtility.WebdriverUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;


public class BaseClass {
	public WebdriverUtility wb=new WebdriverUtility();
	public DataBAseUtility db=new DataBAseUtility();
	public ExcelUtility ex=new ExcelUtility();
   public PropertyUtility pu=new PropertyUtility();
	public JavaUtility ju=new JavaUtility();
	public WebDriver driver;
	public static WebDriver sdriver; //for listenerUtility
	public ExtentSparkReporter spark;
	public ExtentReports report;
	
	
	@BeforeSuite(groups= {"SmokeTest","RegressionTest"})
	public void ConfigureBs() throws Exception {
		System.out.println("Database connection");
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
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"SmokeTest","RegressionTest"})
	public void ConfigureBc(/*String browser*/) throws Exception {
		//String Browser=browser;
		String Browser=pu.readDataFromPropertyFile("browser");
		if(Browser.equalsIgnoreCase("chrome"))
			 driver=new ChromeDriver();
		 else if(Browser.equalsIgnoreCase("firefox"))
			 driver=new FirefoxDriver();
		 else if(Browser.equalsIgnoreCase("edge"))
			 driver=new EdgeDriver();
		 else 
			 driver=new ChromeDriver();
		sdriver=driver;
		UtilityClassObject.setdriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
	}
	@BeforeMethod(groups= {"SmokeTest","RegressionTest"})
	public void ConfigureBm() throws Exception {
		
		String URL=pu.readDataFromPropertyFile("url");
		String USERNAME=pu.readDataFromPropertyFile("username");
		String PASSWORD=pu.readDataFromPropertyFile("password");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
	}
	@AfterMethod(groups = {"SmokeTest", "RegressionTest"})
	public void ConfigureAm()   {
	        HomePage hp = new HomePage(driver);
	        hp.signout();
	        
	}

	
	@AfterClass(groups = {"SmokeTest", "RegressionTest"})
	public void ConfigureAc() {

	    System.out.println("Quitting browser");
	        driver.quit();
	    
	}
	@AfterSuite(groups= {"SmokeTest","RegressionTest"})
	public void ConfigureAs() throws Exception {
		//db.closeConnection(null);
		System.out.println("Db close");
		report.flush();
	}

}
