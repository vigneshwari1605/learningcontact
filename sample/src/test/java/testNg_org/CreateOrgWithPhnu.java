package testNg_org;

import org.testng.annotations.Test;
import baseclass.BaseClass;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.CreateOrganizationLink;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;

public class CreateOrgWithPhnu extends BaseClass{
	@Test(groups="RegressionTest")
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
		 
		 if(actorgname.contains(orgName)) {
			 System.out.println(orgName+"verified");
		 }
		 else
		 {
			 System.out.println("not Verified");
		 }
		 
		 
		 
	}

}
