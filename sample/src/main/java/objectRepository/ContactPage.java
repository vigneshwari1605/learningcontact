package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement ContactPage;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	//Initialization
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	public WebElement getheaderMsg(){
		return headerMsg;
		
	}
	public WebElement getContactPage() {
		return ContactPage;
	}

}
