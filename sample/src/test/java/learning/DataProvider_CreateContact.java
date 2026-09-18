package learning;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_CreateContact {
	@Test (dataProvider = "getData")
	public void createContactTest(String firstname,String lastname) {
		System.out.println("FirstName:"+firstname+ " " +"LastName:"+lastname );
	}

	@DataProvider
	public Object[][] getData(){
		Object[][] obj=new Object[3][2];
		obj[0][0]="deepak";
		obj[0][1]="a";
		
		obj[1][0]="nive";
		obj[1][1]="m.r";
		
		obj[2][0]="mr.";
		obj[2][1]="vicky";
		
		return obj;
	}
}
