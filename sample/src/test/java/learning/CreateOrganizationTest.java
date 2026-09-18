package learning;

import org.openqa.selenium.WebDriver;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.WebdriverUtility;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.CreateOrganizationLink;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateOrganizationTest {
public static void main(String[] args) throws Exception {
	//create Object
	WebdriverUtility wu=new WebdriverUtility();
	ExcelUtility eu=new ExcelUtility();
	JavaUtility ju=new JavaUtility();
	PropertyUtility pu=new PropertyUtility();
	
	//read common data from properties file
	String BROWSER=pu.readDataFromPropertyFile("browser");
	String URL=pu.readDataFromPropertyFile("url");
	String USERNAME=pu.readDataFromPropertyFile("username");
	String PASSWORD=pu.readDataFromPropertyFile("password");
	WebDriver driver=wu.launchBrowser("browser");
	LoginPage lp=new LoginPage(driver);
	wu.getUrl(URL);
	lp.Login(USERNAME, PASSWORD);
	
	//navigate to organization link
	HomePage hp=new HomePage(driver);
	
	//click on create organization button
	hp.getOrganization().click();
	
	CreateOrganizationLink orglink=new CreateOrganizationLink(driver);
	orglink.getCreateOrganization().click();
	
	//enter all details &create new organization
	CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
	String orgname=eu.readDataFromExcel("org", 1, 2)+ju.randomInputs();
	cno.getOrgName().sendKeys(orgname);
	cno.getSaveButton().click();
	
	
	
}
}
