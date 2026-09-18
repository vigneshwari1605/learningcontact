package learning;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotations {

	@BeforeSuite
	public void configureBS() {
		System.out.println("Before suite for Database connection");
		
	}
	@BeforeClass
	public void configureBC() {
		System.out.println("Before class for launchingBrowser");
		
	}
	@BeforeMethod
	public void configureBM() {
		System.out.println("BeforeMethod for login");
	}
	@Test
	public void ContactTest() {
		System.out.println("Test script");
	}
	@Test
	public void ContactTestWithData() {
		System.out.println("D");
	}
	@AfterMethod
	public void configureAM() {
		System.out.println("After method for logout");
	}
	@AfterClass
	public void configureAc() {
		System.out.println("Afterclass for close browser");
	}
	@AfterSuite
	public void configureAs() {
		System.out.println("Aftersuite for DB close");
	}
}
