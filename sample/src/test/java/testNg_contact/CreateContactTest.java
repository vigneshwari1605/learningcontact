package testNg_contact;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import baseclass.BaseClass;
import objectRepository.ContactPage;
import objectRepository.CreateContactPage;
import objectRepository.HomePage;

public class CreateContactTest extends BaseClass {

	@Test(groups="SmokeTest")
	public void createContactTest() throws Exception{
		//read testScript data From Excel
		String firstname=ex.readDataFromExcel("contact", 1, 1);
		
		String lastname=ex.readDataFromExcel("contact", 1, 2)+ju.randomInputs();
		//step:navigate to Contact module
		HomePage hp=new HomePage(driver);
		hp.getContacts().click();
		//step3 click on "Create contact page" button
		ContactPage cp=new ContactPage(driver);
		cp.getContactPage().click();
		//step4:enter all details & create new contactpage
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getContactLink().click();
		ccp.getLastNameTextFeild().sendKeys(lastname);
		ccp.getSaveButton().click();
		String actHeader=cp.getheaderMsg().getText();
		boolean status = actHeader.contains(lastname);
		Assert.assertEquals(status, true);
		
		String actLastName=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actLastName, lastname);
		soft.assertAll();
	}
}
