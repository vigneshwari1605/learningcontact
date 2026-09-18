package learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class sampleTest {

	public static void main(String[] args) throws SQLException {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//connect to database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8888/projects", "root", "root");
		System.out.println("done");
	}
}
