package learning;

import org.testng.annotations.Test;

public class OrderTest {
	
	@Test
	public void CreateOrderTest() {
		System.out.println("Execute createorderTest==>123");
	}

	@Test
	public void BillingAnOrderTest() {
		System.out.println("Execute billing order test==>123");
	}
	//before creatingOrder it is going for billing order so obviously 
	//test script will fail in RTS
}
