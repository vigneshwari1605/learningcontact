package vtiger;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.WebdriverUtility;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.CreateOrganizationLink;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;

public class CreateOrganizationWithIndustry {
	
	public static void main(String[] args) throws Exception {
		WebdriverUtility wu=new WebdriverUtility();
		
		JavaUtility ju=new JavaUtility();
		FileUtility fu=new FileUtility();
		 //read common data from properties file
		 String BROWSER = fu.readDataFromPropertyFile("browser");
		 String URL = fu.readDataFromPropertyFile("url");
		 String USERNAME = fu.readDataFromPropertyFile("username");
		 String PASSWORD = fu.readDataFromPropertyFile("password");
		 
		 String orgName=fu.readDataFromExcel("org", 1, 2)+ju.randomInputs();
		 String phno=fu.readDataFromExcel("org", 7, 3);
		 String industry=fu.readDataFromExcel("org", 4, 3);
		 String type=fu.readDataFromExcel("org", 4, 4);
		 WebDriver driver;
		 if(BROWSER.equalsIgnoreCase("chrome"))
			 driver=new ChromeDriver();
		 else if(BROWSER.equalsIgnoreCase("firefox"))
			 driver=new FirefoxDriver();
		 else if(BROWSER.equalsIgnoreCase("edge"))
			 driver=new EdgeDriver();
		 else 
			 driver=new ChromeDriver();
		 
		 //login to app
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get(URL);
		 LoginPage lp=new LoginPage(driver);
		 lp.Login(USERNAME, PASSWORD);
		 
		 //step 2: navigate to Organization page
		 HomePage hp=new HomePage(driver);
		 hp.getOrganization().click();
		 
		 //step3: Click on create organization button
		 CreateOrganizationLink cp=new CreateOrganizationLink(driver);
		 cp.getCreateOrganization().click();
		 
		 CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		 cnp.createorg(orgName);
		 cnp.getPhone().sendKeys(phno);
		 cnp.getIndustrySelect().sendKeys(industry);
		 cnp.getType().sendKeys(type);
		 //verify Header msg
		 OrganizationInfoPage op=new OrganizationInfoPage(driver);
		 String actorgname=op.getHeaderMsg().getText();
		 
		
		
		
	}

}
