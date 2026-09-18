package assertion;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LearnSoftAssertion {
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName()+ "Test Start");
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		sa.assertEquals("Home","Homepage");
		System.out.println("Step3");
		System.out.println("Step4");
		sa.assertAll();
		System.out.println(mtd.getName()+"Test end");
	}
	@Test
	public void learnHardAssert(Method mtd) {
		System.out.println(mtd.getName()+ "Test Start");
		System.out.println("Step1");
		System.out.println("Step2");
		assertEquals("home", "Home");
		System.out.println("Step3");
		System.out.println("Step4");
		System.out.println(mtd.getName()+"Test end");
	}

}
