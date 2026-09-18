package learning;

import org.testng.annotations.Test;

public class DependsOnMethods {
	@Test
	public void CreateOrderTest() {
		System.out.println("Execute createorder of test==>132");
		/*
		 * String str=null; System.out.println(str.equals("123"));
		 */
	}
	
	@Test (dependsOnMethods="CreateOrderTest")
	public void BillingOrderTest() 
	{
		System.out.println("Execute billingorder of test==>123");
	}
	//after giving depends on methods it will not execute in alphabetical 
	//order but it will execute based on depends on method so if the method
	//gets pass only the next method will execute

}
