package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;

public class GetProductInfoExcel {
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName,String ProductName) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		//search for product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		//create product info
		//String path ="//span[text()='"+ProductName+"']/../../../../div[3]/div/div/div/div/div/a/span/span[1]";
		 String path =
		            "//span[contains(text(),'" + ProductName + 
		            "')]/ancestor::div[@data-component-type='s-search-result'][1]" +
		            "//span[contains(@class,'a-price-whole')]";
		Thread.sleep(2000);
		String price=driver.findElement(By.xpath(path)).getText();
		System.out.println(price);
		driver.quit();
		
	}
	@DataProvider
	public Object[][] getData() throws Exception{
		
		ExcelUtility ex=new ExcelUtility();
		int rowcount=ex.getRowCount("product");
		Object[][] obj=new Object[rowcount][2];
		for(int i=0;i<rowcount-1;i++) {
		obj[i][0]=ex.readDataFromExcel("product", i+1, 0);
		obj[i][1]=ex.readDataFromExcel("product", i+1, 1);
		}
		
		
		return obj;
	}

}
