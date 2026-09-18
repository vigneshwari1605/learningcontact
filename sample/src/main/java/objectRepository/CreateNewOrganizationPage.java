package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	WebDriver driver;

	// Initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement OrgName;

	@FindBy(xpath = "//input[@name='assigntype' and @value='U']")
	private WebElement assignedUser;

	@FindBy(xpath = "//input[@name='assigntype' and @value='T']")
	private WebElement assignedGroup;

	@FindBy(xpath = "//input[@name='website' ]")
	private WebElement website;

	@FindBy(id = "phone")
	private WebElement phone;

	@FindBy(xpath = "//select[@name='industry' ]")
	private WebElement industrySelect;

	@FindBy(xpath = "//input[@value='  Save  ' ]")
	private WebElement saveButton;

	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement type;

	public void createorg(String orgName) {
		OrgName.sendKeys(orgName);
		saveButton.click();
	}

	public void createorg(String orgName, String industry, String type) {
		OrgName.sendKeys(orgName);
		Select sc = new Select(industrySelect);
		sc.selectByVisibleText(industry);
		saveButton.click();
	}

	public WebElement getOrgName() {
		return OrgName;
	}
	public WebElement getType() {
		return type;
	}
	public WebElement getAssignedUser() {
		return assignedUser;
	}
	public WebElement getAssignedGroup() {
		return assignedGroup;
	}
	public WebElement getWebsite() {
		return website;
	}
	public WebElement getPhone() {
		return phone;
	}

	public WebElement getIndustrySelect() {
		return industrySelect;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

}
