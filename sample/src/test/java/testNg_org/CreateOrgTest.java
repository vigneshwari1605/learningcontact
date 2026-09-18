package testNg_org;

import org.testng.annotations.Test;
import baseclass.BaseClass;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.CreateOrganizationLink;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;

public class CreateOrgTest extends BaseClass {
	@Test(groups="SmokeTest")
	public void CreateOrgTest() throws Exception  {
		
		HomePage hp=new HomePage(driver);
		 hp.getOrganization().click();
		 
		 //step3: Click on create organization button
		 CreateOrganizationLink cp=new CreateOrganizationLink(driver);
		 cp.getCreateOrganization().click();
		 String orgName=ex.readDataFromExcel("org", 1, 2)+ju.randomInputs();
		 CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		 cnp.createorg(orgName);
		 
		 //verify Header msg
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
}
