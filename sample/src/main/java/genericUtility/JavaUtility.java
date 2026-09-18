package genericUtility;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
public class JavaUtility {
	
	public int randomInputs() {
		Random r=new Random();
		int randomnum=r.nextInt();
		return randomnum;
	}
	public String currentDate() {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(d);
	}
	
	
}
