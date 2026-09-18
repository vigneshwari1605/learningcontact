package learning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Retryanalyserexample {
	@Test(retryAnalyzer =genericUtility.RetryAnalyser.class)
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		Assert.assertEquals("Login", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}

}
