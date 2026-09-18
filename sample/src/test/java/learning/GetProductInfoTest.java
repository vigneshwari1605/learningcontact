package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class GetProductInfoTest {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName,String ProductName) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		//search for product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		//create product info
		String path ="//span[text()='"+ProductName+"']/../../../../div[3]/div/div/div/div/div/a/span/span[1]";
		Thread.sleep(2000);
		String price=driver.findElement(By.xpath(path)).getText();
		System.out.println(price);
		
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] obj=new Object[3][2];
		obj[0][0]="Google";
		obj[0][1]="Pixel 6 (Black, 8GB RAM, 128GB Storage)";
		
		obj[1][0]="Google";
		obj[1][1]="Pixel 10 5G (Obsidian, 12GB RAM, 256GB Storage)";
		
		obj[2][0]="Google";
		obj[2][1]="Pixel 11 5G (Pistachio) | 12GB RAM, 256GB Storage";
		
		return obj;
	}
}
