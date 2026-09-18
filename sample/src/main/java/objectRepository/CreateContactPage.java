package objectRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

import genericUtility.WebdriverUtility;

public class CreateContactPage extends WebdriverUtility {
	WebDriver driver;
	//Initialization(constructor)
	public CreateContactPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement ContactLink;
	
	@FindBy(name = "firstname")
	private WebElement FirstNameTextFeild;
	
	@FindBy(name="lastname")
	private WebElement LastNameTextFeild;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement OrgName;
	
	
	@FindBy(xpath ="(//input[@type='radio'])[1]")
	private WebElement RadioButton;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement FnameTitle;
	
	@FindBy(xpath="//input[@name='support_start_date']")
	private WebElement SupportstartDate;
	
	@FindBy(xpath="//input[@name='support_end_date']")
	private WebElement SupportEndDate;
	
	public void SupportSt_EndDate() {

		
	    Date dateobj = new Date();

	    SimpleDateFormat sim = new SimpleDateFormat("yyyy/MM/dd");

	    String StartDate = sim.format(dateobj);

	    Calendar cal = sim.getCalendar();
	    cal.add(Calendar.DAY_OF_MONTH, 30);

	    String dateEnd = sim.format(cal.getTime());

	    SupportstartDate.click();
	    SupportstartDate.sendKeys(Keys.CONTROL + "a");
	    SupportstartDate.sendKeys(StartDate);

	    SupportEndDate.click();
	    SupportEndDate.sendKeys(Keys.CONTROL + "a");
	    SupportEndDate.sendKeys(dateEnd);
	}
	public WebElement getSupportstartDate() {
		return SupportstartDate;
	}
	public WebElement getSupportEndDate() {
		return SupportEndDate;
	}
	public void FNtitle(String value) {
		toSelectByValue(FnameTitle, value);
	}
	public WebElement getContactLink() {
		return ContactLink;
	}
	public WebElement getFirstNameTextFeild() {
		return FirstNameTextFeild;
	}

	public WebElement getLastNameTextFeild() {
		return LastNameTextFeild;
	}


	public WebElement getRadioButton() {
		return RadioButton;
	}


	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public WebElement getOrgName() {
		return OrgName;
	}

	public WebElement getFnameTitle() {
		return FnameTitle;
	}
	
		
	

}
