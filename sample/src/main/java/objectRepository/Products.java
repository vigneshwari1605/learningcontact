package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createproductbuttonlink;
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productname;
	

	public WebElement getCreateproductbutton() {
		return createproductbuttonlink;
		
	}
}
