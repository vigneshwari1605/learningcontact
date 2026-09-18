package com.comcast.crm.contactTest.java;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseclass.BaseClass;
import objectRepository.ContactPage;
import objectRepository.CreateContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.CreateOrganizationLink;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;

@Listeners(genericUtility.ListenerUtility.class)
public class CreateContactTest extends BaseClass{
	
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
		//verify header phnum
		String actHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		boolean status=actHeader.contains(lastname);
		Assert.assertEquals(status,true);
		
		
		String actLastName=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actLastName,lastname );
		
	}
	
	@Test(groups="RegressionTest")
	public void createContactWithorg() throws Exception{
		String firstname=ex.readDataFromExcel("contact", 1, 1);
		String lastname=ex.readDataFromExcel("contact", 1, 2)+ju.randomInputs();
		String orgName=ex.readDataFromExcel("org", 7, 2)+ju.randomInputs();
		String contact=ex.readDataFromExcel("org", 7, 3);
		HomePage hp=new HomePage(driver);
		 hp.getOrganization().click();
		 
		 //step3: Click on create organization button
		 CreateOrganizationLink cop=new CreateOrganizationLink(driver);
		 cop.getCreateOrganization().click();
		 
		 CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		 cnp.createorg(orgName);
		 cnp.getPhone().sendKeys(contact);
		 
		 //verify header name
		 Thread.sleep(2000);
		 String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if(headerInfo.contains(orgName)) {
			 System.out.println("pass");
		 }
		 else {
			 System.out.println("failed");
		 }
		
		//navigate to contact link
				ContactPage cp=new ContactPage(driver);
				cp.getContactPage().click();
				
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getContactLink().click();
		ccp.getFirstNameTextFeild().sendKeys(firstname);
		ccp.getLastNameTextFeild().sendKeys(lastname);
		//organization name
		ccp.getOrgName().click();
		//switch to child window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			
			
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains("module=Accounts"))
				break;
		}
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		//swithch to ARENTWINDO
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		while(it1.hasNext()) {
			String windowId = it1.next();
			driver.switchTo().window(windowId);
			
			
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains("Contacts&action"))
				break;
		}
		ccp.getSaveButton().click();
		OrganizationInfoPage op=new OrganizationInfoPage(driver);
		 String actorgname=op.getHeaderMsg().getText();
		 
		 if(actorgname.contains(orgName)) {
			 System.out.println(orgName+"verified");
		 }
		 else
		 {
			 System.out.println("not Verified");
		 }
		
		
	}
	
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
		ccp.getSaveButton().click();
	}
	

}
