package learning;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_CreateContact2 {
	@Test (dataProvider = "getData")
	public void createContactTest(String firstname,String lastname, Long phno) {
		System.out.println("FirstName:"+firstname+ " " +"LastName: "+lastname+" Ph no: "+ phno );
	}

	@DataProvider
	public Object[][] getData(){
		Object[][] obj=new Object[3][3];
		obj[0][0]="deepak";
		obj[0][1]="a";
		obj[0][2]=1234567890l;
		
		obj[1][0]="nive";
		obj[1][1]="m.r";
		obj[1][2]= 9876543210l;
		
		obj[2][0]="mr.";
		obj[2][1]="vicky";
		obj[2][2]= 9988776655l;
		
		return obj;
	}
}
