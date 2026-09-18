package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement HeaderMsg;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement SavedHeadermsg;
	

	public WebElement getSavedHeadermsg() {
		return SavedHeadermsg;
	}


	public WebElement getHeaderMsg() {
		return HeaderMsg;
	}
}
