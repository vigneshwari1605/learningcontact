package learning;

import org.testng.annotations.Test;

public class PriorityTest {

	@Test(priority=-1)
	public void CreateContactTest() {
		System.out.println("execut create contact with HDFC");
	}
	@Test(priority=1)
	public void ModifyContactTest() {
		System.out.println("create contact ICICI");
		System.out.println("execut modify contact -->hdfc-->ICICI");
	}
	@Test(priority=2)
	public void DeleteContactTest() {
		System.out.println("create UPI contact");
		System.out.println("execut delete contact-->ICICI");
	}
}
