package genericUtility;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBAseUtility {
	Connection con;
	
	public Connection getDbConnection(String url, String un, String pwd) throws SQLException {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		return DriverManager.getConnection(url, un, pwd);
	}
	
	public boolean validdateDataEntry(String url, String un, String pwd, String tName, String cName, String data)throws Exception {
		 con=getDbConnection(url,un, pwd);
		Statement s = con.createStatement();
		return s.execute("select * from"+tName+"where"+cName+"='"+data+"'");
	}
	public ResultSet readDataFromDb(String pwd, String un, String url,String query) throws Exception {
		Connection con=getDbConnection(url, un, pwd);
		Statement s = con.createStatement();
		return s.executeQuery(query);
	}
	
	public void closeConnection(Connection con)throws Exception{
		con.close();
	}	
}
