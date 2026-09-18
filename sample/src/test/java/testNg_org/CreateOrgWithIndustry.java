package testNg_org;

import org.testng.annotations.Test;
import baseclass.BaseClass;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.CreateOrganizationLink;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;

public class CreateOrgWithIndustry extends BaseClass{

	@Test
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
	
}
