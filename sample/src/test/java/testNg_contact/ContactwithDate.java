package testNg_contact;

import org.testng.annotations.Test;

import baseclass.BaseClass;
import objectRepository.ContactPage;
import objectRepository.CreateContactPage;

public class ContactwithDate extends BaseClass {
	@Test(groups="RegressionTest")
	public void createContactwithDate() throws Exception {
		ContactPage cp=new ContactPage(driver);
		cp.getContactPage().click();
		
		String firstname=ex.readDataFromExcel("contact", 1, 1);
		String lastname=ex.readDataFromExcel("contact", 1, 2)+ju.randomInputs();
		
		//create new contact
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getContactLink().click();
		ccp.getFirstNameTextFeild().sendKeys(firstname);
		ccp.getLastNameTextFeild().sendKeys(lastname);
		
		ccp.SupportSt_EndDate();
		
		//driver.findElement(By.xpath("//img[@id='jscal_trigger_birthday']")).click();
		
		
		
		ccp.getSaveButton().click();
	}
	

}
