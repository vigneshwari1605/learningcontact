package vtiger_contact;

import org.openqa.selenium.WebDriver;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.WebdriverUtility;
import objectRepository.ContactPage;
import objectRepository.CreateContactPage;
import objectRepository.LoginPage;

public class CreateContactWithFirstname {
	public static void main(String[] args) throws Exception{
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
		
		//navigate to contact link
		ContactPage cp=new ContactPage(driver);
		cp.getContactPage().click();
		
		String firstname=eu.readDataFromExcel("contact", 1, 1)+ju.randomInputs();
		String lastname=eu.readDataFromExcel("contact", 1, 2)+ju.randomInputs();
		
		//create new contact
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getContactLink().click();
		ccp.getFirstNameTextFeild().sendKeys(firstname);
		ccp.getLastNameTextFeild().sendKeys(lastname);
		ccp.getSaveButton().click();

}

}
