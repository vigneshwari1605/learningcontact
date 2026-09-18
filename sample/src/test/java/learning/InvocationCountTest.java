package learning;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount = 5)
	public void createcontactTest() {
		System.out.println("execute createContact test");
	}
	@Test //(enabled = false)
	public void createcontactwithMobilenumtest1() {
		System.out.println("sample execute test");
	}
}
