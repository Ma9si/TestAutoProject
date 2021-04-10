package Project;

import org.testng.annotations.DataProvider;

public class LogInDetails {
	
	@DataProvider (name="logindp")
	public static Object[][] dp() {
		
		Object data[][] = new Object[1][2];
		
		//Data of 1 row
		data[0][0] = "ma9si.07";
		data[0][1] = "***";
		
		
		
		return data;
	}
	

}