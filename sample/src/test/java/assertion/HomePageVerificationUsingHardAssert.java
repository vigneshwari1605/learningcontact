package assertion;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationUsingHardAssert {
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName()+ "Test Start");
		String expectedresult="Home";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		Assert.assertEquals(actTitle, expectedresult);
		driver.close();
		System.out.println(mtd.getName()+"Test end");
	}
	@Test
	public void logohomePageTest(Method mtd) {
		System.out.println(mtd.getName()+ "Test Start");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean result = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		assertTrue(result);
		driver.close();
		System.out.println(mtd.getName()+"Test end");
	}
}
