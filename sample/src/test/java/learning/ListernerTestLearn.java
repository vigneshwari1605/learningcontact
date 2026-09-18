package learning;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass.BaseClassliste;

@Listeners(genericUtility.ListenerUtility.class)
public class ListernerTestLearn  extends BaseClassliste{

	@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	@Test
	public void createInvoicewithContactTest() {
		System.out.println("execute create InvoiceWithTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
