package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebdriverUtility;

public class HomePage {
	WebDriver driver;
	   public HomePage(WebDriver driver) {
	    this.driver = driver;
		PageFactory.initElements(driver, this);
 }
	@FindBy(linkText = "Organizations")
	private WebElement organization;
	
	@FindBy(linkText = "Contacts")
	private WebElement contacts;

	@FindBy(linkText = "Opportunities")
	private WebElement opportunities;

	@FindBy(linkText = "Campaigns")
	private WebElement Campaignlnk;

	@FindBy(linkText = "more")
	private WebElement morelink;

	@FindBy(linkText = "Products")
	private WebElement products;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	@FindBy(xpath= "//a[text()='Sign Out']")
	private WebElement signoutlink;

	public void navigateToCampaignPAge() {
		Actions act = new Actions(driver);
		act.moveToElement(morelink).perform();
		Campaignlnk.click();
	}
	public void signout() {
		//Actions act = new Actions(driver);
		WebdriverUtility wu=new WebdriverUtility();
		wu.toMoveToElement(driver,adminimg);
		//act.moveToElement(adminimg).perform();
		signoutlink.click();
	}

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getOpportunities() {
		return opportunities;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	public WebElement getCampaignlnk() {
		return Campaignlnk;
	}

	public WebElement getMorelink() {
		return morelink;
	}
	public WebElement getAdminimg() {
		return adminimg;
	}

}
