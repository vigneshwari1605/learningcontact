package com.comcast.crm.orgTest.java;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseclass.BaseClass;
import genericUtility.ListenerUtility;
import genericUtility.UtilityClassObject;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.CreateOrganizationLink;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;

@Listeners(genericUtility.ListenerUtility.class)
public class CreateOrgTest extends BaseClass{
	
	@Test(groups = "SmokeTest")
	public void CreateOrgTest() throws Exception  {
		
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		//read testScript data from ExcelFile
		String orgName=ex.readDataFromExcel("org", 1, 2)+ju.randomInputs();
		
		//step2: navigate to Organization module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create org");
		HomePage hp=new HomePage(driver);
		 hp.getOrganization().click();
		 
		 //step3: Click on create organization button
		 UtilityClassObject.getTest().log(Status.INFO,"create new org");
		 CreateOrganizationLink cp=new CreateOrganizationLink(driver);
		 cp.getCreateOrganization().click();
		 
		 //enter all details & create new organization
		 CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		 cnp.createorg(orgName);
		 
		 //verify Header msg expected result
		 OrganizationInfoPage op=new OrganizationInfoPage(driver);
		 String actorgname=op.getHeaderMsg().getText();
		 Assert.assertEquals(true, actorgname.contains(orgName));
			/*
			 * if(actorgname.contains(orgName)) { System.out.println(orgName+"verified"); }
			 * else { System.out.println("not Verified"); }
			 */
}
	@Test(groups="RegressionTest")
	public void CreateOrgWithIndustry() throws Exception {
		HomePage hp=new HomePage(driver);
		 hp.getOrganization().click();
		 
		 //step3: Click on create organization button
		 CreateOrganizationLink cp=new CreateOrganizationLink(driver);
		 cp.getCreateOrganization().click();
		 String orgName=ex.readDataFromExcel("org", 1, 2)+ju.randomInputs();
		 String phno=ex.readDataFromExcel("org", 7, 3);
		 String industry=ex.readDataFromExcel("org", 4, 3);
		 String type=ex.readDataFromExcel("org", 4, 4);
		 CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		 cnp.createorg(orgName);
		 cnp.getPhone().sendKeys(phno);
		 cnp.getIndustrySelect().sendKeys(industry);
		 cnp.getType().sendKeys(type);
		 //verify Header msg
		 OrganizationInfoPage op=new OrganizationInfoPage(driver);
		 String actorgname=op.getHeaderMsg().getText();
		 System.out.println(actorgname);
	}
	
	@Test
	public void createOrgWithPhno() throws Exception {
		
		String orgName=ex.readDataFromExcel("org", 1, 2)+ju.randomInputs();
		 String phno=ex.readDataFromExcel("org", 7, 3);
		 HomePage hp=new HomePage(driver);
		 hp.getOrganization().click();
		 
		 //step3: Click on create organization button
		 CreateOrganizationLink cp=new CreateOrganizationLink(driver);
		 cp.getCreateOrganization().click();
		 
		 CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		 cnp.createorg(orgName);
		 cnp.getPhone().sendKeys(phno);
		
		 //verify Header orgname
		 OrganizationInfoPage op=new OrganizationInfoPage(driver);
		 String actorgname=op.getHeaderMsg().getText();
		 Assert.assertEquals(true,actorgname.contains(orgName));
			/*
			 * if(actorgname.contains(orgName)) { System.out.println(orgName+"verified"); }
			 * else { System.out.println("not Verified"); }
			 */
		  
		 	}

}
